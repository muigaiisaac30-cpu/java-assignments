// NAME: ISAAC JULIUS WAINAINA
// REGISTRATION NUMBER: CT100/G/22432/24
//WEEK 2 ASSIGNMENT: LOAN QUALIFICATION

// Import Scanner class for user input
import java.util.Scanner;

public class LoanQualification {

    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Declare variables
        int age; // Age is whole number → int
        double income; // Income may include decimals → double

        // Prompt user for age
        System.out.print("Enter your age: ");
        age = input.nextInt(); // Reads integer value

        // Prompt user for annual income
        System.out.print("Enter your annual income (in Kenya Shillings): ");
        income = input.nextDouble(); // Reads decimal value

        // Check loan qualification conditions
        if (age >= 21 && income >= 21000) {
            // && means BOTH conditions must be true
            System.out.println("Congratulations you qualify for a loan.");
        } else {
            System.out.println("Unfortunately, we are unable to offer you a loan at this time.");
        }

        // Close scanner
        input.close();
    }
}