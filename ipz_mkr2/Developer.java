import java.util.List;

public class Developer implements TeamMember {
    private String name;
    private List<String> skills;

    public Developer(String name, List<String> skills) {
        this.name = name;
        this.skills = skills;
    }

    @Override
    public void performTask(Task task) {
        task.setStatus("Completed by Developer: " + name);
    }

    @Override
    public String getName() {
        return name;
    }
}
