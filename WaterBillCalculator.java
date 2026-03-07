package weekthree;
//REG NUMBER: CT100/G/22432/24

//NAME: ISAAC JULIUS WAINAINA
//WEEK 3 ASSIGNMENT

import java.util.Scanner;

public class WaterBillCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt for water units consumed
        System.out.print("Enter the number of water units consumed: ");
        int units = scanner.nextInt();

        double totalBill;

        // Calculate total bill based on consumption rules
        if (units >= 0 && units <= 30) {
            totalBill = units * 20;
        } else if (units <= 60) {
            totalBill = units * 25;
        } else {
            totalBill = units * 30;
        }

        // Display the total bill formatted to 2 decimal places
        System.out.printf("Total bill: KES %.2f%n", totalBill);

        scanner.close();
    }
}