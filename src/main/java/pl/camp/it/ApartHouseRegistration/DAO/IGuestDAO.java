package pl.camp.it.ApartHouseRegistration.DAO;

import pl.camp.it.ApartHouseRegistration.model.Apartments;
import pl.camp.it.ApartHouseRegistration.model.Guest;

import java.util.List;

public interface IGuestDAO {
    void addGuest(Guest guest);

    List<Guest> getAllGuest();

    Guest getGuestByName(String name);

}
