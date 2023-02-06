import java.sql.*;

public class Application {

    public static void main(String[] args) throws SQLException {

        final String user = "postgres";
        final String password = "160894Sveta";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE id = (?)")) {

            statement.setInt(1, 6);

            final ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String firstName = "First Name: " + resultSet.getString("first_name");
                String lastName = "Last Name: " + resultSet.getString("last_name");
                String gender = "Gender: " + resultSet.getString("gender");
                String city = "City: " + resultSet.getString("city_id");

                System.out.println(firstName);
                System.out.println(lastName);
                System.out.println(gender);
                System.out.println(city);
            }
        }
    }
}

