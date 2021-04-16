package com.techelevator.crm;

import com.techelevator.Billable;
import com.techelevator.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Customer extends Person implements Billable {

    private String phoneNumber;
    private List<String> pets = new ArrayList<>();

    //getters and setters

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<String> getPets() {
        return this.pets;
    }

    public void setPets(List<String> pets) {
        this.pets = pets;
    }

    //constructors

    public Customer (String firstName, String lastName, String phoneNumber){
        super(firstName, lastName);
        this.phoneNumber = phoneNumber;

    }
    public Customer (String firstname, String lastName) {
        super(firstname, lastName);
        this.phoneNumber = "";

    }

    public double getBalanceDue(Map<String, Double> services) {
        double total = 0;
        for (Map.Entry<String, Double> entry : services.entrySet()) {
            total += entry.getValue();
        }
        return total;
    }
}
