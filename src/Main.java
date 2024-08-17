import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Your application logic here
        // For example, starting the reservation system
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = Login.login(scanner);

        if (loggedIn) {
            while (true) {
                System.out.println("\nSelect an option:");
                System.out.println("1. Reserve Ticket");
                System.out.println("2. Cancel Ticket");
                System.out.println("3. Exit");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                if (choice == 1) {
                    ReservationForm.reserveTicket(scanner);
                } else if (choice == 2) {
                    CancellationForm.cancelTicket(scanner);
                } else if (choice == 3) {
                    System.out.println("Exiting...");
                    break;
                } else {
                    System.out.println("Invalid choice. Please select a valid option.");
                }
            }
        }

        scanner.close();
    }
}
