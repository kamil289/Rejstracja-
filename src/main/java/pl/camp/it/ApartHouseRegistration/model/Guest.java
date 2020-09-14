package pl.camp.it.ApartHouseRegistration.model;

import javax.persistence.*;
import java.time.LocalDate;

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
    @Column(nullable = false, length = 3)
    private String roommate;
    @Column(nullable = false, unique = true, length = 365)
    private LocalDate timeOfVisit;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Apartments apartments;
   /* @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Invoice invoice;*/

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void setRoommate(String roommate) {
        this.roommate = roommate;
    }

    public void setTimeOfVisit(LocalDate timeOfVisit) {
        this.timeOfVisit = timeOfVisit;
    }

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


    public Apartments getApartments() {
        return apartments;
    }

    public void setApartments(Apartments apartments) {
        this.apartments = apartments;
    }

    /*public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }*/

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", nationality='" + nationality + '\'' +
                ", roommate=" + roommate +
                ", timeOfVisit=" + timeOfVisit +
                ", apartments=" + apartments +
               /* ", invoice=" + invoice +*/
                '}';
    }
}
