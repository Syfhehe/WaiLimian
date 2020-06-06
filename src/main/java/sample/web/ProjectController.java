package sample.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exception.NotFoundException;
import io.swagger.annotations.ApiOperation;
import sample.model.Project;
import sample.service.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
  
  @Autowired
  private ProjectService projectService;
  
  @ApiOperation(value="获取项目列表", notes="获取项目列表")
  @GetMapping(value = "/projects")
  public List<Project> getProjectList()
  {
      return projectService.getProjectList();
  }

  @ApiOperation(value="添加项目", notes="添加项目")
  @PostMapping(value = "/projects")
  public Object addProject(@RequestBody Project project){
      return projectService.addProject(project);
  }

  @ApiOperation(value="获取项目信息", notes="根据id获取项目信息")
  @GetMapping(value = "/projects/{id}")
  public Object getProject(@PathVariable("id") Long id) throws NotFoundException
  {
      return projectService.getProject(id);
  }

  @ApiOperation(value="删除项目", notes="根据id删除项目")
  @DeleteMapping(value = "/projects/{id}")
  public void deleteProject(@PathVariable("id") Long id)
  {
      projectService.deleteProject(id);
  }

  @ApiOperation(value="更新项目", notes="更新项目")
  @PatchMapping(value = "/projects/{id}")
  public Project updateProject(@PathVariable("id") Long id, @RequestBody Project project)
  {
      return projectService.update(id, project);
  }


  @ApiOperation(value="测试")
  @GetMapping(value = "/test")
  public String test()
  {
      return "test ok!";
  }
  

}
