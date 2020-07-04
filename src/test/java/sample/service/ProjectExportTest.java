package sample.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import exception.NotFoundException;
import sample.model.ProjectString;

public class ProjectExportTest {
  
  @Autowired
  private ProjectExport projectExport;
  
  @Test
  public void testExport() throws NotFoundException {
    ProjectString prjProject = new ProjectString();
    prjProject.setName("aaaaa");
    projectExport.export(prjProject);
  }

}
