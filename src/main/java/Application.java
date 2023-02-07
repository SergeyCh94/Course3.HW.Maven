import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) throws SQLException {

        final String user = "postgres";
        final String password = "160894Sveta";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            // Создаем объект класса EmployeeDAOImpl
            EmployeeDAO employeeDAO = new EmployeeDAOImpl(connection);

            City city1 = new City(1, "Gomel");
            City city2 = new City(2, "Minsk");
            City city3 = new City(3, "Moscow");
            Employee employee1 = new Employee(1, "Ivan", "Ivanov", "Male", 29, 1);

            // Вызываем метод добавления объекта
            employeeDAO.addEmployee(employee1);

            employeeDAO.deleteEmployee(19);

            // Создаем список наполняя его объектами, которые получаем
            // путем вызова метода для получения всех элементов таблицы
            List<Employee> list = new ArrayList<>(employeeDAO.getAllEmployees());

            // Выведем список в консоль
            for (Employee employee : list) {
                System.out.println(employee);
            }

        }
    }
}

