package com.example.projectmanagement.service;

import com.example.projectmanagement.model.Project;
import com.example.projectmanagement.repository.ProjectRepository;
import com.example.projectmanagement.service.ProjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ProjectServiceTest {

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectService projectService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);  // Ініціалізація моків
    }

    @Test
    void testCreateProject() {
        Project project = new Project();
        project.setName("Test Project");

        when(projectRepository.save(any(Project.class))).thenReturn(project);

        Project createdProject = projectService.createProject(project);

        assertNotNull(createdProject);
        assertEquals("Test Project", createdProject.getName());
        verify(projectRepository, times(1)).save(project);  // Перевірка виклику save
    }

    @Test
    void testGetProjectById() {
        Long projectId = 1L;
        Project project = new Project();
        project.setId(projectId);
        project.setName("Test Project");

        when(projectRepository.findById(projectId)).thenReturn(java.util.Optional.of(project));

        Project foundProject = projectService.getProjectById(projectId).orElse(null);

        assertNotNull(foundProject);
        assertEquals(projectId, foundProject.getId());
        assertEquals("Test Project", foundProject.getName());
    }

    // Інші тести...
}
