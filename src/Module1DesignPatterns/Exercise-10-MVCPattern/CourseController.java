public class CourseController {
    private Course model;
    private CourseView view;

    public CourseController(Course model, CourseView view) {
        this.model = model;
        this.view = view;
    }

    public String getCourseId() {
        return model.getId();
    }

    public String getCourseName() {
        return model.getName();
    }

    public String getCourseCategory() {
        return model.getCategory();
    }

    public void updateCourseId(String id) {
        model.setId(id);
    }

    public void updateCourseName(String name) {
        model.setName(name);
    }

    public void updateCourseCategory(String category) {
        model.setCategory(category);
    }

    public void displayCourse() {
        view.displayCourseDetails(model.getId(), model.getName(), model.getCategory());
    }
}
