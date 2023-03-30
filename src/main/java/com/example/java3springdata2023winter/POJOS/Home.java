package com.example.java3springdata2023winter.POJOS;

import com.example.java3springdata2023winter.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

/**
 * ca.nl.cna.Java3.capstonePOJOs.Home object for Taylors insurance. Includes enum's for Heating Type and Location which will be used in rating
 *
 * @author Josh
 */
@Entity(name = "home")
public class Home {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) private Integer id;
    @JsonFormat(pattern="yyyy-MM-dd")  private LocalDate yearBuilt;
    private int value;
    @Enumerated(EnumType.ORDINAL) private HeatingType heatingType;
    @Enumerated(EnumType.ORDINAL) private Location location;

    //TODO Update these parameters
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    /**
     * Heating type enum
     * {@link #OIL_HEATING}
     * {@link #WOOD_HEATING}
     * {@link #OTHER_HEATING}
     */
    public enum HeatingType {
        /**
         * Oil Heating
         */
        OIL_HEATING,
        /**
         * Wood Heating
         */
        WOOD_HEATING,
        /**
         * Other Heating
         */
        OTHER_HEATING
    }

    /**
     * Location
     * {@link #URBAN}
     * {@link #RURAL}
     */
    public enum Location {
        /**
         * Urban Location
         */
        URBAN,
        /**
         * Rural Location
         */
        RURAL
    }

    public LocalDate getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(LocalDate yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public HeatingType getHeatingType() {
        return heatingType;
    }

    public void setHeatingType(HeatingType heatingType) {
        this.heatingType = heatingType;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getAge(){
        return Period.between(this.yearBuilt, LocalDate.now()).getYears();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
