//NAME:ISAAC JULIUS WAINAINA
//REGISTRATION NUMBER: CT100/G/22432/24// StudentRecord.java
public class StudentRecord {
    // Fields to store student details
    private String studentID;
    private String name;
    private String course;

    // Constructor to initialize fields
    public StudentRecord(String studentID, String name, String course) {
        this.studentID = studentID;
        this.name = name;
        this.course = course;
    }

    // Method to display student details
    public void displayInfo() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
    }
}