package pl.camp.it.ApartHouseRegistration.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.camp.it.ApartHouseRegistration.DAO.IGuestDAO;
import pl.camp.it.ApartHouseRegistration.model.Apartments;
import pl.camp.it.ApartHouseRegistration.model.Guest;
import pl.camp.it.ApartHouseRegistration.service.IGuestService;

import java.util.List;

@Controller
public class GuestController {

    @Autowired
    IGuestService guestService;
    @Autowired
    IGuestDAO guestDAO;

    @RequestMapping(value = "/listGuest", method = RequestMethod.GET)
    public String allGue(Model model) {
        /*List<Apartments> apartments = this.apartmentsService.getAllApartments();
        model.addAttribute("apartments", apartments);*/

        return "listGuest";
    }


    @RequestMapping(value = "/registerGuest", method = RequestMethod.GET)
    public String registerGue(Model model) {
        /*List<Apartments> apartments = this.apartmentsService.getAllApartments();
        model.addAttribute("apartments", apartments);*/

        return "registerGuest";
    }
    @RequestMapping(value = "/listGuest", method = RequestMethod.GET)
    public String guest(Model model) {
        model.addAttribute("guest", new Guest());
        return "listGuest";
    }

    @RequestMapping(value = "/listGuest", method = RequestMethod.POST)
    public String addGueToDB(@ModelAttribute Guest guest) {
        this.guestDAO.addGuest(guest);

            return "redirect:/listGuest";

    }

}


