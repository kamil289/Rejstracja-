package pl.camp.it.ApartHouseRegistration.DAO.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.camp.it.ApartHouseRegistration.DAO.IApartmentsDAO;
import pl.camp.it.ApartHouseRegistration.model.Apartments;
import pl.camp.it.ApartHouseRegistration.model.Guest;
import pl.camp.it.ApartHouseRegistration.session.SessionObject;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class ApartmentsDAOImpl implements IApartmentsDAO {
    @Autowired
    SessionFactory sessionFactory;
    @Autowired
    SessionObject sessionObject;
    @Override
    public void addApartments(Apartments apartments) {

        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(apartments);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }
    @Override
    public List<Apartments> getAllApartments() {
        Session session = this.sessionFactory.openSession();
        Query<Apartments> query = session
                .createQuery("FROM pl.camp.it.ApartHouseRegistration.model.Apartments");
        List<Apartments> result = query.getResultList();
        session.close();
        return result;
    }

    @Override
    public List<Apartments> findApartments(String pattern) {
        Session session = this.sessionFactory.openSession();
        Query<Apartments> query = session
                .createQuery("FROM pl.camp.it.ApartHouseRegistration.model.Apartments WHERE number like :number");
        query.setParameter("number", "%" + pattern + "%");
        List<Apartments> result = query.getResultList();
        session.close();
        return result;
    }

    @Override
    public List<Apartments> getCategoryApartments(Apartments.ReadyToRent readyToRent) {
        try {
            Session session = sessionFactory.openSession();
            Query<Apartments> query = session
                    .createQuery("FROM pl.camp.it.ApartHouseRegistration.model.Apartments WHERE readyToRent = :readyToRent");
            query.setParameter("readyToRent", readyToRent);
            List<Apartments> result = query.getResultList();
            session.close();
            return result;
        } catch (NoResultException e) {
            return null;
        }
    }


    @Override
    public Apartments getApartByNumber(String number) {
        try {
            Session session = sessionFactory.openSession();
            Query<Apartments> query = session
                    .createQuery("FROM pl.camp.it.ApartHouseRegistration.model.Apartments WHERE number = :number");
            query.setParameter("number", number);
            Apartments apartments = query.getSingleResult();
            session.close();
            return apartments;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Apartments getApartById(int id) {
        Session session = this.sessionFactory.openSession();
        Query<Apartments> query = session
                .createQuery("FROM pl.camp.it.ApartHouseRegistration.model.Apartments WHERE id = :id");
        query.setParameter("id", id);
        Apartments result = query.getSingleResult();
        session.close();
        return result;
    }
    @Override
    public void updateApartments(Apartments apartments, Guest guest) {

        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(apartments);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public void delateApartments(Apartments apartments){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(apartments);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }
}
