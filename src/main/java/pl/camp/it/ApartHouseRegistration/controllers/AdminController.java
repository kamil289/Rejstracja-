package pl.camp.it.ApartHouseRegistration.controllers;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.camp.it.ApartHouseRegistration.model.Apartments;
import pl.camp.it.ApartHouseRegistration.model.Guest;
import pl.camp.it.ApartHouseRegistration.model.User;
import pl.camp.it.ApartHouseRegistration.service.IApartmentsService;
import pl.camp.it.ApartHouseRegistration.service.IGuestService;
import pl.camp.it.ApartHouseRegistration.service.IUserService;

import java.time.LocalDate;

@Controller
@RequestMapping(value = "/admin/utils")
public class AdminController {

    @Autowired
    IUserService userService;
    @Autowired
    IApartmentsService apartmentsService;
    @Autowired
    IGuestService guestService;

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUser() {
        User user = new User();
        user.setLogin("admin");
        String hashedPassword = DigestUtils.md5Hex("admin");
        user.setPassword(hashedPassword);

        userService.addUser(user);

        return "redirect:/login";
    }

    @RequestMapping(value = "/addApartments", method = RequestMethod.GET)
    public String addApartments() {
        Apartments apartments1 = new Apartments();
        apartments1.setNumber("101");
        apartments1.setRoomCount("2");
        apartments1.setBedCount("3");
        apartments1.setPriceForDay("100");
        apartments1.setKitchenette(Apartments.Kitchenette.NO);
        apartments1.setPetFriendly(Apartments.PetFriendly.NO);
        apartments1.setReadyToRent(Apartments.ReadyToRent.YES);


        Apartments apartments2 = new Apartments();
        apartments2.setNumber("102");
        apartments2.setRoomCount("1");
        apartments2.setBedCount("3");
        apartments2.setPriceForDay("200");
        apartments2.setKitchenette(Apartments.Kitchenette.NO);
        apartments2.setPetFriendly(Apartments.PetFriendly.NO);
        apartments2.setReadyToRent(Apartments.ReadyToRent.YES);

        this.apartmentsService.addApartments(apartments1);
        this.apartmentsService.addApartments(apartments2);

        return "redirect:/main";
    }

    @RequestMapping(value = "/addGuest", method = RequestMethod.GET)
    public String addGuest() {
        Guest guest = new Guest();
        guest.setName("Kamil");
        guest.setSurname("Kamil");
        guest.setNationality("Poland");
        guest.setPesel("9090901212122");
        guest.setRoommate("2");
        guest.setTimeOfVisit("2020-20-20");
        guest.setGuestRegister(Guest.GuestRegister.NO);

        Guest guest1 = new Guest();
        guest1.setName("Janusz");
        guest1.setSurname("Janusz");
        guest1.setNationality("Poland");
        guest1.setPesel("909090121");
        guest1.setRoommate("2");
        guest1.setTimeOfVisit("2020-20-20");
        guest1.setGuestRegister(Guest.GuestRegister.YES);

        /*Apartments apartments3 = new Apartments();
        apartments3.setNumber("187");
        apartments3.setRoomCount("1");
        apartments3.setBedCount("3");
        apartments3.setPriceForDay("200");
        apartments3.setKitchenette(Apartments.Kitchenette.NO);
        apartments3.setPetFriendly(Apartments.PetFriendly.NO);
        apartments3.setReadyToRent(Apartments.ReadyToRent.NO);

        this.apartmentsService.addApartments(apartments3);*/

       /* guest.setApartments(apartments3);*/

        this.guestService.addGuest(guest);
        this.guestService.addGuest(guest1);

        return "redirect:/main";

    }


}
