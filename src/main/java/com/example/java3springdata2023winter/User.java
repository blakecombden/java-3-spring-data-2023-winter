package com.example.java3springdata2023winter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * User Entity model. This object will be used by Hibernate to create a table in the database
 *
 * Data Access Object
 *
 * @author Josh
 */
@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;
    //TODO Add date of birth for Driving purposes - model the home year built

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
