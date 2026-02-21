//NAME:ISAAC JULIUS WAINAINA
//REGISTRATION NUMBER: CT100/G/22432/24

// StudentApp.java
import java.util.Scanner;

public class StudentApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user input
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Course: ");
        String course = scanner.nextLine();

        // Create StudentRecord object
        StudentRecord student = new StudentRecord(id, name, course);

        // Display student details
        System.out.println("\n--- Student Details ---");
        student.displayInfo();

        scanner.close();
    }
}