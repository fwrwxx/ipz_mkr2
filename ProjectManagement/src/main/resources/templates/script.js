document.addEventListener("DOMContentLoaded", () => {
    const projectsList = document.getElementById("projects-list");
    const tasksList = document.getElementById("tasks-list");
    const projectSection = document.getElementById("project-section");
    const taskSection = document.getElementById("task-section");
    const projectModal = document.getElementById("project-modal");
    const taskModal = document.getElementById("task-modal");
    const projectForm = document.getElementById("project-form");
    const taskForm = document.getElementById("task-form");
    const addProjectBtn = document.getElementById("add-project-btn");
    const addTaskBtn = document.getElementById("add-task-btn");
    const backToProjectsBtn = document.getElementById("back-to-projects-btn");
    const projectNameSpan = document.getElementById("project-name");

    // Temporary local data for projects and tasks
    let projects = [];
    let selectedProjectId = null;

    // Fetch all projects (Mocked for now)
    function fetchProjects() {
        projectsList.innerHTML = "";
        projects.forEach((project, index) => {
            const projectDiv = document.createElement("div");
            projectDiv.classList.add("project");
            projectDiv.textContent = project.name;
            projectDiv.addEventListener("click", () => showTasks(index));
            projectsList.appendChild(projectDiv);
        });
    }

    // Add project
    projectForm.addEventListener("submit", (e) => {
        e.preventDefault();
        const projectName = document.getElementById("project-name-input").value;
        const projectDesc = document.getElementById("project-desc-input").value;
        projects.push({ id: projects.length, name: projectName, description: projectDesc, tasks: [] });
        projectModal.style.display = "none";
        fetchProjects();
    });

    // Show tasks for a selected project
    function showTasks(projectId) {
        selectedProjectId = projectId;
        const project = projects[projectId];
        projectNameSpan.textContent = project.name;
        tasksList.innerHTML = "";
        project.tasks.forEach((task, index) => {
            const taskDiv = document.createElement("div");
            taskDiv.classList.add("task");
            taskDiv.textContent = task.title;
            tasksList.appendChild(taskDiv);
        });
        projectSection.style.display = "none";
        taskSection.style.display = "block";
    }

    // Add task
    taskForm.addEventListener("submit", (e) => {
        e.preventDefault();
        const taskTitle = document.getElementById("task-title-input").value;
        const taskDesc = document.getElementById("task-desc-input").value;
        const task = { title: taskTitle, description: taskDesc };
        projects[selectedProjectId].tasks.push(task);
        taskModal.style.display = "none";
        showTasks(selectedProjectId);
    });

    // Back to projects
    backToProjectsBtn.addEventListener("click", () => {
        taskSection.style.display = "none";
        projectSection.style.display = "block";
    });

    // Open modals
    addProjectBtn.addEventListener("click", () => (projectModal.style.display = "flex"));
    addTaskBtn.addEventListener("click", () => (taskModal.style.display = "flex"));

    // Close modals
    document.querySelectorAll(".close").forEach((closeBtn) =>
        closeBtn.addEventListener("click", () => {
            projectModal.style.display = "none";
            taskModal.style.display = "none";
        })
    );

    // Initial render
    fetchProjects();
});
