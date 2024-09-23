import java.util.Scanner;

public class onlinereservation {

    // Database of users (for simplicity, we use hardcoded username/password)
    private static String username = "admin";
    private static String password = "password";

    // Main method
    public static void main(String[] args) {
        boolean loggedIn = login();

        if (loggedIn) {
            System.out.println("Welcome to the Online Reservation System.");
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\n1. Make Reservation\n2. Cancel Reservation\n3. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        makeReservation();
                        break;
                    case 2:
                        cancelReservation();
                        break;
                    case 3:
                        System.out.println("Exiting the system.");
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        }
    }

    // Login Method
    public static boolean login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String inputUsername = scanner.nextLine();

        System.out.print("Enter password: ");
        String inputPassword = scanner.nextLine();

        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Invalid credentials. Try again.");
            return false;
        }
    }

    // Reservation System
    public static void makeReservation() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Train Number: ");
        String trainNumber = scanner.nextLine();

        System.out.print("Enter Class Type: ");
        String classType = scanner.nextLine();

        System.out.print("Enter Date of Journey (DD/MM/YYYY): ");
        String dateOfJourney = scanner.nextLine();

        System.out.print("Enter Source: ");
        String source = scanner.nextLine();

        System.out.print("Enter Destination: ");
        String destination = scanner.nextLine();

        System.out.println("Reservation successful!");
        System.out.println("Train Number: " + trainNumber + ", Class: " + classType +
                ", Date: " + dateOfJourney + ", From: " + source + ", To: " + destination);
    }

    // Cancellation System
    public static void cancelReservation() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter PNR number: ");
        String pnrNumber = scanner.nextLine();

        // Perform database query to check if PNR exists (for now, just simulating)
        System.out.println("Ticket with PNR: " + pnrNumber + " has been cancelled.");
    }
}