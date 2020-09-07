package domain_model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String street;
    private int number;

    @ManyToMany(mappedBy = "addresses")
    private List<Person> inhabitants = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Person> getInhabitants() {
        return inhabitants;
    }

    public void setInhabitants(List<Person> inhabitants) {
        this.inhabitants = inhabitants;
    }

    /**
     * Add a person to list of people living on this address.
     * @param person
     *              Person to be added
     */
    public void addInhabitant(Person person) {
        this.getInhabitants().add(person);
    }
}
