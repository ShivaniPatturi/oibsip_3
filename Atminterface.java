import java.util.Scanner;

public class Atminterface {

    private static double balance = 5000.00; 
    private static String transactionHistory = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to the ATM Interface!");

      
        while (!exit) {
     
            System.out.println("\nChoose an option:");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    showTransactionHistory();
                    break;
                case 2:
                    withdraw(sc);
                    break;
                case 3:
                    deposit(sc);
                    break;
                case 4:
                    transfer(sc);
                    break;
                case 5:
                    exit = true;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
                    break;
            }
        }

        sc.close();
    }

    private static void showTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("Transaction History:");
            System.out.println(transactionHistory);
        }
    }

    private static void withdraw(Scanner sc) {
        System.out.print("Enter the amount to withdraw: ");
        double amount = sc.nextDouble();

        if (amount > balance) {
            System.out.println("Insufficient funds. Your current balance is: " + balance);
        } else {
            balance -= amount;
            transactionHistory += "Withdrawn: " + amount + "\n";
            System.out.println("You have successfully withdrawn " + amount);
            System.out.println("Your new balance is: " + balance);
        }
    }

    private static void deposit(Scanner sc) {
        System.out.print("Enter the amount to deposit: ");
        double amount = sc.nextDouble();

        balance += amount;
        transactionHistory += "Deposited: " + amount + "\n";
        System.out.println("You have successfully deposited " + amount);
        System.out.println("Your new balance is: " + balance);
    }

    private static void transfer(Scanner sc) {
        System.out.print("Enter the amount to transfer: ");
        double amount = sc.nextDouble();

        if (amount > balance) {
            System.out.println("Insufficient funds. Your current balance is: " + balance);
        } else {
            System.out.print("Enter the recipient's account number: ");
            String recipient = sc.next();

            balance -= amount;
            transactionHistory += "Transferred: " + amount + " to Account " + recipient + "\n";
            System.out.println("You have successfully transferred " + amount + " to account " + recipient);
            System.out.println("Your new balance is: " + balance);
        }
    }
}