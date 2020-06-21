package sample.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import sample.service.ProjectExport;

@RestController
public class ExportController {

  private static final Logger logger = LoggerFactory.getLogger(ExportController.class);

  @Autowired
  private ProjectExport projectExport;

  /**
   * PDF 文件导出 使用 a 链接即可下载;如果为 ajax/vue,则需要转换为 form 表单格式 eg:
   * http://${apiAddress}/api/demo/common/export?key1=${key}&key2=${key2}
   */

  @RequestMapping(value = "/projects/export", method = {RequestMethod.POST, RequestMethod.GET},
      produces = MediaType.MULTIPART_FORM_DATA_VALUE)
  @ApiOperation(value = "导出PDF", notes = "导出PDF")
  public ResponseEntity<?> export() {
    try {
      ResponseEntity<?> responseEntity = projectExport.export();
      return responseEntity;
    } catch (Exception e) {
      e.printStackTrace();
    }

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
    return new ResponseEntity<String>("{ \"code\" : \"404\", \"message\" : \"not found\" }",
        headers, HttpStatus.NOT_FOUND);
  }

}

