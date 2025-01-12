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
        T task = taskMap.get(id); // retrives the task from the map by its hascode
        if (task == null) {
            throw new TaskNotFoundException("Task not found with ID " + id); // throws custom excpetion if task not
                                                                             // found
        }
        return task; // returns the task
    }

    // Remove task by its unique ID
    public synchronized void removeTask(int id) throws TaskNotFoundException {
        T task = taskMap.remove(id); // Removes the task from map by ID
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
        taskList.stream() // Convert the task list to a stream
                .filter(Task::isCompleted) // Filter tasks that are completed
                .collect(Collectors.toList()); // Collect the results into a new list

    }

}
