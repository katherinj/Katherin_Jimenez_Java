package com.company;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private List<AccountRecord> charges = new ArrayList<>();

    // constructor
    public Customer(int id, String name, AccountRecord accountRec){
        this.id = id;
        this.name=name;
        charges.add(accountRec);

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

    public void addCharge(int charge, String chargeDate) {
        charges.add(new AccountRecord(charge, chargeDate));
    }

    public int getBalance() {
        int totalCharges = 0;
        for (AccountRecord charge : charges){
            totalCharges += charge.getCharge();
        }
        return totalCharges;
    }

    public List<AccountRecord> getCharges() {
        return charges;
    }

    @Override
    public String toString() {
        //update this
        return "Customer ID: " +  id + " -- Name: " + name + " -- Balance: " + getBalance();
    }
}
