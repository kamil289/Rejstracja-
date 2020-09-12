package pl.camp.it.ApartHouseRegistration.DAO.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.camp.it.ApartHouseRegistration.DAO.IApartmentsDAO;
import pl.camp.it.ApartHouseRegistration.model.Apartments;

@Repository
public class ApartmentsDAOImpl implements IApartmentsDAO {
    @Autowired
    SessionFactory sessionFactory;
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
}
