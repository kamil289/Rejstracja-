package pl.camp.it.ApartHouseRegistration.session;

import pl.camp.it.ApartHouseRegistration.model.Apartments;
import pl.camp.it.ApartHouseRegistration.model.User;

import java.util.ArrayList;
import java.util.List;


public class SessionObject {
    private User user;
    private List<Apartments> allApart =new ArrayList<>();
    private List<Apartments> freeApart =new ArrayList<>();
    private List<Apartments> busyApart =new ArrayList<>();

    public List<Apartments> getAllApart() {
        return allApart;
    }

    public void setAllApart(List<Apartments> allApart) {
        this.allApart = allApart;
    }

    public List<Apartments> getFreeApart() {
        return freeApart;
    }

    public void setFreeApart(List<Apartments> freeApart) {
        this.freeApart = freeApart;
    }

    public List<Apartments> getBusyApart() {
        return busyApart;
    }

    public void setBusyApart(List<Apartments> busyApart) {
        this.busyApart = busyApart;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
