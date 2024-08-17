import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationRepository {
    public static void addReservation(Reservation reservation) {
        String sql = "INSERT INTO reservations (pnr_number, train_number, class_type, date_of_journey, from_station, destination_station, number_of_seats, is_booked) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, reservation.getPnrNumber());
            preparedStatement.setString(2, reservation.getTrainNumber());
            preparedStatement.setString(3, reservation.getClassType());
            preparedStatement.setString(4, reservation.getDateOfJourney());
            preparedStatement.setString(5, reservation.getFromStation());
            preparedStatement.setString(6, reservation.getDestinationStation());
            preparedStatement.setInt(7, reservation.getNumberOfSeats());
            preparedStatement.setBoolean(8, reservation.isBooked());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Reservation added successfully.");
            } else {
                System.out.println("Failed to add reservation.");
            }
        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
            e.printStackTrace();
        }
    }


    public static void deleteReservation(String pnrNumber) {
        String query = "DELETE FROM reservations WHERE pnrNumber = ?";

        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, pnrNumber);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error while deleting reservation: " + e.getMessage());
        }
    }

    public static Reservation getReservationByPnr(String pnrNumber) {
        String query = "SELECT * FROM reservations WHERE pnrNumber = ?";

        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, pnrNumber);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Reservation(
                        resultSet.getString("trainNumber"),
                        resultSet.getString("classType"),
                        resultSet.getString("dateOfJourney"),
                        resultSet.getString("fromStation"),
                        resultSet.getString("destinationStation"),
                        resultSet.getInt("numberOfSeats")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error while fetching reservation: " + e.getMessage());
        }

        return null;
    }
}
