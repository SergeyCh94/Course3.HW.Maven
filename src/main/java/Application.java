import dao.CityDAO;
import dao.CityDAOImpl;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.City;
import model.Employee;

import java.util.List;


public class Application {

    public static void main(String[] args) {
        // Add
        City city = new City("London");
        CityDAO cityDao = new CityDAOImpl();
        cityDao.addCity(city);

        // Add employee
        Employee employee = new Employee(1,"John", "Doe", 30, "Male", city);
        EmployeeDAO employeeDao = new EmployeeDAOImpl();
        employeeDao.addEmployee(employee);

        // All city
        List<City> cities = cityDao.listCities();
        for (City c : cities) {
            System.out.println(c.getCity_name());
        }

        // All employees
        List<Employee> employees = employeeDao.getAllEmployees();
        for (Employee e : employees) {
            System.out.println(e.getFirstName() + " " + e.getLastName());
        }

        // Update
        employee.setAge(35);
        employeeDao.updateEmployee(employee);

        // Delete employee
        employeeDao.deleteEmployee(employee);

        // Delete city
        cityDao.deleteCity(city);

    }
}



