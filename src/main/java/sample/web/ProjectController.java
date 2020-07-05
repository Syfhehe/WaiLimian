package sample.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import sample.model.JsonMapResult;
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
  @GetMapping(value = "/all")
  public Object getProjectList() {
    return new JsonArrayResult<Project>(projectService.getProjectList());
  }

  @ApiOperation(value = "查询项目", notes = "查询项目")
  @GetMapping(value = {"/list"})
  public Object searchProjects(@RequestParam(value = "search", defaultValue = "") String search,
      @RequestParam(value = "city", required = false) CityEnum city,
      @RequestParam(value = "position", required = false) PositionEnum position,
      @RequestParam(value = "area", required = false) AreaEnum area,
      @RequestParam(value = "style", required = false) StyleEnum style,
      @RequestParam(value = "shape", required = false) ShapeEnum shape,
      @RequestParam(value = "scope", required = false) ScopeEnum scope,
      @RequestParam(value = "later", required = false) LaterEnum later,
      @RequestParam(value = "vertical", required = false) VerticalEnum vertical,
      @RequestParam(value = "page_no", defaultValue = "0") Integer page_no,
      @RequestParam(value = "page_size", defaultValue = "10") Integer page_size,
      @RequestParam(value = "tab") Boolean tab) {
    Sort sort = new Sort(Direction.DESC, "id");
    if (page_no > 0)
      page_no = page_no - 1;
    Pageable pageable = new PageRequest(page_no, page_size, sort);
    Page<Project> projects = projectService.findAllProject(pageable, search, position, city, area,
        style, shape, scope, later, vertical, tab);
    int pageNo = projects.getTotalPages();
    int pageSize = projects.getSize();
    int total = (int) projects.getTotalElements();
    List<ProjectString> projectsContent = convertEnumToString(projects);
    return new ProjectJsonResult<>(projectsContent, pageNo, pageSize, total);
  }

  @ApiOperation(value = "查询项目", notes = "查询项目")
  @GetMapping(value = {"/manage_list"})
  public Object searchProjectsByPage(
      @RequestParam(value = "page_no", defaultValue = "0") Integer page_no,
      @RequestParam(value = "page_size", defaultValue = "10") Integer page_size) {
    Sort sort = new Sort(Direction.DESC, "id");
    if (page_no > 0)
      page_no = page_no - 1;
    Pageable pageable = new PageRequest(page_no, page_size, sort);
    Page<Project> projects = projectService.findAllProject(pageable, null, null, null, null, null,
        null, null, null, null, null);
    int pageNo = projects.getTotalPages();
    int pageSize = projects.getSize();
    int total = (int) projects.getTotalElements();
    List<ProjectString> projectsContent = convertEnumToString(projects);
    return new ProjectJsonResult<>(projectsContent, pageNo, pageSize, total);
  }

  @ApiOperation(value = "获取项目Code信息", notes = "根据id获取项目信息")
  @GetMapping(value = "/detail_code")
  public Object getProjectDetailCode(@RequestParam("id") String id) throws NotFoundException {
    String[] array = id.split(",");
    Map<String, Project> projectMap = new HashMap<String, Project>();
    for (String idInArray : array) {
      Long idInt = Long.parseLong(idInArray);
      projectMap.put(idInArray, projectService.getProjectCode(idInt));
    }
    return new JsonMapResult<Project>(projectMap);
  }

  @ApiOperation(value = "获取项目名称信息", notes = "根据id获取项目信息")
  @GetMapping(value = "/detail")
  public Object getProjectDetailString(@RequestParam("id") String id) throws NotFoundException {
    Map<String, Object> projectMap = new HashMap<String, Object>();
    Long idLong = Long.parseLong(id);
    ProjectString p = projectService.getProjectString(idLong);
    List<Project> similarProjects =
        projectService.findSimilarProject(projectService.getProjectById(idLong));
    List<ProjectString> similarProjectStrings = convertEnumToString(similarProjects);
    p.setRecommand(similarProjectStrings);
    projectMap.put(id, p);
    return new JsonMapResult<Object>(projectMap);
  }

  @ApiOperation(value = "获取项目名称信息", notes = "根据id获取项目信息")
  @GetMapping(value = "/details")
  public Object getProjectsDetailString(@RequestParam("id") String id) throws NotFoundException {
    String[] array = id.split(",");
    Map<String, ProjectString> projectMap = new HashMap<String, ProjectString>();
    for (String idInArray : array) {
      Long idInt = Long.parseLong(idInArray);
      projectMap.put(idInArray, projectService.getProjectString(idInt));
    }
    return new JsonMapResult<ProjectString>(projectMap);
  }


  @ApiOperation(value = "添加项目", notes = "添加项目")
  @PostMapping(value = "/new")
  public Object addProject(@RequestBody Project project) {
    User user = userSerivce.getCurrentUser();
    project.setOpUser(user);
    project.setCreator(user);
    project.setUpdateTime(new Date());
    projectService.addProject(project);
    return new JsonResult<Project>(project);
  }

  @ApiOperation(value = "删除项目", notes = "根据id删除项目")
  @DeleteMapping(value = "/delete/{id}")
  public Object deleteProject(@PathVariable("id") Long id) {
    projectService.deleteProject(id);
    return new JsonResult<Project>();
  }

  @ApiOperation(value = "更新项目", notes = "更新项目")
  @PostMapping(value = "/update")
  public Object updateProject(@RequestBody Project project) {
    User user = userSerivce.getCurrentUser();
    project.setOpUser(user);
    project.setUpdateTime(new Date());
    projectService.update(project);
    return new JsonResult<Project>(project);
  }

  private List<ProjectString> convertEnumToString(Page<Project> projects) {
    List<Project> projectList = projects.getContent();
    List<ProjectString> projectsContent = new ArrayList<>();
    for (Project pj : projectList) {
      ProjectString pCode = projectService.projectToString(pj);
      projectsContent.add(pCode);
    }
    return projectsContent;
  }

  private List<ProjectString> convertEnumToString(List<Project> projects) {
    List<ProjectString> projectsContent = new ArrayList<>();
    for (Project pj : projects) {
      ProjectString pCode = projectService.projectToString(pj);
      projectsContent.add(pCode);
    }
    return projectsContent;
  }

}
