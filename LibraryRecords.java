//REG NUMBER: CT100/G/22432/24
//NAME: ISAAC JULIUS WAINAINA
//WEEK 7 ASSIGNMENT

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LibraryRecords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the book title to store: ");
        String title = scanner.nextLine();

        try {
            // FileWriter in append mode (true) so existing records are not deleted
            FileWriter writer = new FileWriter("borrowed_books.txt", true);
            writer.write(title + System.lineSeparator()); // Add new line after each title
            writer.close();

            System.out.println("Book title successfully stored.");
        } catch (IOException e) {
            System.out.println("An error occurred while storing the book title.");
            e.printStackTrace();
        }

        scanner.close();
    }
}