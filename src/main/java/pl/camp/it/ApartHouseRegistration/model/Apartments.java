package pl.camp.it.ApartHouseRegistration.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Entity(name = "tapartments")
public class Apartments  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private String  number;
    @Column(nullable = false)
    private String roomCount;
    @Column(nullable = false, length = 3)
    private String bedCount;
    @Column(nullable = false )
    private String priceForDay;
    @Enumerated(EnumType.STRING)
    private Kitchenette kitchenette;
    @Enumerated(EnumType.STRING)
    private PetFriendly petFriendly;
    @Enumerated(EnumType.STRING)
    private ReadyToRent readyToRent;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Guest guest;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(String roomCount) {
        this.roomCount = roomCount;
    }

    public String getBedCount() {
        return bedCount;
    }

    public void setBedCount(String bedCount) {
        this.bedCount = bedCount;
    }

    public String getPriceForDay() {
        return priceForDay;
    }

    public void setPriceForDay(String priceForDay) {
        this.priceForDay = priceForDay;
    }

    public Kitchenette getKitchenette() {
        return kitchenette;
    }

    public void setKitchenette(Kitchenette kitchenette) {
        this.kitchenette = kitchenette;
    }

    public PetFriendly getPetFriendly() {
        return petFriendly;
    }

    public void setPetFriendly(PetFriendly petFriendly) {
        this.petFriendly = petFriendly;
    }

    public ReadyToRent getReadyToRent() {
        return readyToRent;
    }

    public void setReadyToRent(ReadyToRent readyToRent) {
        this.readyToRent = readyToRent;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    @Override
    public String toString() {
        return "Apartments{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", roomCount='" + roomCount + '\'' +
                ", bedCount='" + bedCount + '\'' +
                ", priceForDay='" + priceForDay + '\'' +
                ", kitchenette=" + kitchenette +
                ", petFriendly=" + petFriendly +
                ", readyToRent=" + readyToRent +
                ", guest=" + guest +
                '}';
    }




    public enum Kitchenette {
        YES,
        NO
    }
    public enum PetFriendly{
        YES,
        NO
    }
    public enum ReadyToRent{
        YES,
        NO
    }

}
