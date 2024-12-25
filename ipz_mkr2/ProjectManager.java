public class ProjectManager implements TeamMember {
    private String name;

    public ProjectManager(String name) {
        this.name = name;
    }

    @Override
    public void performTask(Task task) {
        task.setStatus("Managed by PM: " + name);
    }

    @Override
    public String getName() {
        return name;
    }
}
