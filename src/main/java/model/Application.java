package model;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Application {

    public static void main(String[] args) throws SQLException {
        EmployeeDAO employeeDAO= new EmployeeDAOImpl();

        Employee employee1 = new Employee(1, "John", "Doe", "Male", 30, 3);

        employeeDAO.addEmployee(employee1);

        System.out.println(employeeDAO.getEmployeeById(1));

        List<Employee> employees = employeeDAO.getAllEmployees();

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        Employee employee2 = new Employee(1, "Jane", "Doe", "Male", 30, 3);

        employeeDAO.updateEmployee(employee2);
        employeeDAO.deleteEmployee(employee2);
    }
}


