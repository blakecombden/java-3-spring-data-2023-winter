package com.example.java3springdata2023winter.POJOS;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * ca.nl.cna.Java3.capstonePOJOs.Quote for a ca.nl.cna.Java3.capstonePOJOs.Home by Taylors insurance
 *
 * @author Josh
 */
public class HomeQuote extends Quote {

    private Home home;

    public HomeQuote(LocalDate startDate, LocalDate endDate, BigDecimal premium, Home home) {
        super(startDate, endDate, premium);
        this.home = home;
    }

    public Home getHome() {
        return home;
    }

}
