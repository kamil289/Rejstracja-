package pl.camp.it.ApartHouseRegistration.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.camp.it.ApartHouseRegistration.model.Apartments;
import pl.camp.it.ApartHouseRegistration.service.IApartmentsService;


import javax.annotation.Resource;

@Controller
public class ApartmentsController {
    @Autowired
    IApartmentsService apartmentsService;


    @RequestMapping(value = "/addApartments", method = RequestMethod.GET)
    public String addAp(Model model) {
        model.addAttribute("apart", new Apartments());
        return "addApartments";
    }


    @RequestMapping(value = "/addApartments", method = RequestMethod.POST)
    public String addAp2(@ModelAttribute Apartments apartments) {

        this.apartmentsService.addApartments(apartments);

        return "redirect:/main";
    }

}
