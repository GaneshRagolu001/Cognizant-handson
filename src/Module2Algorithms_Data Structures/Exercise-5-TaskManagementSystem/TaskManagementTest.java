public class TaskManagementTest {

    public static void main(String[] args) {
        TaskLinkedList list = new TaskLinkedList();

        list.addTask(new Task(301, "Fix Login Bug", "In Progress"));
        System.out.println();
        list.addTask(new Task(302, "Write Unit Tests", "Pending"));
        System.out.println();
        list.addTask(new Task(303, "Code Review", "Pending"));
        System.out.println();
        list.addTask(new Task(304, "Deploy to Staging", "Completed"));
        System.out.println();

        System.out.println("========= TASK LIST =========");
        System.out.println();
        list.displayTasks();
        System.out.println();
        System.out.println("============================");
        System.out.println();

        System.out.println("Searching Task : 302");
        System.out.println();
        Task foundTask = list.searchTask(302);
        if (foundTask != null) {
            System.out.println("Task Found.");
            System.out.println();
            System.out.println(foundTask);
        } else {
            System.out.println("Task Not Found.");
        }
        System.out.println();

        list.deleteTask(303);
        System.out.println();

        System.out.println("========= UPDATED TASK LIST =========");
        System.out.println();
        list.displayTasks();
        System.out.println();
        System.out.println("============================");
        System.out.println();

        System.out.println("Searching Task : 999");
        System.out.println();
        Task notFoundTask = list.searchTask(999);
        if (notFoundTask != null) {
            System.out.println("Task Found.");
            System.out.println();
            System.out.println(notFoundTask);
        } else {
            System.out.println("Task Not Found.");
        }
    }
}
