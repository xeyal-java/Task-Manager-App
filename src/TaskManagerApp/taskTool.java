package TaskManagerApp;

import java.util.Scanner;

public class taskTool {

    public static void addTask(Scanner sc, TaskManager manager) {
        System.out.print("Enter title: ");
        String title = sc.nextLine();

        System.out.print("Enter description: ");
        String description = sc.nextLine();

        manager.addTask(title, description);
        System.out.println("Task added successfully!");
    }

    public static void removeTask(Scanner sc, TaskManager manager) {
        System.out.print("Enter task ID to remove: ");
        Integer id = Integer.parseInt(sc.nextLine());

        var removed = manager.removeTask(id);
        if (removed) {
            System.out.println("Task removed successfully!");
        } else {
            System.out.println("No task found with ID " + id);
        }
    }

    public static void updateTask(Scanner sc, TaskManager manager) {
        System.out.print("Enter task ID to update: ");
        Integer id = Integer.parseInt(sc.nextLine());

        Task task = manager.getTaskById(id);
        if (task == null) {
            System.out.println("No task found with ID " + id);
            return;
        }

        System.out.print("Enter new title: ");
        String newTitle = sc.nextLine();

        System.out.print("Enter new description: ");
        String newDesc = sc.nextLine();

        task.setTitle(newTitle);
        task.setDescription(newDesc);
        System.out.println("Task updated successfully!");
    }

    public static void markCompleted(Scanner sc, TaskManager manager) {
        System.out.print("Enter task ID to mark as completed: ");
        Integer id = Integer.parseInt(sc.nextLine());

        Task task = manager.getTaskById(id);
        if (task != null) {
            task.markAsCompleted();
            System.out.println("Task marked as completed!");
        } else {
            System.out.println("No task found with ID " + id);
        }
    }

    public static void showAll(TaskManager manager) {
        manager.getAllTasks();
    }

    public static void search(Scanner sc, TaskManager manager) {
        System.out.print("Enter keyword: ");
        String keyword = sc.nextLine();
        manager.search(keyword);
    }

    public static void clearAll(Scanner sc, TaskManager manager) {
        System.out.print("Are you sure? (yes/no): ");
        String answer = sc.nextLine();

        if (answer.equalsIgnoreCase("yes")) {
            manager.clearAll();
            System.out.println("All tasks cleared!");
        } else {
            System.out.println("Task was not deleted");
        }
    }

    public static void exitProgram() {
        System.out.println("Program stopped.");
    }
}
