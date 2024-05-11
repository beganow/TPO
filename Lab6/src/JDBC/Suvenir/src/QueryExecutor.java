import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryExecutor {
    public static void getSouvenirsByManufacturer(String manufacturerName) {
        String query = "SELECT * FROM Souvenirs s " +
                "JOIN Manufacturers m ON s.ManufacturerId = m.ManufacturerId " +
                "WHERE m.Name = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, manufacturerName);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int souvenirId = resultSet.getInt("SouvenirId");
                String souvenirName = resultSet.getString("Name");
                int manufacturerId = resultSet.getInt("ManufacturerId");
                manufacturerName = resultSet.getString("Name");
                // Дополнительная обработка результатов запроса
                System.out.println("Souvenir: " + souvenirId + ", " + souvenirName);
                System.out.println("Manufacturer: " + manufacturerId + ", " + manufacturerName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getSouvenirsByCountry(String country) {
        String query = "SELECT * FROM Souvenirs s " +
                "JOIN Manufacturers m ON s.ManufacturerId = m.ManufacturerId " +
                "WHERE m.Country = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, country);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int souvenirId = resultSet.getInt("SouvenirId");
                String souvenirName = resultSet.getString("Name");
                int manufacturerId = resultSet.getInt("ManufacturerId");
                String manufacturerName = resultSet.getString("Name");
                // Дополнительная обработка результатов запроса
                System.out.println("Souvenir: " + souvenirId + ", " + souvenirName);
                System.out.println("Manufacturer: " + manufacturerId + ", " + manufacturerName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getManufacturersByPrice(double price) {
        String query = "SELECT * FROM Manufacturers m " +
                "JOIN Souvenirs s ON m.ManufacturerId = s.ManufacturerId " +
                "WHERE s.Price < ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setDouble(1, price);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int manufacturerId = resultSet.getInt("ManufacturerId");
                String manufacturerName = resultSet.getString("Name");
                // Дополнительная обработка результатов запроса
                System.out.println("Manufacturer: " + manufacturerId + ", " + manufacturerName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getManufacturersBySouvenirAndYear(String souvenirName, int year) {
        String query = "SELECT * FROM Manufacturers m " +
                "JOIN Souvenirs s ON m.ManufacturerId = s.ManufacturerId " +
                "WHERE s.Name = ? AND YEAR(s.ReleaseDate) = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, souvenirName);
            statement.setInt(2, year);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int manufacturerId = resultSet.getInt("ManufacturerId");
                String manufacturerName = resultSet.getString("Name");
                // Дополнительная обработка результатов запроса
                System.out.println("Manufacturer: " + manufacturerId + ", " + manufacturerName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}