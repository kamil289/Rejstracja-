package pl.camp.it.ApartHouseRegistration.service;

import pl.camp.it.ApartHouseRegistration.model.Guest;

import java.util.List;

public interface IGuestService {
    void addGuest(Guest guest);
    List<Guest> getAllGuest();
    Guest getGuestByName(String name);
    List<Guest> getGuestByStatus(Guest.GuestRegister guestRegister);

}
