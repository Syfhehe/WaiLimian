package sample.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.h2.util.New;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import exception.NotFoundException;
import io.swagger.annotations.ApiOperation;
import sample.eum.AreaEnum;
import sample.eum.CityEnum;
import sample.eum.LaterEnum;
import sample.eum.PositionEnum;
import sample.eum.ScopeEnum;
import sample.eum.ShapeEnum;
import sample.eum.StyleEnum;
import sample.eum.VerticalEnum;
import sample.model.JsonArrayResult;
import sample.model.JsonResult;
import sample.model.Project;
import sample.model.ProjectJsonResult;
import sample.model.ProjectString;
import sample.model.User;
import sample.service.ProjectService;
import sample.service.UserService;

@RestController
@RequestMapping("/projects")
public class ProjectController {

  @Autowired
  private ProjectService projectService;

  @Autowired
  private UserService userSerivce;

  @ApiOperation(value = "获取项目列表", notes = "获取项目列表")
  @GetMapping(value = "")
  public Object getProjectList() {
    return new JsonArrayResult<Project>(projectService.getProjectList());
  }

  @ApiOperation(value = "查询项目", notes = "查询项目")
  @GetMapping(value = {"/list"})
  public Object searchProjects(@RequestParam(value = "search", defaultValue = "") String search,
      @RequestParam(value = "city") CityEnum city,
      @RequestParam(value = "position") PositionEnum position,
      @RequestParam(value = "area") AreaEnum area, @RequestParam(value = "style") StyleEnum style,
      @RequestParam(value = "shape") ShapeEnum shape,
      @RequestParam(value = "scope") ScopeEnum scope,
      @RequestParam(value = "later") LaterEnum later,
      @RequestParam(value = "vertical") VerticalEnum vertical,
      @RequestParam(value = "page_no", defaultValue = "0") Integer page_no,
      @RequestParam(value = "page_size", defaultValue = "12") Integer page_size,
      @RequestParam(value = "tab") Boolean tab) {
    Sort sort = new Sort(Direction.DESC, "id");
    Pageable pageable = new PageRequest(page_no, page_size, sort);
    Page<Project> projects = projectService.findAllProject(pageable, search, position, city, area,
        style, shape, scope, later, vertical, tab);
    int pageNo = projects.getTotalPages();
    int pageSize = projects.getSize();
    int total = (int) projects.getTotalElements();
    return new ProjectJsonResult<>(projects.getContent(), pageNo, pageSize, total);
  }

  @ApiOperation(value = "查询项目", notes = "查询项目")
  @GetMapping(value = {"/manage_list"})
  public Object searchProjectsByPage(
      @RequestParam(value = "page_no", defaultValue = "0") Integer page_no,
      @RequestParam(value = "page_size", defaultValue = "12") Integer page_size) {
    Sort sort = new Sort(Direction.DESC, "id");
    Pageable pageable = new PageRequest(page_no, page_size, sort);
    Page<Project> projects = projectService.findAllProject(pageable, null, null, null, null, null,
        null, null, null, null, null);
    int pageNo = projects.getTotalPages();
    int pageSize = projects.getSize();
    int total = (int) projects.getTotalElements();
    return new ProjectJsonResult<>(projects.getContent(), pageNo, pageSize, total);
  }

  @ApiOperation(value = "获取项目Code信息", notes = "根据id获取项目信息")
  @GetMapping(value = "/detail")
  public Object getProjectDetailCode(@RequestParam("ids") String ids) throws NotFoundException {
    String[] array = ids.split(",");
    ArrayList<Project> projectList = new ArrayList<Project>();
    for (String id : array) {
      Long idInt = Long.parseLong(id);
      projectList.add(projectService.getProjectCode(idInt));
    }
    return new JsonArrayResult<Project>(projectList);
  }

  @ApiOperation(value = "获取项目名称信息", notes = "根据id获取项目信息")
  @GetMapping(value = "/detail_code")
  public Object getProjectDetailString(@RequestParam("ids") String ids) throws NotFoundException {
    String[] array = ids.split(",");
    ArrayList<ProjectString> projectList = new ArrayList<ProjectString>();
    for (String id : array) {
      Long idInt = Long.parseLong(id);
      projectList.add(projectService.getProjectString(idInt));
    }
    return new JsonArrayResult<ProjectString>(projectList);
  }


  @ApiOperation(value = "添加项目", notes = "添加项目")
  @PostMapping(value = "/new")
  public Object addProject(@RequestBody Project project) {
    User user = userSerivce.getCurrentUser();
    project.setOpUser(user);
    project.setCreator(user);
    projectService.addProject(project);
    return new JsonResult<Project>();
  }

  @ApiOperation(value = "删除项目", notes = "根据id删除项目")
  @DeleteMapping(value = "/{id}")
  public Object deleteProject(@PathVariable("id") Long id) {
    projectService.deleteProject(id);
    return new JsonResult<Project>();
  }

  @ApiOperation(value = "更新项目", notes = "更新项目")
  @PostMapping(value = "/update")
  public Object updateProject(@RequestBody Project project) {
    User user = userSerivce.getCurrentUser();
    project.setOpUser(user);
    project.setOpenTime(new Date());
    projectService.update(project);
    return new JsonResult<Project>(project);
  }

}
