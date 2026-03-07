//REG NUMBER: CT100/G/22432/24
//NAME: ISAAC JULIUS WAINAINA
//WEEK 5 ASSIGNMENT

import java.util.Scanner;

public class ElectricBill {

    // Method to calculate total electric bill
    public static double calculateElectricBill(int units) {
        double bill = 0;

        if (units <= 100) {
            bill = units * 10;
        } else if (units <= 200) {
            bill = (100 * 10) + (units - 100) * 15;
        } else {
            bill = (100 * 10) + (100 * 15) + (units - 200) * 20;
        }

        return bill;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for units consumed
        System.out.print("Enter the number of units consumed: ");
        int units = scanner.nextInt();

        // Call the method and display the bill
        double totalBill = calculateElectricBill(units);
        System.out.printf("Total electric bill: KSh %.2f%n", totalBill);

        scanner.close();
    }
}