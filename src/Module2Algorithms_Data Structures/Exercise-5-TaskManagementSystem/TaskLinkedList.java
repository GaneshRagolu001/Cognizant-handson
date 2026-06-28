public class TaskLinkedList {
    private TaskNode head;

    public TaskLinkedList() {
        this.head = null;
    }

    public void addTask(Task task) {
        TaskNode newNode = new TaskNode(task);

        if (head == null) {
            head = newNode;
        } else {
            TaskNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Task Added Successfully.");
    }

    public Task searchTask(int taskId) {
        TaskNode temp = head;

        while (temp != null) {
            if (temp.data.getTaskId() == taskId) {
                return temp.data;
            }
            temp = temp.next;
        }
        return null;
    }

    public void displayTasks() {
        if (head == null) {
            System.out.println("No Tasks Available.");
            return;
        }

        TaskNode temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;

            if (temp != null) {
                System.out.println();
                System.out.println("------------------------");
                System.out.println();
            }
        }
    }

    public void deleteTask(int taskId) {
        if (head == null) {
            System.out.println("Task Not Found.");
            return;
        }

        if (head.data.getTaskId() == taskId) {
            head = head.next;
            System.out.println("Task Deleted Successfully.");
            return;
        }

        TaskNode prev = head;
        TaskNode curr = head.next;

        while (curr != null) {
            if (curr.data.getTaskId() == taskId) {
                prev.next = curr.next;
                System.out.println("Task Deleted Successfully.");
                return;
            }
            prev = curr;
            curr = curr.next;
        }

        System.out.println("Task Not Found.");
    }
}
