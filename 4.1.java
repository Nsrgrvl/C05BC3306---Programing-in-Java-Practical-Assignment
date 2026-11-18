package college;

public class Student {
    private String name;
    public String course;

    public Student(String name, String course) {
        this.name = name;
        this.course = course;
    }

    public void showDetails() {
        System.out.println("Student Name: " + name + " | Course: " + course);
    }
}