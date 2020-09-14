package pl.camp.it.ApartHouseRegistration.DAO;

import pl.camp.it.ApartHouseRegistration.model.Apartments;
import pl.camp.it.ApartHouseRegistration.model.Invoice;

import java.util.List;

public interface IInvoiceDAO {
    void addInvoice(Invoice invoice);

    List<Invoice> getAllInvoice();
}
