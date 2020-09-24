package pl.camp.it.ApartHouseRegistration.model;


import javax.persistence.*;

@Entity(name = "tguest")
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    private String nationality;
    @Column(nullable = false, unique = true)
    private String pesel;
    @Column(nullable = false)
    private String roommate;
    @Column(nullable = false)
    private String timeOfVisit;
    @Enumerated(EnumType.STRING)
    private Guest.GuestRegister guestRegister;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Apartments apartments;
   /* @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Invoice invoice;*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getRoommate() {
        return roommate;
    }

    public void setRoommate(String roommate) {
        this.roommate = roommate;
    }

    public String getTimeOfVisit() {
        return timeOfVisit;
    }

    public void setTimeOfVisit(String timeOfVisit) {
        this.timeOfVisit = timeOfVisit;
    }

    public GuestRegister getGuestRegister() {
        return guestRegister;
    }

    public void setGuestRegister(GuestRegister guestRegister) {
        this.guestRegister = guestRegister;
    }

    public Apartments getApartments() {
        return apartments;
    }

    public void setApartments(Apartments apartments) {
        this.apartments = apartments;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", nationality='" + nationality + '\'' +
                ", pesel='" + pesel + '\'' +
                ", roommate='" + roommate + '\'' +
                ", timeOfVisit='" + timeOfVisit + '\'' +
                ", guestRegister=" + guestRegister +
                ", apartments=" + apartments +
                '}';
    }

    public enum GuestRegister {
        YES,
        NO
    }
}
