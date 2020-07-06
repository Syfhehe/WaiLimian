package sample.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import exception.NotFoundException;
import exception.Result;
import sample.eum.AreaEnum;
import sample.eum.CityEnum;
import sample.eum.LaterEnum;
import sample.eum.PositionEnum;
import sample.eum.ScopeEnum;
import sample.eum.ShapeEnum;
import sample.eum.StyleEnum;
import sample.eum.VerticalEnum;
import sample.model.Project;
import sample.model.ProjectString;
import sample.repository.ProjectRepository;
import sample.util.StringUtils;
import sample.util.Util;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import static sample.util.Util.getNullPropertyNames;

@Service
public class ProjectService {
  @Autowired
  private ProjectRepository projectRepository;

  public Object addProject(Project project) {
    return projectRepository.saveAndFlush(project);
  }

  public List<Project> getProjectList() {
    return projectRepository.findAll();
  }

  public Project getProjectById(Long id) {
    return projectRepository.findOne(id);
  }

  public Project getProjectCode(Long id) throws NotFoundException {
    Project currentInstance = projectRepository.findOne(id);
    if (currentInstance == null) {
      throw new NotFoundException("project " + id + " is not exist!",
          Result.ErrorCode.USER_NOT_FOUND.getCode());
    }
    return projectRepository.findOne(id);
  }

  public ProjectString getProjectString(Long id) throws NotFoundException {
    Project currentInstance = projectRepository.findOne(id);
    if (currentInstance == null) {
      throw new NotFoundException("project " + id + " is not exist!",
          Result.ErrorCode.USER_NOT_FOUND.getCode());
    }
    return projectToString(currentInstance);
  }

  public ProjectString projectToString(Project currentInstance) {
    ProjectString pCode = new ProjectString();
    pCode.setMaterial(currentInstance.getMaterial());
    pCode.setAreaOfStructure(currentInstance.getAreaOfStructure());
    pCode.setArea(currentInstance.getArea().getArea());
    pCode.setCity(currentInstance.getCity().getCity());
    pCode.setCompany(currentInstance.getCompany());
    pCode.setCreator(currentInstance.getCreator());
    pCode.setDesign(currentInstance.getDesign());
    pCode.setHeight(currentInstance.getHeight());
    pCode.setId(currentInstance.getId());
    pCode.setLater(currentInstance.getLater().getLater());
    pCode.setLength(currentInstance.getLength());
    pCode.setLocation(currentInstance.getLocation());
    pCode.setName(currentInstance.getName());
    pCode.setOpenTime(Util.formatDate(currentInstance.getOpenTime()));
    pCode.setOpUser(currentInstance.getOpUser());
    pCode.setPictures(currentInstance.getPictures());
    pCode.setPosition(currentInstance.getPosition().getPosition());
    pCode.setScope(currentInstance.getScope().getScope().replace("<", "&lt;").replace(">", "&gt;"));
    pCode.setShape(currentInstance.getShape().getShape());
    pCode.setStyle(currentInstance.getStyle().getStyle());
    pCode.setTab(currentInstance.getTab());
    pCode.setUpdateTime(Util.formatDateTime(currentInstance.getUpdateTime()));
    pCode.setVertical(currentInstance.getVertical().getVertical());
    pCode.setWidth(currentInstance.getWidth());
    return pCode;
  }

  public void deleteProject(Long id) {
    projectRepository.delete(id);
  }

  public Project update(Project project) {
    Project currentInstance = projectRepository.findOne(project.getId());

    String[] nullPropertyNames = getNullPropertyNames(project);
    BeanUtils.copyProperties(project, currentInstance, nullPropertyNames);

    return projectRepository.save(currentInstance);
  }


  public List<Project> findSimilarProject(Project project) {
    List<Project> allProjects = projectRepository.findAll();
    List<Project> resultProjects = new ArrayList<Project>();
    int i;
    for (Project prj : allProjects) {
      if (project.getTab() != null && project.getTab().equals(prj.getTab())
          && !project.getId().equals(prj.getId())) {
        i = 0;
        if (project.getPosition() != null && project.getPosition().equals(prj.getPosition())) {
          i++;
        }
        if (project.getCity() != null && project.getCity().equals(prj.getCity())) {
          i++;
        }
        if (project.getArea() != null && project.getArea().equals(prj.getArea())) {
          i++;
        }
        if (project.getStyle() != null && project.getStyle().equals(prj.getStyle())) {
          i++;
        }
        if (project.getShape() != null && project.getShape().equals(prj.getShape())) {
          i++;
        }
        if (project.getScope() != null && project.getScope().equals(prj.getScope())) {
          i++;
        }
        if (project.getLater() != null && project.getLater().equals(prj.getLater())) {
          i++;
        }
        if (project.getVertical() != null && project.getVertical().equals(prj.getVertical())) {
          i++;
        }
        if (i >= 6) {
          resultProjects.add(prj);
        }
      }
    }
    return resultProjects;
  }

  public Page<Project> findAllProject(Pageable pageable, String name, PositionEnum position,
      CityEnum city, AreaEnum area, StyleEnum style, ShapeEnum shape, ScopeEnum scope,
      LaterEnum later, VerticalEnum vertical, Boolean tab) {
    Specification<Project> specification = new Specification<Project>() {
      @Override
      public Predicate toPredicate(Root<Project> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

        List<Predicate> predicatesList = new ArrayList<>();

        if (StringUtils.isNotBlank(name)) {
          Predicate namePredicate = cb.like(root.get("name").as(String.class), "%" + name + "%");
          predicatesList.add(namePredicate);
        }
        if (position != null) {
          Predicate positionPredicate = cb.equal(root.get("position"), position);
          predicatesList.add(positionPredicate);
        }
        if (city != null) {
          Predicate cityPredicate = cb.equal(root.get("city"), city);
          predicatesList.add(cityPredicate);
        }
        if (area != null) {
          Predicate areaPredicate = cb.equal(root.get("area"), area);
          predicatesList.add(areaPredicate);
        }
        if (style != null) {
          Predicate stylePredicate = cb.equal(root.get("style"), style);
          predicatesList.add(stylePredicate);
        }
        if (shape != null) {
          Predicate shapePredicate = cb.equal(root.get("shape"), shape);
          predicatesList.add(shapePredicate);
        }
        if (scope != null) {
          Predicate scopePredicate = cb.equal(root.get("scope"), scope);
          predicatesList.add(scopePredicate);
        }
        if (later != null) {
          Predicate laterPredicate = cb.equal(root.get("later"), later);
          predicatesList.add(laterPredicate);
        }
        if (vertical != null) {
          Predicate verticalPredicate = cb.equal(root.get("vertical"), vertical);
          predicatesList.add(verticalPredicate);
        }
        if (tab != null) {
          Predicate tabPredicate = cb.equal(root.get("tab").as(Boolean.class), tab);
          predicatesList.add(tabPredicate);
        }
        Predicate[] predicates = new Predicate[predicatesList.size()];
        return cb.and(predicatesList.toArray(predicates));
      }
    };
    return projectRepository.findAll(specification, pageable);
  }



}
