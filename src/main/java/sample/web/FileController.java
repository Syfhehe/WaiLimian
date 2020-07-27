package sample.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.ApiOperation;
import sample.config.PDFExportConfig;
import sample.model.JsonArrayResult;
import sample.model.JsonResult;
import sample.model.UploadFileResponse;
import sample.repository.UserRepository;
import sample.service.FileService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FileController {

  private static final Logger logger = LoggerFactory.getLogger(FileController.class);

  @Autowired
  UserRepository userRepository;

  @Autowired
  private FileService fileService;

  @Autowired
  private PDFExportConfig pdfExportConfig;

  @ApiOperation(value = "上传多个文件", notes = "上传多个文件")
  @PostMapping("/upload")
  public JsonArrayResult<UploadFileResponse> uploadMultipleFiles(
      @RequestParam("file") MultipartFile[] file) {
    List<UploadFileResponse> array =
        Arrays.stream(file).map(this::uploadFileMethod).collect(Collectors.toList());
    return new JsonArrayResult<UploadFileResponse>(array);
  }

  public UploadFileResponse uploadFileMethod(@RequestParam("file") MultipartFile file) {
    String fileName = fileService.storeFile(file);

    // String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
    // .path("/downloadFile/").path(fileName).toUriString();
    //
    // String url =
    // ServletUriComponentsBuilder.fromCurrentContextPath().path("/img/").path(fileName)
    // .toUriString();

    String fileDownloadUri = pdfExportConfig.getUrlPrefix() + "downloadFile/" + fileName;

    String url = pdfExportConfig.getUrlPrefix() + fileName;

    return new UploadFileResponse(fileName, url, fileDownloadUri, file.getContentType(),
        file.getSize());
  }

  @ApiOperation(value = "下载文件", notes = "下载文件")
  @GetMapping("/downloadFile/{fileName:.+}")
  public ResponseEntity<Resource> downloadFile(@PathVariable String fileName,
      HttpServletRequest request) {
    // Load file as Resource
    Resource resource = fileService.loadFileAsResource(fileName);

    // Try to determine file's content type
    String contentType = null;
    try {
      contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
    } catch (IOException ex) {
      logger.info("Could not determine file type.");
    }

    // Fallback to the default content type if type could not be determined
    if (contentType == null) {
      contentType = "application/octet-stream";
    }

    return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
        .header(HttpHeaders.CONTENT_DISPOSITION,
            "attachment; filename=\"" + resource.getFilename() + "\"")
        .body(resource);
  }

}
