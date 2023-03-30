package com.example.java3springdata2023winter.POJOS;

import java.time.LocalDate;

/**
 * The core customer object for Taylor's insurance system
 *
 * All drivers will be customers. There will only be one customer on any insurance policy
 *
 */
public class Customer {

    private String firstName;
    private String lastName;
    LocalDate dateOfBirth;

    //TODO add in Quotes / Policies


    //TODO Replace this with a builder object?
    //TODO where to store user / pass / contact details
    public Customer(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
