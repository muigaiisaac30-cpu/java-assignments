//REG NUMBER: CT100/G/22432/24
//NAME: ISAAC JULIUS WAINAINA
//WEEK 5 ASSIGNMENT

import java.util.Scanner;

public class TaxiFare {

    // Method to calculate total fare
    public static double calculateFare(double distance) {
        double ratePerKm = 50; // KSh per kilometer
        return distance * ratePerKm;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for distance traveled
        System.out.print("Enter the distance traveled (km): ");
        double distance = scanner.nextDouble();

        // Call the method and display the fare
        double totalFare = calculateFare(distance);
        System.out.printf("Total fare: KSh %.2f%n", totalFare);

        scanner.close();
    }
}