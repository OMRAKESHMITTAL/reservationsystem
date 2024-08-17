import java.util.Scanner;

public class CancellationForm {
    public static void cancelTicket(Scanner scanner) {
        System.out.println("Enter PNR number to cancel:");
        String pnrNumber = scanner.nextLine();

        Reservation reservation = ReservationRepository.getReservationByPnr(pnrNumber); // Implement this method to fetch reservation by PNR
        if (reservation != null) {
            reservation.cancelTicket();
        } else {
            System.out.println("No reservation found with the provided PNR number.");
        }
    }
}
