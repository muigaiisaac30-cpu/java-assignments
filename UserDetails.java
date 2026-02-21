
// NAME: ISAAC JULIUS WAINAINA
// REGISTRATION NUMBER: CT100/G/22432/24

// Import Scanner class to allow user input from keyboard
import java.util.Scanner;

public class UserDetails {

    public static void main(String[] args) {

        // Create Scanner object to read input
        Scanner input = new Scanner(System.in);

        // Declare variables with appropriate data types
        float height; // float is suitable for decimal values like 1.75m
        double bankBalance; // double is used for large monetary values with decimals
        String phoneNumber; // String is used because phone numbers may start with 0 or contain +

        // Prompt user to enter height
        System.out.print("Enter your height (in meters or centimeters): ");
        height = input.nextFloat(); // Reads decimal number

        // Prompt user to enter bank balance
        System.out.print("Enter your bank balance (in Kenya Shillings): ");
        bankBalance = input.nextDouble(); // Reads large decimal number

        // Clear buffer before reading String input
        input.nextLine();
        // If we do not use this line, the nextLine() below may be skipped
        // because of leftover newline character from previous input

        // Prompt user to enter phone number
        System.out.print("Enter your phone number: ");
        phoneNumber = input.nextLine(); // Reads full phone number as text

        // Display formatted output
        System.out.println("\n----- USER DETAILS -----");
        System.out.println("Height: " + height);
        System.out.println("Bank Balance: KES " + bankBalance);
        System.out.println("Phone Number: " + phoneNumber);

        // Close scanner to prevent resource leak
        input.close();
    }
}