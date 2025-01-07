package com.example.projectmanagement.service;

import com.example.projectmanagement.model.Project;
import com.example.projectmanagement.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    // Метод для отримання всіх проектів
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    // Метод для отримання проекту за ID
    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    // Метод для створення нового проекту
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    // Метод для оновлення проекту
    public Project updateProject(Long id, Project projectDetails) {
        if (projectRepository.existsById(id)) {
            projectDetails.setId(id);
            return projectRepository.save(projectDetails);
        }
        return null; // або викидайте помилку
    }

    // Метод для видалення проекту
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
