package sample.service;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import sample.config.PDFExportConfig;
import sample.util.PDFUtil;

/**
 * @Description: 公共业务具体实现类
 * @Author: junqiang.lu
 * @Date: 2018/12/24
 */
@Service("commonService")
public class ProjectExport {

  @Autowired
  private PDFExportConfig pdfExportConfig;

  /**
   * PDF 文件导出
   *
   * @return
   */
  public ResponseEntity<?> export() {
    HttpHeaders headers = new HttpHeaders();

    /**
     * 数据导出(PDF 格式)
     */
    Map<String, Object> dataMap = new HashMap<>(16);
    dataMap.put("statisticalTime", new Date().toString());

    String htmlStr = PDFUtil.freemarkerRender(dataMap, pdfExportConfig.getEmployeeKpiFtl());
    byte[] pdfBytes = PDFUtil.createPDF(htmlStr, pdfExportConfig.getFontSimsun());
    if (pdfBytes != null && pdfBytes.length > 0) {
      String fileName = System.currentTimeMillis() + (int) (Math.random() * 90000 + 10000) + ".pdf";
      headers.setContentDispositionFormData("attachment", fileName);
      headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
      return new ResponseEntity<byte[]>(pdfBytes, headers, HttpStatus.OK);
    }

    headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
    return new ResponseEntity<String>("{ \"code\" : \"404\", \"message\" : \"not found\" }",
        headers, HttpStatus.NOT_FOUND);
  }
}
