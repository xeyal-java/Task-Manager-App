package TaskManagerApp;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private final ArrayList<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public void addTask(String title, String description) {
        Task task = new Task(nextId++, title, description, false);
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    public boolean removeTask(int id) {
        Task task = getTaskById(id);
        if (task == null) {
            System.out.println("Task not found.");
            return false;
        } else {
            tasks.remove(task);
            System.out.println("Task removed.");
            return true;
        }
    }

    public Task getTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    public void updateTask(int id, String newTitle, String newDescription) {
        Task task = getTaskById(id);
        if (task == null) {
            System.out.println("Task not found.");
        } else {
            task.setTitle(newTitle);
            task.setDescription(newDescription);
            System.out.println("Task updated: " + task);
        }
    }

    public void markCompleted(int id) {
        Task task = getTaskById(id);
        if (task == null) {
            System.out.println("Task not found.");
        } else {
            task.markAsCompleted();
            System.out.println("Task marked as completed: " + task);
        }
    }

    public void search(String keyword) {
        boolean found = false;
        for (Task task : tasks) {
            if (task.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                    task.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(task);
                found = true;
            }
        }
        if (!found) System.out.println("No matching tasks found.");
    }

    public void getAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void clearAll() {
        tasks.clear();
        System.out.println("All tasks cleared.");
    }
}
