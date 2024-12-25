import java.util.List;

public class TeamMemberFactory {
    public static TeamMember createTeamMember(String role, String name, List<String> skills) {
        return switch (role) {
            case "Developer" -> new Developer(name, skills);
            case "Tester" -> new Tester(name);
            case "PM" -> new ProjectManager(name);
            default -> null;
        };
    }
}
