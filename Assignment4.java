import java.io.*; 
import java.util.*; 

// User-defined Exception
class InvalidDataException extends Exception {
    InvalidDataException(String msg) {
        super(msg);
    }
}

// Main Class
public class Assignment4 {
    static final String FILE_NAME = "customers.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- Banking System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Withdraw Amount");
            System.out.println("3. Deposit Amount");
            System.out.println("4. Display Records");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        createAccount(sc);
                        break;
                    case 2:
                        withdrawAmount(sc);
                        break;
                    case 3:
                        depositAmount(sc);
                        break;
                    case 4:
                        displayRecords();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 5);
        sc.close();
    }

    // Create Account
    static void createAccount(Scanner sc) throws Exception {
        System.out.print("Enter CID (1-20): ");
        int cid = sc.nextInt();

        if (cid < 1 || cid > 20) {
            throw new InvalidDataException("CID must be between 1 and 20");
        }

        // Check duplicate CID
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (Scanner fr = new Scanner(file)) {
                while (fr.hasNext()) {
                    int id = fr.nextInt();
                    String n = fr.next();
                    double a = fr.nextDouble();

                    if (id == cid) {
                        throw new InvalidDataException("CID already exists!");
                    }
                }
            }
        }

        System.out.print("Enter Name: ");
        String name = sc.next();

        System.out.print("Enter Amount: ");
        double amt = sc.nextDouble();

        if (amt <= 0) {
            throw new InvalidDataException("Amount must be positive");
        }

        if (amt < 1000) {
            throw new InvalidDataException("Minimum balance is 1000");
        }

        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
            fw.write(cid + " " + name + " " + amt + "\n");
        }

        System.out.println("Account created successfully!");
    }

    // Withdraw Amount
    static void withdrawAmount(Scanner sc) throws Exception {
        System.out.print("Enter CID: ");
        int cid = sc.nextInt();

        System.out.print("Enter withdrawal amount: ");
        double wamt = sc.nextDouble();

        if (wamt <= 0) {
            throw new InvalidDataException("Amount must be positive");
        }

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            throw new InvalidDataException("No records found!");
        }

        String data = "";
        boolean found = false;

        try (Scanner fr = new Scanner(file)) {
            while (fr.hasNext()) {
                int id = fr.nextInt();
                String name = fr.next();
                double amt = fr.nextDouble();

                if (id == cid) {
                    found = true;

                    if (wamt > amt) {
                        throw new InvalidDataException("Insufficient balance");
                    }

                    amt = amt - wamt;
                    System.out.println("Withdrawal successful! Remaining: " + amt);
                }

                data += id + " " + name + " " + amt + "\n";
            }
        }

        if (!found) {
            throw new InvalidDataException("Customer not found");
        }

        try (FileWriter fw = new FileWriter(FILE_NAME)) {
            fw.write(data);
        }
    }

    // Deposit Amount
    static void depositAmount(Scanner sc) throws Exception {
        System.out.print("Enter CID: ");
        int cid = sc.nextInt();

        System.out.print("Enter deposit amount: ");
        double damt = sc.nextDouble();

        if (damt <= 0) {
            throw new InvalidDataException("Amount must be positive");
        }

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            throw new InvalidDataException("No records found!");
        }

        String data = "";
        boolean found = false;

        try (Scanner fr = new Scanner(file)) {
            while (fr.hasNext()) {
                int id = fr.nextInt();
                String name = fr.next();
                double amt = fr.nextDouble();

                if (id == cid) {
                    found = true;
                    amt = amt + damt;
                    System.out.println("Deposit successful! New Balance: " + amt);
                }

                data += id + " " + name + " " + amt + "\n";
            }
        }

        if (!found) {
            throw new InvalidDataException("Customer not found");
        }

        try (FileWriter fw = new FileWriter(FILE_NAME)) {
            fw.write(data);
        }
    }

    // Display Records
    static void displayRecords() throws Exception {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            System.out.println("No records found!");
            return;
        }

        Scanner fr = new Scanner(file);

        System.out.println("\nCID  Name  Amount");
        while (fr.hasNext()) {
            System.out.println(
                    fr.nextInt() + "   " +
                    fr.next() + "   " +
                    fr.nextDouble());
        }

        fr.close();
    }
}