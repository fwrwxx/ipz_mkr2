public class Tester implements TeamMember {
    private String name;

    public Tester(String name) {
        this.name = name;
    }

    @Override
    public void performTask(Task task) {
        task.setStatus("Tested by Tester: " + name);
    }

    @Override
    public String getName() {
        return name;
    }
}
