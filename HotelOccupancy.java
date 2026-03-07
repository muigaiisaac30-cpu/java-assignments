//REG NUMBER: CT100/G/22432/24
//NAME: ISAAC JULIUS WAINAINA
//WEEK 6 ASSIGNMENT

import java.util.Random;

public class HotelOccupancy {
    public static void main(String[] args) {
        int floors = 5;
        int roomsPerFloor = 10;
        int[][] occupancy = new int[floors][roomsPerFloor];
        Random rand = new Random();

        // Simulate occupancy data (0 = vacant, 1 = occupied)
        for (int i = 0; i < floors; i++) {
            for (int j = 0; j < roomsPerFloor; j++) {
                occupancy[i][j] = rand.nextInt(2); // Generates 0 or 1
            }
        }

        // Display occupied and vacant rooms per floor
        for (int i = 0; i < floors; i++) {
            int occupied = 0;
            int vacant = 0;
            for (int j = 0; j < roomsPerFloor; j++) {
                if (occupancy[i][j] == 1) {
                    occupied++;
                } else {
                    vacant++;
                }
            }
            System.out.printf("Floor %d → Occupied: %d, Vacant: %d%n", i + 1, occupied, vacant);
        }
    }
}