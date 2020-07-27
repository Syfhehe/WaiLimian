package sample.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

/**
 * @Description: PDF 文件导出配置文件
 * @Author: junqiang.lu
 * @Date: 2019/1/8
 */
@Configuration
@Data
public class PDFExportConfig {

  @Value("${pdfExport.fontSimsun}")
  private String fontSimsun;

  @Value("${pdfExport.employeeKpiFtl}")
  private String employeeKpiFtl;
  
  @Value("${pdfExport.urlPrefix}")
  private String urlPrefix;

  public String getFontSimsun() {
    return fontSimsun;
  }

  public void setFontSimsun(String fontSimsun) {
    this.fontSimsun = fontSimsun;
  }

  public String getEmployeeKpiFtl() {
    return employeeKpiFtl;
  }

  public void setEmployeeKpiFtl(String employeeKpiFtl) {
    this.employeeKpiFtl = employeeKpiFtl;
  }

  public String getUrlPrefix() {
    return urlPrefix;
  }

  public void setUrlPrefix(String urlPrefix) {
    this.urlPrefix = urlPrefix;
  }

}
