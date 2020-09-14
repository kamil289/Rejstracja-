package pl.camp.it.ApartHouseRegistration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.camp.it.ApartHouseRegistration.DAO.IGuestDAO;
import pl.camp.it.ApartHouseRegistration.model.Guest;
import pl.camp.it.ApartHouseRegistration.service.IGuestService;

import java.util.List;
@Service
public class GuestServiceImpl implements IGuestService {

    @Autowired
    IGuestService guestService;
    @Autowired
    IGuestDAO guestDAO;

    @Override
    public void addGuest(Guest guest) {
        guestService.addGuest(guest);

    }

    @Override
    public List<Guest> getAllGuest() {
        return this.guestService.getAllGuest();
    }

    @Override
    public Guest getGuestByName(String name) {
        return this.guestService.getGuestByName(name);
    }
}
