
//NAME : ISAAC JULIUS WAINAINA
//REGISTRATION NUMBER: CT100/G/22432/24
// Showroom.java
import java.util.Scanner;

public class Showroom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for vehicle details
        System.out.print("Enter car brand: ");
        String brand = scanner.nextLine();

        System.out.print("Enter car model: ");
        String model = scanner.nextLine();

        System.out.print("Enter car year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter fuel type: ");
        String fuelType = scanner.nextLine();

        // Instantiate Car object
        Car car = new Car(brand, model, year, fuelType);

        // Display car details
        System.out.println("\nCar Details:");
        car.displayDetails();

        scanner.close();
    }
}