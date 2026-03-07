//REG NUMBER: CT100/G/22432/24
//NAME: ISAAC JULIUS WAINAINA
// WEEK 6 ASSIGNMENT

import java.util.Scanner;

public class HotelRevenue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] revenue = new double[7]; // Array to store 7 days' revenue
        double total = 0;

        // Input revenue for each day
        for (int i = 0; i < revenue.length; i++) {
            System.out.printf("Enter revenue for day %d: ", i + 1);
            revenue[i] = scanner.nextDouble();
            total += revenue[i]; // Add to total
        }

        // Calculate average
        double average = total / revenue.length;

        // Display results
        System.out.printf("Total weekly revenue: KSh %.2f%n", total);
        System.out.printf("Average daily revenue: KSh %.2f%n", average);

        scanner.close();
    }
}
