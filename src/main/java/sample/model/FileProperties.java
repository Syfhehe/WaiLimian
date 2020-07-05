package sample.model;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "file")
public class FileProperties {
  private String uploadDir;
  
  private String pdfDir;
  
  public String getUploadDir() {
    return uploadDir;
  }

  public void setUploadDir(String uploadDir) {
    this.uploadDir = uploadDir;
  }

  public String getPdfDir() {
    return pdfDir;
  }

  public void setPdfDir(String pdfDir) {
    this.pdfDir = pdfDir;
  }
}
