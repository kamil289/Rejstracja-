package pl.camp.it.ApartHouseRegistration.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.camp.it.ApartHouseRegistration.model.Apartments;
import pl.camp.it.ApartHouseRegistration.service.IApartmentsService;
import pl.camp.it.ApartHouseRegistration.session.SessionObject;


import javax.annotation.Resource;
import java.util.List;

@Controller
public class ApartmentsController {
    @Autowired
    IApartmentsService apartmentsService;

    @Resource
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
        model.addAttribute("isLogged",(sessionObject.getUser() != null));
        List<Apartments> apartments = this.apartmentsService.getAllApartments();
        model.addAttribute("apartments", apartments);
        this.sessionObject.setLastAddress("/allApartments");
        return "allApartments";
    }
    @RequestMapping(value = "/busyApartments", method = RequestMethod.GET)
    public String busyApart(Model model) {
        model.addAttribute("isLogged",(sessionObject.getUser() != null));
        List<Apartments> apartments = this.apartmentsService.getCategoryApartments(Apartments.ReadyToRent.NO);
        model.addAttribute("apartments", apartments);
        this.sessionObject.setLastAddress("/busyApartments");
        return "busyApartments";
    }
    @RequestMapping(value = "/freeApartments", method = RequestMethod.GET)
    public String freeApart(Model model) {
        model.addAttribute("isLogged",(sessionObject.getUser() != null));
       List<Apartments> apartments = this.apartmentsService.getCategoryApartments(Apartments.ReadyToRent.YES);
        model.addAttribute("apartments", apartments);
        this.sessionObject.setLastAddress("/freeApartments");
       return "freeApartments";
    }
    @RequestMapping(value = "/findApartment", method = RequestMethod.POST)
    public String findApart(Model model, @RequestParam String pattern){
        model.addAttribute("isLogged",(sessionObject.getUser() != null));
        List<Apartments> apartments = this.apartmentsService.findApartments(pattern);
        model.addAttribute("apartments", apartments);
        this.sessionObject.setLastAddress("/findApartment");

        return "allApartment";
    }
}


