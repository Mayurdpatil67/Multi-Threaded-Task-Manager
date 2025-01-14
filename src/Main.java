import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        TaskManager<Task> taskManager = new TaskManager<>(); // Create a task manager instacne

        // create some task
        Task task1 = new Task("Write report", "Write the monthly report");
        Task task2 = new Task("Prepare meeting", "Prepare slides for meeting");
        Task task3 = new Task("Email client", "Send update email to client");

        // Add task to the task manager
        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addTask(task3);

        // Create an executot service with a fixed thread pool of 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit tasks for processing
        executor.submit(new TaskProcessor(task1));
        executor.submit(new TaskProcessor(task2));
        executor.submit(new TaskProcessor(task3));

        // Wait for all task to finish
        executor.shutdown(); // Orderly shutdown of executor

        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow(); // Force shutdown if task dont execute in time
            }
        } catch (InterruptedException e) {
            executor.shutdownNow(); // Handle thread interruption
        }

        // Use streams to filter task and print result
        System.out.println("Completed task :" + taskManager.getCompletedTask());
        System.out.println("Task titile in uppercase" + taskManager.getTaskTitlesInUppercase());
    }
}
