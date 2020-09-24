package pl.camp.it.ApartHouseRegistration.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.camp.it.ApartHouseRegistration.model.Guest;
import pl.camp.it.ApartHouseRegistration.service.IGuestService;
import pl.camp.it.ApartHouseRegistration.session.SessionObject;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class GuestController {

    @Autowired
    IGuestService guestService;

    @Resource
    SessionObject sessionObject;



    @RequestMapping(value = "/registerGuest", method = RequestMethod.GET)
    public String registGue(Model model) {
        model.addAttribute("guest", new Guest());
        return "registerGuest";
    }


    @RequestMapping(value = "/listGuest", method = RequestMethod.GET)
    public String allGuestes(Model model) {
        List<Guest> guest = this.guestService.getAllGuest();
        model.addAttribute("guest", guest);
        this.sessionObject.setLastAddress("/listGuest");
        return "listGuest";
    }

    @RequestMapping(value = "/registerGuest", method = RequestMethod.POST)
    public String addGueToDB(@ModelAttribute Guest guest) {

        this.guestService.addGuest(guest);

            return "redirect:/registerGuest";

    }
    @RequestMapping(value = "/guestInApartment", method = RequestMethod.GET)
    public String guestInApart(Model model) {
        model.addAttribute("isLogged", (sessionObject.getUser() != null));
        List<Guest> guests = this.guestService
                .getGuestByStatus(Guest.GuestRegister.YES);
        model.addAttribute("guests", guests);
        System.out.println(guests);
        this.sessionObject.setLastAddress("/guestInApartment");
        return "guestInApartment";
    }

    @RequestMapping(value = "/guestWaitToRegister", method = RequestMethod.GET)
    public String guestWaitToRegist(Model model) {
        model.addAttribute("isLogged", (sessionObject.getUser() != null));
        List<Guest> guests = this.guestService
                .getGuestByStatus(Guest.GuestRegister.NO);
        model.addAttribute("guests", guests);
        this.sessionObject.setLastAddress("/guestInApartment");
        return "guestWaitToRegister";
    }


}


