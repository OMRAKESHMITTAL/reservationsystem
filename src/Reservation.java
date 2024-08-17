import java.util.UUID;

public class Reservation {

    private final String trainNumber;
    private final String classType;
    private final String dateOfJourney;
    private final String fromStation;
    private final String destinationStation;
    private final int numberOfSeats;
    private boolean isBooked;
    private final String pnrNumber;

    public Reservation(String trainNumber, String classType, String dateOfJourney, String fromStation, String destinationStation, int numberOfSeats) {
        this.trainNumber = trainNumber;
        this.classType = classType;
        this.dateOfJourney = dateOfJourney;
        this.fromStation = fromStation;
        this.destinationStation = destinationStation;
        this.numberOfSeats = numberOfSeats;
        this.isBooked = false;
        this.pnrNumber = generatePnrNumber();
    }

    private String generatePnrNumber() {
        return "PNR-" + UUID.randomUUID().toString();
    }

    public void bookTicket() {
        if (!isBooked) {
            this.isBooked = true;
            ReservationRepository.addReservation(this);
            System.out.println("Ticket booked successfully!");
            System.out.println("Your PNR number is: " + pnrNumber);
        } else {
            System.out.println("Sorry, the ticket is already booked!");
        }
    }

    public void cancelTicket() {
        if (isBooked) {
            this.isBooked = false;
            ReservationRepository.deleteReservation(pnrNumber);
            System.out.println("Ticket cancelled successfully!");
        } else {
            System.out.println("Sorry, the ticket is not booked yet!");
        }
    }

    public String getPnrNumber() {
        return this.pnrNumber;
    }

    public String getTrainNumber() {
        return this.trainNumber;
    }

    public String getClassType() {
        return this.classType;
    }

    public String getDateOfJourney() {
        return this.dateOfJourney;
    }

    public String getFromStation() {
        return this.fromStation;
    }

    public String getDestinationStation() {
        return this.destinationStation;
    }

    public int getNumberOfSeats() {
        return this.numberOfSeats;
    }

    public boolean isBooked() {
        return this.isBooked;
    }
}
