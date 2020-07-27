package sample.web;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.ApiOperation;
import sample.config.PDFExportConfig;
import sample.model.FileProperties;
import sample.model.JsonArrayResult;
import sample.model.PdfModel;
import sample.model.Picture;
import sample.model.ProjectString;
import sample.service.ProjectExportService;
import sample.service.ProjectService;

@RestController
public class ExportController {

  private static final Logger logger = LoggerFactory.getLogger(ExportController.class);

  @Autowired
  private ProjectExportService projectExport;

  @Autowired
  private ProjectService projectService;

  @Autowired
  private PDFExportConfig pdfExportConfig;

  @Autowired
  private FileProperties fileProperties;


  /**
   * PDF 文件导出 使用 a 链接即可下载;如果为 ajax/vue,则需要转换为 form 表单格式 eg:
   * http://${apiAddress}/api/demo/common/export?key1=${key}&key2=${key2}
   */

  @GetMapping(value = "/export")
  @ApiOperation(value = "导出PDF", notes = "导出PDF")
  public Object export(@RequestParam("id") String id) {
    String[] array = id.split(",");
    List<PdfModel> pdfModels = new ArrayList<PdfModel>();
    for (String idInArray : array) {
      Long idLong = Long.parseLong(idInArray);
      try {
        PdfModel pm = new PdfModel();
        ProjectString pString = projectService.getProjectString(idLong);
        pString.setScope(pString.getScope().replace("<", "&lt;").replace(">", "&gt;"));
        if (pString.getOpenTime().startsWith("1970")) {
          pString.setOpenTime("未知");
        }
        Iterator<Picture> iter = pString.getPictures().iterator();
        while (iter.hasNext()) {
          Picture temp = iter.next();
          BufferedImage sourceImg = null;

          String localUrl = "http://localhost:8086/projects/img/" + temp.getUrl().replace(pdfExportConfig.getUrlPrefix(),"");
          logger.info(localUrl);

          try {
            sourceImg = ImageIO.read(new URL(localUrl).openStream());
          } catch (IOException e) {
            e.printStackTrace();
          }
          if (sourceImg != null) {
            float height = sourceImg.getHeight();
            float width = sourceImg.getWidth();
            if (width / height < 1.3f) {
              width = 700 * width / height;
              temp.setThumbUrl("width: " + width + "px; height: 700px");
            } else {
              temp.setThumbUrl("width: 900px");
            }
          }
          temp.setUrl(localUrl);
        }
        logger.info("pString: " + pString.getPictures().toString());
        String fileName = projectExport.export(pString);
        // String url = ServletUriComponentsBuilder.fromCurrentContextPath().path("/img/").path(fileName).toUriString();
        String url = pdfExportConfig.getUrlPrefix() + fileName;
        pm.setFileName(fileName);
        pm.setFileDownloadUri(url);
        pdfModels.add(pm);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return new JsonArrayResult<PdfModel>(pdfModels);
  }
}

