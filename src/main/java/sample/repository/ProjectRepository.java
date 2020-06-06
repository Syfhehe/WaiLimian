package sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sample.model.Project;


public interface ProjectRepository extends JpaRepository<Project, Long> {
 
}
