package pl.camp.it.ApartHouseRegistration.DAO.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.camp.it.ApartHouseRegistration.DAO.IGuestDAO;

import pl.camp.it.ApartHouseRegistration.model.Guest;

import javax.persistence.NoResultException;
import java.util.List;
@Repository
public class GuestDAOImpl implements IGuestDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addGuest(Guest guest) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(guest);
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
    public List<Guest> getAllGuest() {
        Session session = this.sessionFactory.openSession();
        Query<Guest> query = session
                .createQuery("FROM pl.camp.it.ApartHouseRegistration.model.Guest");
        List<Guest> result = query.getResultList();
        session.close();
        return result;
    }

    @Override
    public Guest getGuestByName(String name) {
        try {
            Session session = sessionFactory.openSession();
            Query<Guest> query = session
                    .createQuery("FROM pl.camp.it.ApartHouseRegistration.model.Guest WHERE name = :name");
            query.setParameter("name", name);
            Guest guest = query.getSingleResult();
            session.close();
            return guest;
        } catch (NoResultException e) {
            return null;
        }
    }


}
