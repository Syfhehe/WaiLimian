package sample.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.NotFoundException;
import exception.Result;
import sample.model.Project;
import sample.repository.ProjectRepository;

import java.util.List;

import static sample.util.Util.getNullPropertyNames;

@Service
public class ProjectService
{
    @Autowired
    private ProjectRepository projectRepository;

    public Object addProject(Project project)
    {
        return projectRepository.save(project);
    }

    public List<Project> getProjectList()
    {
        return projectRepository.findAll();
    }

    public Object getProject(Long id) throws NotFoundException
    {
        Project currentInstance = projectRepository.findOne(id);
        if (currentInstance == null)
        {
            throw new NotFoundException("project " + id + " is not exist!", Result.ErrorCode.USER_NOT_FOUND.getCode());
        }
        return projectRepository.findOne(id);
    }

    public void deleteProject(Long id)
    {
        projectRepository.delete(id);
    }

    public Project update(Long id, Project project)
    {
        Project currentInstance = projectRepository.findOne(id);

        String[] nullPropertyNames = getNullPropertyNames(project);
        BeanUtils.copyProperties(project, currentInstance, nullPropertyNames);

        return projectRepository.save(currentInstance);
    }
}
