package pl.camp.it.ApartHouseRegistration.DAO;

import pl.camp.it.ApartHouseRegistration.model.Apartments;
import pl.camp.it.ApartHouseRegistration.model.User;

import java.util.List;

public interface IApartmentsDAO {
    void addApartments(Apartments apartments);

    List<Apartments> getAllApartments();


    List<Apartments> getCategoryApartments(Apartments.ReadyToRent readyToRent);

    Apartments getApartByNumber(String number);
}
