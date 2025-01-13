import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TaskManager<T extends Task> {

    private Map<Integer, T> taskMap;
    private List<T> taskList;

    public TaskManager() {
        this.taskMap = new HashMap<>();
        this.taskList = new ArrayList<>();
    }

    // Add task to both list and map
    public synchronized void addTask(T task) {
        taskList.add(task);
        taskMap.put(task.hashCode(), task);
    }

    // Gets a task by its unique id
    public synchronized T getTask(int id) throws TaskNotFoundException {
        T task = taskMap.get(id);
        if (task == null) {
            throw new TaskNotFoundException("Task not found with ID " + id);
        }
        return task;
    }

    // Remove task by its unique ID
    public synchronized void removeTask(int id) throws TaskNotFoundException {
        T task = taskMap.remove(id);
        if (task == null) {
            throw new TaskNotFoundException("Task not found with ID " + id);
        }
        taskList.remove(task);
    }

    // Get all task in the list
    public synchronized List<T> getAllTask() {
        return new ArrayList<>(taskList); // Return a copy of a tasklist
    }

    // Stream example : Filter task based on the completion status
    public List<T> getCompletedTask() {
        return taskList.stream() // Convert the task list to a stream
                .filter(Task::isCompleted) // Filter tasks that are completed
                .collect(Collectors.toList()); // Collect the results into a new list
    }

    // Stream example : Map task titles to uppercase
    public List<String> getTaskTitlesInUppercase() {
        return taskList.stream() // Converts the tasklist to stream
                .map(task -> task.getTitle().toUpperCase()) // Convert each title to uppercase
                .collect(Collectors.toList()); // Collects the result into a new list
    }

    // Update a task (Mark is as a complete)
    public synchronized void updateTask(T task) throws TaskNotFoundException {
        T existingTask = getTask(task.hashCode()); // Retrives the task by its ID (Hashcode)
        existingTask.markCompleted(); // Mark it as complete
    }

}
