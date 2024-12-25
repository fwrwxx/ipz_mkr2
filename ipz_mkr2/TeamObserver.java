public class TeamObserver implements Observer {
    private String name;

    public TeamObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(Task task) {
        System.out.println("[Notification to " + name + "]: Task '" + task.getDescription() + "' status changed to '" + task.getStatus() + "'");
    }
}
