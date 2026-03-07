//REG NUMBER: CT100/G/22432/24
//NAME: ISAAC JULIUS WAINAINA

import java.util.Scanner;

public class LoanEligibility {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt for user's age
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        // Prompt for user's annual income
        System.out.print("Enter your annual income (Sh): ");
        double income = scanner.nextDouble();

        // Check loan eligibility
        if (age >= 21 && income >= 21000) {
            System.out.println("Congratulations you qualify for a loan.");
        } else {
            System.out.println("Unfortunately, we are unable to offer you a loan at this time.");
        }

        scanner.close();
    }
}