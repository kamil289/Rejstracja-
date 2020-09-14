package pl.camp.it.ApartHouseRegistration.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.camp.it.ApartHouseRegistration.model.Apartments;
import pl.camp.it.ApartHouseRegistration.model.Invoice;
import pl.camp.it.ApartHouseRegistration.service.IApartmentsService;
import pl.camp.it.ApartHouseRegistration.service.IInvoiceService;

@Controller
public class InvoiceController {
    @Autowired
    IInvoiceService invoiceService;


    @RequestMapping(value = "/invoice", method = RequestMethod.GET)
    public String addInvoi(Model model) {
        model.addAttribute("invoi", new Invoice());
        return "invoice";
    }


    @RequestMapping(value = "/invoice", method = RequestMethod.POST)
    public String addInvoToDB(@ModelAttribute Invoice invoice) {

        this.invoiceService.addInvoice(invoice);

        return "redirect:/invoice";
    }
}
