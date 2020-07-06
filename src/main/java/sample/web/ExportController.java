package sample.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.ApiOperation;
import sample.model.JsonArrayResult;
import sample.model.PdfModel;
import sample.model.ProjectString;
import sample.service.ProjectExportService;
import sample.service.ProjectService;

@RestController
public class ExportController {

  @Autowired
  private ProjectExportService projectExport;

  @Autowired
  private ProjectService projectService;

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
        String fileName = projectExport.export(pString);
        String url = ServletUriComponentsBuilder.fromCurrentContextPath().path("/img/pdf/").path(fileName)
            .toUriString();
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

