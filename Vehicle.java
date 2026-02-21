// NAME: ISAAC JULIUS WAINAINA
// REGISTRATION NUMBER: CT100/G/22432/24

// Vehicle.java
public class Vehicle {
    // Fields to store vehicle details
    protected String brand;
    protected String model;
    protected int year;

    // Constructor to initialize fields
    public Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // Method to display vehicle details
    public void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }
}