package sample.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import exception.NotFoundException;
import exception.Result;
import sample.model.Project;
import sample.repository.ProjectRepository;
import sample.util.PageUtil;

import java.util.ArrayList;
import java.util.List;

import static sample.util.Util.getNullPropertyNames;

@Service
public class ProjectService {
  @Autowired
  private ProjectRepository projectRepository;

  public Object addProject(Project project) {
    return projectRepository.save(project);
  }

  public List<Project> getProjectList() {
    return projectRepository.findAll();
  }

  public Object getProject(Long id) throws NotFoundException {
    Project currentInstance = projectRepository.findOne(id);
    if (currentInstance == null) {
      throw new NotFoundException("project " + id + " is not exist!",
          Result.ErrorCode.USER_NOT_FOUND.getCode());
    }
    return projectRepository.findOne(id);
  }

  public void deleteProject(Long id) {
    projectRepository.delete(id);
  }

  public Project update(Long id, Project project) {
    Project currentInstance = projectRepository.findOne(id);

    String[] nullPropertyNames = getNullPropertyNames(project);
    BeanUtils.copyProperties(project, currentInstance, nullPropertyNames);

    return projectRepository.save(currentInstance);
  }

  public Page<Project> findAllProject(Pageable pageable, String status, String rank) {
    pageable = PageUtil.getPageRequest(pageable.getPageNumber(), null);
    Specification<Project> querySpecification = (Specification<Project>) (root, query, cb) -> {
      List<Predicate> predicates = new ArrayList<>();
      query.orderBy(cb.desc(root.get("id").as(Integer.class)));
      if (status != null) {
        predicates.add((Predicate) cb.equal(root.get("status"), status));
      }
      if ("hot".equals(rank)) {
        query.orderBy(cb.desc(root.get("clicks").as(Integer.class)));
      }
      Predicate[] array = predicates.toArray(new Predicate[predicates.size()]);
      return cb.and((javax.persistence.criteria.Predicate[]) array);
    };
    return projectRepository.findAll(querySpecification, pageable);
  }
}
