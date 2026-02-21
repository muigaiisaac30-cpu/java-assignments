//REGISTRATION NUMBER: CT100/G/22432/24
//NAME : ISAAC JULIUS WAINAINA
    

// Base class Vehicle
class Vehicle {
    String brand;
    String model;
    int year;

    // Constructor
    public Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // Method to display vehicle details
    public void displayDetails() {
        System.out.println("Vehicle Brand: " + brand);
        System.out.println("Vehicle Model: " + model);
        System.out.println("Year of Manufacture: " + year);
    }
}

// Main class to run the program
public class Main {
    public static void main(String[] args) {
        // Create an object of Vehicle
        Vehicle myVehicle = new Vehicle("Toyota", "Corolla", 2022);

        // Display details
        myVehicle.displayDetails();
    }
}