package pl.camp.it.ApartHouseRegistration.DAO;

import pl.camp.it.ApartHouseRegistration.model.Apartments;
import pl.camp.it.ApartHouseRegistration.model.Guest;

import java.util.List;

public interface IApartmentsDAO {
    void addApartments(Apartments apartments);

    List<Apartments> getAllApartments();
    List<Apartments> findApartments(String pattern);

    List<Apartments> getCategoryApartments(Apartments.ReadyToRent readyToRent);

    Apartments getApartByNumber(String number);
   Apartments getApartById(int id);

    void updateApartments(Apartments apartments, Guest guest);

    void delateApartments(Apartments apartments);
}
