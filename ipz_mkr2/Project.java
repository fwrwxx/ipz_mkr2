import java.util.ArrayList;
import java.util.List;

public class Project {
    private List<TeamMember> teamMembers;
    private List<Task> tasks;
    private List<Observer> observers;

    public Project() {
        this.teamMembers = new ArrayList<>();
        this.tasks = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public void addTeamMember(TeamMember member) {
        teamMembers.add(member);
        observers.add(new TeamObserver(member.getName()));
    }

    public void addTask(Task task) {
        tasks.add(task);
        notifyObservers(task);
    }

    public void assignTask(int taskId, String memberName) {
        Task task = tasks.get(taskId);
        for (TeamMember member : teamMembers) {
            if (member.getName().equals(memberName)) {
                member.performTask(task);
                notifyObservers(task);
                break;
            }
        }
    }

    private void notifyObservers(Task task) {
        for (Observer observer : observers) {
            observer.update(task);
        }
    }
}
