import java.io.*;
import java.util.Scanner;

class InvalidCustomerIDException extends Exception {
    public InvalidCustomerIDException(String s) { super(s); }
}

public class Assignment4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter Customer ID (1-20): ");
            int cid = sc.nextInt();
            if (cid < 1 || cid > 20) throw new InvalidCustomerIDException("ID out of range!");

            System.out.print("Enter Name: ");
            String name = sc.next();

            System.out.print("Enter Initial Deposit (Min 1000): ");
            double amount = sc.nextDouble();
            if (amount < 1000) throw new Exception("Minimum 1000 required!");

            // File I/O logic
            FileWriter writer = new FileWriter("bank_records.txt", true);
            writer.write("ID: " + cid + ", Name: " + name + ", Balance: " + amount + "\n");
            writer.close();
            
            System.out.println("Record saved successfully to file.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}