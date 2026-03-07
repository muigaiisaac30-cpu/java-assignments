//REG NUMBER: CT100/G/22432/24
//NAME: ISAAC JULIUS WAINAINA
// WEEK 4 ASSIGMENT

import java.util.Scanner;

public class ATMWithdrawal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt for initial account balance
        System.out.print("Enter your account balance: ");
        double balance = scanner.nextDouble();

        // Continue withdrawals while balance is positive
        while (balance > 0) {
            System.out.print("Enter amount to withdraw: ");
            double withdrawal = scanner.nextDouble();

            balance -= withdrawal; // Deduct withdrawal from balance

            System.out.printf("Remaining balance: %.2f%n", balance);

            if (balance <= 0) {
                System.out.println("Your account balance is now zero or negative. No more withdrawals allowed.");
            }
        }

        scanner.close();
    }
}