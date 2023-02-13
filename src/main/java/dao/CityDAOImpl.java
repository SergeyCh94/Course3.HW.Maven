package dao;

import config.HibernateUtil;
import model.City;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class CityDAOImpl implements CityDAO {

    @Override
    public void addCity(City city) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(city);
            transaction.commit();
        }
    }


    @Override
    public void updateCity(City city) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(city);
            transaction.commit();
        }
    }

    @Override
    public void deleteCity(City city) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.delete(city);
            transaction.commit();
        }
    }

    @Override
    public City getCityById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.get(City.class, id);
        }
    }

    @Override
    public List<City> listCities() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<City> criteria = builder.createQuery(City.class);
            criteria.from(City.class);
            return session.createQuery(criteria).getResultList();
        }
    }
}

