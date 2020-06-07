package sample.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import sample.model.Project;



public interface ProjectRepository
    extends JpaRepository<Project, Long>, JpaSpecificationExecutor<Project>, Serializable {
}
