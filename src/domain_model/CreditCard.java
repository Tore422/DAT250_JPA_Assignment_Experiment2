package domain_model;

import javax.persistence.*;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int number;
    private int limit;
    private int balance;

    @OneToOne
    private PinCode pincode;

    @ManyToOne
    @JoinTable(name = "jnd_bank_card", joinColumns = @JoinColumn(name = "card_fk"),
    inverseJoinColumns = @JoinColumn(name = "bank_fk"))
    private Bank bank;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public PinCode getPincode() {
        return pincode;
    }

    public void setPincode(PinCode pincode) {
        this.pincode = pincode;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
