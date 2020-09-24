package pl.camp.it.ApartHouseRegistration.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.camp.it.ApartHouseRegistration.model.Apartments;
import pl.camp.it.ApartHouseRegistration.model.Guest;
import pl.camp.it.ApartHouseRegistration.service.IApartmentsService;
import pl.camp.it.ApartHouseRegistration.service.IRentService;
import pl.camp.it.ApartHouseRegistration.session.SessionObject;

import javax.annotation.Resource;

@Controller
public class RentControler {
    @Autowired
    IRentService rentService;

    @Resource
    SessionObject sessionObject;
    @Autowired
    IApartmentsService apartmentsService;



    @RequestMapping(value = "/rentApart/{Id}", method = RequestMethod.GET)
    public String rentApart(Model model, @PathVariable int Id) {
        Apartments apartments = this.apartmentsService.getApartById(Id);
        model.addAttribute("apartments", apartments);

        return "rentApartments";
    }

    @RequestMapping(value = "/rentApart/{Id}", method = RequestMethod.POST)
    public String rentApartInDB(@PathVariable int Id, @ModelAttribute Apartments apartments
            , @RequestParam Guest guest) {

            this.apartmentsService.updateApartments(apartments, guest);

        return "allApartments";
    }

    /*@RequestMapping(value = "/freeApart/{id}", method = RequestMethod.GET)
    public String unrentApart(Model model, @PathVariable int Id) {
        Apartments apartments = this.apartmentsService.getApartById(Id);
        System.out.println("---------------------!!!!!!!!!!!!!!!!-------------------------");
        System.out.println(apartments);
        System.out.println("---------------------!!!!!!!!!!!!!!!!-------------------------");
        model.addAttribute("apartments", apartments);

        return "freeApartments";
    }*/

  /*  @RequestMapping(value = "/freeApart/{id}", method = RequestMethod.POST)
    public String unrentApartInDB(@PathVariable int Id, @ModelAttribute Apartments apartments) {

        System.out.println("---------------------!!!!!!!!!!!!!!!!1-------------------------");
        System.out.println(apartments);
        System.out.println(Id);
        System.out.println("---------------------!!!!!!!!!!!!!!!!1-------------------------");

        this.apartmentsService.updateApartments(apartments);

        System.out.println("---------------------!!!!!!!!!!!!!!!!2-------------------------");
        System.out.println(apartments);
        System.out.println(Id);
        System.out.println("---------------------!!!!!!!!!!!!!!!!2-------------------------");

        return "allApartments";
    }*/
}

