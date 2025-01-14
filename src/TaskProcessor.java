public class TaskProcessor implements Runnable {
    private Task task; // The task to be proceed

    public TaskProcessor(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        try {
            System.out.println("Proceesing task :" + task.getTitle()); //
            Thread.sleep(1000);
            task.markCompleted();
            System.out.println("Task completed :" + task.getTitle());

        } catch (InterruptedException e) {
            System.err.println("Task interrupted" + task.getTitle());

        }
    }

}
