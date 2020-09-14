package pl.camp.it.ApartHouseRegistration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.camp.it.ApartHouseRegistration.DAO.IApartmentsDAO;
import pl.camp.it.ApartHouseRegistration.model.Apartments;
import pl.camp.it.ApartHouseRegistration.service.IApartmentsService;

import java.util.List;

@Service
public class ApartmentsServiceImpl implements IApartmentsService {
    @Autowired
    IApartmentsDAO apartmentsDAO;
    @Override
    public boolean addApartments(Apartments apartments) {

        this.apartmentsDAO.addApartments(apartments);
        return false;
    }

    @Override
    public List<Apartments> getAllApartments() {
        return this.apartmentsDAO.getAllApartments();
    }

    @Override
    public List<Apartments> getCategoryApartments(Apartments.ReadyToRent readyToRent) {
        return this.apartmentsDAO.getCategoryApartments(readyToRent);
    }

    @Override
    public boolean authenticate(Apartments apartments) {
        Apartments ApartFromDataBase = apartmentsDAO.getApartByNumber(apartments.getNumber());
        if(ApartFromDataBase == null){
            return false;
        }
        if(apartments.getNumber().equals(ApartFromDataBase.getNumber())){
            return true;
        }else{
            return false;
        }
    }


}
