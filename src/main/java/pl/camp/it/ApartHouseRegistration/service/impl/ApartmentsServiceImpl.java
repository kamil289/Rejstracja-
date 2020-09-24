package pl.camp.it.ApartHouseRegistration.service.impl;

import com.fasterxml.jackson.databind.deser.impl.CreatorCandidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.camp.it.ApartHouseRegistration.DAO.IApartmentsDAO;
import pl.camp.it.ApartHouseRegistration.model.Apartments;
import pl.camp.it.ApartHouseRegistration.model.Guest;
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
    public List<Apartments> findApartments(String pattern) {
        return this.apartmentsDAO.findApartments(pattern);
    }

    @Override
    public Apartments getApartByNumber(String number) {
        return this.apartmentsDAO.getApartByNumber(number);
    }

    @Override
    public Apartments getApartById(int id) {
        return this.apartmentsDAO.getApartById(id);
    }

    @Override
    public void updateApartments(Apartments apartments, Guest guest) {
        this.apartmentsDAO.updateApartments(apartments, guest);

    }

    @Override
    public void delateApartments(Apartments apartments) {
        this.apartmentsDAO.delateApartments(apartments);

    }

   /* @Override
    public boolean updateApartments(Apartments apartments) {
        Apartments apatToUpdate = apartmentsDAO.getApartById(apartments.getId());
        if(apatToUpdate == null){
            return false;
        }else{

        }


    }*/


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
