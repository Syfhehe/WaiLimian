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

  /**
   * 宋体字体文件相对路径
   */
  @Value("${pdfExport.fontSimsun}")
  private String fontSimsun;

  /**
   * 员工绩效考核导出模板文件相对路径
   */
  @Value("${pdfExport.employeeKpiFtl}")
  private String employeeKpiFtl;

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

}
