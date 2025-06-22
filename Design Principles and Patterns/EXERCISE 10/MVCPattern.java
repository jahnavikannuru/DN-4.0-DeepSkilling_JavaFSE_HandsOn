public class MVCPattern {
    public static void main(String[] args) {
        Student model=retriveStudentFromDatabase();
        StudentView view=new StudentView();
        StudentController controller=new StudentController(model, view);
        controller.updateView();
        controller.setStudentName("XYZ");
        controller.updateView();

    }
    private static Student retriveStudentFromDatabase(){
        Student student=new Student();
        student.setName("ABC");
        student.setId(2);
        student.setGrade('A');
        return student;
    }
}
