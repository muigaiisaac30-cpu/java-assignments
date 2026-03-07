//REG NUMBER: CT100/G/22432/24
//NAME: ISAAC JULIUS WAINAINA
//WEEK 3 ASSIGNMENT

import java.util.Scanner;

public class ExamEligibility {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt for attendance percentage
        System.out.print("Enter your attendance percentage: ");
        double attendance = scanner.nextDouble();

        // Prompt for average marks
        System.out.print("Enter your average marks: ");
        double averageMarks = scanner.nextDouble();

        // Check eligibility
        if (attendance >= 75 && averageMarks >= 40) {
            System.out.println("Eligible for final exams.");
        } else {
            System.out.println("Not eligible.");
        }

        scanner.close();
    }
}