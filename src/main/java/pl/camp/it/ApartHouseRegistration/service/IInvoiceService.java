package pl.camp.it.ApartHouseRegistration.service;

import pl.camp.it.ApartHouseRegistration.model.Invoice;

import java.util.List;

public interface IInvoiceService {
    void addInvoice(Invoice invoice);

    List<Invoice> getAllInvoice();
}
