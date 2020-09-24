package pl.camp.it.ApartHouseRegistration.session;

import pl.camp.it.ApartHouseRegistration.model.Apartments;
import pl.camp.it.ApartHouseRegistration.model.Guest;
import pl.camp.it.ApartHouseRegistration.model.User;

import java.util.ArrayList;
import java.util.List;


public class SessionObject {
    private User user;
    private List<Apartments> allApart =new ArrayList<>();
    private List<Apartments> freeApart =new ArrayList<>();
    private List<Apartments> busyApart =new ArrayList<>();
    private String lastAddress;
    private List<Apartments> rentApart = new ArrayList<>();
    private List<Guest> allGuestes = new ArrayList<>();
    private List<Guest> guestInApart= new ArrayList<>();
    private List<Guest> guestWaitToRegist= new ArrayList<>();

    public List<Guest> getAllGuestes() {
        return allGuestes;
    }

    public void setAllGuestes(List<Guest> allGuestes) {
        this.allGuestes = allGuestes;
    }

    public List<Guest> getGuestInApart() {
        return guestInApart;
    }

    public void setGuestInApart(List<Guest> guestInApart) {
        this.guestInApart = guestInApart;
    }

    public List<Guest> getGuestWaitToRegist() {
        return guestWaitToRegist;
    }

    public void setGuestWaitToRegist(List<Guest> guestWaitToRegist) {
        this.guestWaitToRegist = guestWaitToRegist;
    }

    public String getLastAddress() {
        return lastAddress;
    }

    public void setLastAddress(String lastAddress) {
        this.lastAddress = lastAddress;
    }

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

    public Apartments getRentApart() {
        return (Apartments) rentApart;
    }

    public void setRentApart(List<Apartments> rentApart) {
        this.rentApart = rentApart;
    }
}
