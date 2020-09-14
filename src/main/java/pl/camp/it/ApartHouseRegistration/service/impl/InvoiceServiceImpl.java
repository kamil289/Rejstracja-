package pl.camp.it.ApartHouseRegistration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.camp.it.ApartHouseRegistration.DAO.IApartmentsDAO;
import pl.camp.it.ApartHouseRegistration.DAO.IInvoiceDAO;
import pl.camp.it.ApartHouseRegistration.model.Apartments;
import pl.camp.it.ApartHouseRegistration.model.Invoice;
import pl.camp.it.ApartHouseRegistration.service.IInvoiceService;

import java.util.List;

@Service
public class InvoiceServiceImpl implements IInvoiceService {
    @Autowired
    IInvoiceDAO invoiceDAO;
    @Override
    public void addInvoice(Invoice invoice) {

        this.invoiceDAO.addInvoice(invoice);
    }

    @Override
    public List<Invoice> getAllInvoice() {
        return this.invoiceDAO.getAllInvoice();
    }

}
