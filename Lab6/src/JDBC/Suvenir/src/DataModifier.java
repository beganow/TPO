import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataModifier {
    public static void deleteManufacturerAndSouvenirs(int manufacturerId) {
        String deleteSouvenirsQuery = "DELETE FROM Souvenirs WHERE ManufacturerId = ?";
        String deleteManufacturerQuery = "DELETE FROM Manufacturers WHERE ManufacturerId = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement deleteSouvenirsStatement = connection.prepareStatement(deleteSouvenirsQuery);
             PreparedStatement deleteManufacturerStatement = connection.prepareStatement(deleteManufacturerQuery)) {

            connection.setAutoCommit(false);

            deleteSouvenirsStatement.setInt(1, manufacturerId);
            deleteManufacturerStatement.setInt(1, manufacturerId);

            deleteSouvenirsStatement.executeUpdate();
            deleteManufacturerStatement.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}