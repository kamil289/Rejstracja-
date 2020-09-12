package pl.camp.it.ApartHouseRegistration.service;

import pl.camp.it.ApartHouseRegistration.model.User;

public interface IUserService {
    boolean authenticate(User user);
    void addUser(User user);
    boolean registerUser(User user, String repeatedPassword);
}
