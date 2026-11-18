class Student {
    static String collegeName = "Marwadi University"; 
    int rollNo;
    String name;
    int[] marks = new int[3];

    public Student(int rollNo, String name, int m1, int m2, int m3) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks[0] = m1;
        this.marks[1] = m2;
        this.marks[2] = m3;
    }

    public int calculateTotal() {
        return marks[0] + marks[1] + marks[2];
    }

    public double calculatePercentage() {
        return calculateTotal() / 3.0;
    }

    public void displayResult() {
        System.out.println("College: " + collegeName + " | Roll No: " + rollNo + " | Name: " + name);
        System.out.println("Total: " + calculateTotal() + " | Percentage: " + String.format("%.2f", calculatePercentage()) + "%");
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        Student[] students = new Student[2];
        students[0] = new Student(101, "NISARG", 85, 90, 88);
        students[1] = new Student(102, "POORVA", 75, 80, 78);

        for (Student s : students) {
            s.displayResult();
            System.out.println();
        }
    }
}