package pl.camp.it.ApartHouseRegistration.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.camp.it.ApartHouseRegistration.model.Apartments;
import pl.camp.it.ApartHouseRegistration.model.User;
import pl.camp.it.ApartHouseRegistration.service.IApartmentsService;
import pl.camp.it.ApartHouseRegistration.session.SessionObject;


import javax.annotation.Resource;
import java.util.List;

@Controller
public class ApartmentsController {
    @Autowired
    IApartmentsService apartmentsService;
    @Autowired
    SessionObject sessionObject;


    @RequestMapping(value = "/addApartments", method = RequestMethod.GET)
    public String addApar(Model model) {
        model.addAttribute("apart", new Apartments());
        return "addApartments";
    }


    @RequestMapping(value = "/addApartments", method = RequestMethod.POST)
    public String addAparToDB(@ModelAttribute Apartments apartments) {

        boolean apatrReslut = this.apartmentsService.addApartments(apartments);

        if(apatrReslut) {
            return "redirect:/main";
        }else {
            return "redirect:/addApartments";
        }
    }

    @RequestMapping(value = "/allApartments", method = RequestMethod.GET)
    public String allApart(Model model) {
        List<Apartments> apartments = this.apartmentsService.getAllApartments();
        model.addAttribute("apartments", apartments);

        return "allApartments";
    }
    @RequestMapping(value = "/busyApartments", method = RequestMethod.GET)
    public String busyApart(Model model) {
        List<Apartments> apartments = this.apartmentsService.getCategoryApartments(Apartments.ReadyToRent.NO);
        model.addAttribute("apartments", apartments);
        return "busyApartments";
    }
    @RequestMapping(value = "/freeApartments", method = RequestMethod.GET)
    public String freeApart(Model model) {
       List<Apartments> apartments = this.apartmentsService.getCategoryApartments(Apartments.ReadyToRent.YES);
        model.addAttribute("apartments", apartments);
       return "freeApartments";
    }



}
