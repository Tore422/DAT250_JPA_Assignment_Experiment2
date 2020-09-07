package main;

import domain_model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    private static final String PERSISTENCE_UNIT_NAME = "transactions";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        Person person = new Person();
        person.setName("John");
        em.persist(person);

        Address address = new Address();
        address.setNumber(4040);
        address.setStreet("Nowhere_Lane_55");
        em.persist(address);

        CreditCard creditCard = new CreditCard();
        creditCard.setLimit(100000);
        creditCard.setBalance(999999);
        em.persist(creditCard);

        PinCode pinCode = new PinCode();
        pinCode.setPinCode("4321");
        pinCode.setCount(0);
        em.persist(pinCode);

        Bank bank = new Bank();
        bank.setName("MoneySavers");
        em.persist(bank);
        // Connect all the relationships between the entities.
        creditCard.setPincode(pinCode);
        creditCard.setBank(bank);
        bank.addCreditCard(creditCard);
        person.addCreditCard(creditCard);
        address.addInhabitant(person);
        person.addAddress(address);

        em.getTransaction().commit();
        em.close();
    }
}
