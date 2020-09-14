package pl.camp.it.ApartHouseRegistration.service;

import pl.camp.it.ApartHouseRegistration.model.Apartments;

import java.util.List;

public interface IApartmentsService {
    boolean addApartments(Apartments apartments);
    List<Apartments> getAllApartments();
    List<Apartments> getCategoryApartments(Apartments.ReadyToRent readyToRent);

    boolean authenticate(Apartments apartments);
}
