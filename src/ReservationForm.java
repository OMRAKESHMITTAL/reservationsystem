import java.util.Scanner;

public class ReservationForm {
    public static void reserveTicket(Scanner scanner) {
        System.out.println("Enter train number:");
        String trainNumber = scanner.nextLine();
        System.out.println("Enter class type:");
        String classType = scanner.nextLine();
        System.out.println("Enter date of journey:");
        String dateOfJourney = scanner.nextLine();
        System.out.println("Enter from station:");
        String fromStation = scanner.nextLine();
        System.out.println("Enter destination station:");
        String destinationStation = scanner.nextLine();
        System.out.println("Enter number of seats:");
        int numberOfSeats = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Reservation reservation = new Reservation(trainNumber, classType, dateOfJourney, fromStation, destinationStation, numberOfSeats);
        reservation.bookTicket();
    }
}
