//REG NUMBER: CT100/G/22432/24
//NAME: ISAAC JULIUS WAINAINA
//WEEK 7 ASSIGNMENT

import java.io.*;
import java.util.ArrayList;

// Define a Student class to hold the information
class Student implements Serializable {
    String name;
    String regNumber;
    double totalMarks;

    public Student(String name, String regNumber, double totalMarks) {
        this.name = name;
        this.regNumber = regNumber;
        this.totalMarks = totalMarks;
    }
}

public class ReadStudentResults {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        try {
            // Open binary file for reading
            FileInputStream fileIn = new FileInputStream("results.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            // Read all Student objects until EOFException
            while (true) {
                Student s = (Student) in.readObject();
                students.add(s);
            }
        } catch (EOFException e) {
            // End of file reached, no action needed
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading the file.");
            e.printStackTrace();
        }

        // Display name and marks of each student
        System.out.println("Student Results:");
        for (Student s : students) {
            System.out.printf("Name: %s, Total Marks: %.2f%n", s.name, s.totalMarks);
        }
    }
}