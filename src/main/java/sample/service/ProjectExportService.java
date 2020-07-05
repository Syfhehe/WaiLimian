package sample.service;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.FileException;
import sample.config.PDFExportConfig;
import sample.model.FileProperties;
import sample.model.ProjectString;
import sample.util.PDFUtil;

/**
 * @Description: 公共业务具体实现类
 * @Author: junqiang.lu
 * @Date: 2018/12/24
 */
@Service("commonService")
public class ProjectExportService {

  @Autowired
  private PDFExportConfig pdfExportConfig;

  private Path fileStorageLocation;

  @Autowired
  public ProjectExportService(FileProperties fileProperties) {
    this.fileStorageLocation =
        Paths.get(fileProperties.getPdfDir()).toAbsolutePath().normalize();
    try {
      Files.createDirectories(this.fileStorageLocation);
    } catch (Exception ex) {
      throw new FileException(
          "Could not create the directory where the uploaded files will be stored.", ex);
    }
  }
  
  public String export(ProjectString prjProject) throws IOException {
    
    Map<String, Object> dataMap = new HashMap<>();
    dataMap.put("prjProject", prjProject);
    String htmlStr = PDFUtil.freemarkerRender(dataMap, pdfExportConfig.getEmployeeKpiFtl());
    byte[] pdfBytes = PDFUtil.createPDF(htmlStr, pdfExportConfig.getFontSimsun());
    
    if (pdfBytes != null && pdfBytes.length > 0) {
      String fileName = System.currentTimeMillis() + (int) (Math.random() * 90000 + 10000) + ".pdf";    
      Path targetLocation = this.fileStorageLocation.resolve(fileName);
      InputStream input = new ByteArrayInputStream(pdfBytes);
      Files.copy(input, targetLocation, StandardCopyOption.REPLACE_EXISTING);
      return fileName;
    }
    
    return null;
  }

}
