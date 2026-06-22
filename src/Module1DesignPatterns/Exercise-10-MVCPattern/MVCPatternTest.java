public class MVCPatternTest {

    public static void main(String[] args) {



        Course model = new Course("CS101", "Introduction to Computer Science", "Computer Science");

        CourseView view = new CourseView();

        CourseController controller = new CourseController(model, view);

        System.out.println("\n--- Initial Course Details ---");
        controller.displayCourse();

        System.out.println("\n--- Updating Course Data ---");
        controller.updateCourseName("Advanced Computer Science");
        System.out.println("Name updated to: " + controller.getCourseName());

        controller.updateCourseCategory("Advanced CS");
        System.out.println("Category updated to: " + controller.getCourseCategory());

        controller.updateCourseId("CS202");
        System.out.println("ID updated to: " + controller.getCourseId());

        System.out.println("\n--- Updated Course Details ---");
        controller.displayCourse();

        System.out.println("\n--- Another Update ---");
        controller.updateCourseName("Software Engineering");
        controller.updateCourseCategory("Engineering");
        controller.displayCourse();


    }
}
