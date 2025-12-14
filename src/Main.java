import TaskManagerApp.Task;
import TaskManagerApp.TaskManager;
import TaskManagerApp.taskTool;

import java.util.Scanner;

import static TaskManagerApp.taskTool.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        var Taskmanager = new TaskManager();
        taskTool taskTool = new taskTool();
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
                case 1 -> addTask(sc,Taskmanager);
                case 2 -> removeTask(sc, Taskmanager);
                case 3 -> updateTask(sc, Taskmanager);
                case 4 -> markCompleted(sc, Taskmanager);
                case 5 -> showAll(Taskmanager);
                case 6 -> search(sc, Taskmanager);
                case 7 -> clearAll(sc, Taskmanager);
                case 8 -> exitProgram();
                default -> System.out.println("Invalid choice, try again.");
            }

        }
}
}