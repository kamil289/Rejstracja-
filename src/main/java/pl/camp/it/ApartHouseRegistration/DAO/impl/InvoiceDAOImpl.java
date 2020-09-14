package pl.camp.it.ApartHouseRegistration.DAO.impl;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.camp.it.ApartHouseRegistration.DAO.IInvoiceDAO;
import pl.camp.it.ApartHouseRegistration.model.Apartments;
import pl.camp.it.ApartHouseRegistration.model.Invoice;

import java.util.List;


@Repository
public class InvoiceDAOImpl implements IInvoiceDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addInvoice(Invoice invoice) {

        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(invoice);
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
    public List<Invoice> getAllInvoice() {
        Session session = this.sessionFactory.openSession();
        Query<Invoice> query = session
                .createQuery("FROM pl.camp.it.ApartHouseRegistration.model.Invoice");
        List<Invoice> result = query.getResultList();
        session.close();
        return result;
    }
}
    

