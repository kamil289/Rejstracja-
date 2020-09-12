package pl.camp.it.ApartHouseRegistration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.camp.it.ApartHouseRegistration.DAO.IApartmentsDAO;
import pl.camp.it.ApartHouseRegistration.model.Apartments;
import pl.camp.it.ApartHouseRegistration.service.IApartmentsService;

@Service
public class ApartmentsServiceImpl implements IApartmentsService {
    @Autowired
    IApartmentsDAO apartmentsDAO;
    @Override
    public void addApartments(Apartments apartments) {

        this.apartmentsDAO.addApartments(apartments);
    }
}
