package dao;

import config.HibernateUtil;
import model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeDAOImpl implements EmployeeDAO {

    private SessionFactory sessionFactory;

    public EmployeeDAOImpl() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public void addEmployee(Employee employee) {
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }

    @Override
    public Employee getEmployeeById(int id) {
        return HibernateUtil.getSessionFactory().openSession().get(Employee.class, id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> users = (List<Employee>) HibernateUtil
                .getSessionFactory().openSession().createQuery("from Employee").list();
        return users;
    }

    @Override
    public void updateEmployee(Employee employee) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }
    }

    @Override
    public void deleteEmployee(Employee employee) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }
    }
}


