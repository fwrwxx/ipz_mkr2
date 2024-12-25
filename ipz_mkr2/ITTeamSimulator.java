import java.util.Arrays;

public class ITTeamSimulator {
    public static void main(String[] args) {
        Project project = new Project();

        TeamMember dev = TeamMemberFactory.createTeamMember("Developer", "Alice", Arrays.asList("Java", "Python"));
        TeamMember tester = TeamMemberFactory.createTeamMember("Tester", "Bob", null);
        TeamMember pm = TeamMemberFactory.createTeamMember("PM", "Charlie", null);

        project.addTeamMember(dev);
        project.addTeamMember(tester);
        project.addTeamMember(pm);

        Task task1 = new Task("Develop login feature");
        Task task2 = new Task("Test payment module");

        project.addTask(task1);
        project.addTask(task2);

        project.assignTask(0, "Alice");
        project.assignTask(1, "Bob");
    }
}
