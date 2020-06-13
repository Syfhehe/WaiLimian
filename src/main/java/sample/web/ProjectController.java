package sample.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import sample.model.Project;
import sample.model.ProjectCode;
import sample.model.ProjectJsonResult;
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
  public List<Project> getProjectList() {
    return projectService.getProjectList();
  }
  
  @ApiOperation(value = "查询项目", notes = "查询项目")
  @GetMapping(value = {"/list","/manage_list"})
  public Object searchProjects(@RequestParam(value = "search", defaultValue = "") String search,
      @RequestParam(value = "city", defaultValue = "") CityEnum city,
      @RequestParam(value = "position", defaultValue = "") PositionEnum position,
      @RequestParam(value = "area", defaultValue = "") AreaEnum area,
      @RequestParam(value = "style", defaultValue = "") StyleEnum style,
      @RequestParam(value = "shape", defaultValue = "") ShapeEnum shape,
      @RequestParam(value = "scope", defaultValue = "") ScopeEnum scope,
      @RequestParam(value = "later", defaultValue = "") LaterEnum later,
      @RequestParam(value = "vertical", defaultValue = "") VerticalEnum vertical,
      @RequestParam(value = "page_no", defaultValue = "1") Integer page_no,
      @RequestParam(value = "page_size", defaultValue = "12") Integer page_size,
      @RequestParam(value = "tab", defaultValue = "0") Boolean tab) {
    Sort sort = new Sort(Direction.DESC, "id");
    Pageable pageable = new PageRequest(page_no, page_size, sort);
    Page<Project> projects = projectService.findAllProject(pageable, search, position, city, area,
        style, shape, scope, later, vertical, tab);
    int pageNo = projects.getTotalPages();
    int pageSize = projects.getSize();
    int total = projects.getNumber();
    return new ProjectJsonResult<>(projects.getContent(), pageNo, pageSize, total);
  }

  @ApiOperation(value = "获取项目信息", notes = "根据id获取项目信息")
  @GetMapping(value = "/detail")
  public Object getProjectDetail(@RequestParam("ids") String ids) throws NotFoundException {
    String[] array = ids.split(",");
    ArrayList<Project> projectList = new ArrayList<Project>();
    for(String id : array) {
      Long idInt = Long.parseLong(id);
      projectList.add(projectService.getProject(idInt));
    }
    return new JsonArrayResult<Project>(projectList);
  }
  
  @ApiOperation(value = "获取项目code信息", notes = "根据id获取项目信息")
  @GetMapping(value = "/detail_code")
  public Object getProjectDetailCode(@RequestParam("ids") String ids) throws NotFoundException {
    String[] array = ids.split(",");
    ArrayList<ProjectCode> projectList = new ArrayList<ProjectCode>();
    for(String id : array) {
      Long idInt = Long.parseLong(id);
      projectList.add(projectService.getProjectCode(idInt));
    }
    return new JsonArrayResult<ProjectCode>(projectList);
  }
  
  
  @ApiOperation(value = "添加项目", notes = "添加项目")
  @PostMapping(value = "/new")
  public Object addProject(@RequestBody Project project) {
    User user = userSerivce.getCurrentUser();
    project.setOpUser(user);
    project.setCreator(user);
    return projectService.addProject(project);
  }

  @ApiOperation(value = "删除项目", notes = "根据id删除项目")
  @DeleteMapping(value = "/{id}")
  public void deleteProject(@PathVariable("id") Long id) {
    projectService.deleteProject(id);
  }

  @ApiOperation(value = "更新项目", notes = "更新项目")
  @PostMapping(value = "/update")
  public Project updateProject(@RequestBody Project project) {
    User user = userSerivce.getCurrentUser();
    project.setOpUser(user);
    project.setOpenTime(new Date());
    return projectService.update(project);
  }

}
