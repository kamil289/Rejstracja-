package pl.camp.it.ApartHouseRegistration.service;

import pl.camp.it.ApartHouseRegistration.model.Apartments;
import pl.camp.it.ApartHouseRegistration.model.Guest;

import java.util.List;

public interface IApartmentsService {
    boolean addApartments(Apartments apartments);
    List<Apartments> getAllApartments();
    List<Apartments> getCategoryApartments(Apartments.ReadyToRent readyToRent);
    List<Apartments> findApartments(String pattern);
    Apartments getApartByNumber(String number);
    Apartments getApartById(int id);
    void updateApartments(Apartments apartments, Guest guest);
    void delateApartments(Apartments apartments);

    boolean authenticate(Apartments apartments);
}
