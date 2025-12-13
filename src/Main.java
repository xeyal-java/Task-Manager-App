import TaskManagerApp.Task;
import TaskManagerApp.TaskManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        var Taskmanager = new TaskManager();
        boolean running = true;

        while (running) {
            System.out.println("====== TASK MANAGER ======");
            System.out.println("1. Add task");
            System.out.println("2. Remove task");
            System.out.println("3. Update task");
            System.out.println("4. Mark task as completed");
            System.out.println("5. Show all tasks");
            System.out.println("6. Search tasks");
            System.out.println("7. Clear all tasks");
            System.out.println("8. Exit");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter description: ");
                    String description = sc.nextLine();
                    Taskmanager.addTask(title, description);
                    System.out.println("Task added successfully!");
                }

                case 2 -> {
                    System.out.print("Enter task ID to remove: ");
                    int id = Integer.parseInt(sc.nextLine());
                    boolean removed = Taskmanager.removeTask(id);
                    if (removed) {
                        System.out.println("Task removed successfully!");
                    } else {
                        System.out.println("No task found with ID " + id);
                    }
                }

                case 3 -> {
                    System.out.print("Enter task ID to update: ");
                    int id = Integer.parseInt(sc.nextLine());
                    Task task = Taskmanager.getTaskById(id);
                    if (task != null) {
                        System.out.print("Enter new title: ");
                        String newTitle = sc.nextLine();
                        System.out.print("Enter new description: ");
                        String newDesc = sc.nextLine();
                        task.setTitle(newTitle);
                        task.setDescription(newDesc);
                        System.out.println("Task updated successfully!");
                    } else {
                        System.out.println("No task found with ID " + id);
                    }
                }

                case 4 -> {
                    System.out.print("Enter task ID to mark as completed: ");
                    int id = Integer.parseInt(sc.nextLine());
                    Task task = Taskmanager.getTaskById(id);
                    if (task != null) {
                        task.markAsCompleted();
                        System.out.println("Task marked as completed!");
                    } else {
                        System.out.println("No task found with ID " + id);
                    }
                }

                case 5 -> Taskmanager.getAllTasks();

                case 6 -> {
                    System.out.print("Enter keyword: ");
                    String keyword = sc.nextLine();
                    Taskmanager.search(keyword);
                }

                case 7 -> {
                    System.out.print("Are you sure? (yes/no): ");
                    String answer = sc.nextLine();
                    if (answer.equalsIgnoreCase("yes")) {
                        Taskmanager.clearAll();
                        System.out.println("All tasks cleared!");
                    }else if
                        (answer.equalsIgnoreCase("No")){
                        System.out.println("Task was not deleted");
                    }
                }

                case 8 -> {
                    running = false;
                    System.out.println("Program stopped.");
                }

                default -> System.out.println("Invalid choice, try again.");
            }
}
}
}