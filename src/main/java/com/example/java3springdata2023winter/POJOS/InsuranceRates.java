package com.example.java3springdata2023winter.POJOS;

/**
 * An interface for insurance rates. This allows for rates to be abstracted to web service.
 * This is a single set of rates for both home and auto. This is common industry practice as
 * actuaries tend to package rates together.
 *
 * Note: all premiums are annual
 *
 * @author Josh
 */
public interface InsuranceRates {

    /**
     * Get the base annual premium for a home ca.nl.cna.Java3.capstonePOJOs.Quote
     * @return base premium
     */
    public double getHomeBasePremium();

    /**
     * Get the rating factor for heating type
     * @return heating type factor
     */
    public double getHeatingTypeFactor(Home.HeatingType heatingType);

    /**
     * Get the rating factor for location
     * @param location home location
     * @return
     */
    public double getLocationFactor(Home.Location location);

    /**
     * Get the rating factor based on home age - years since construction
     * @param yearsOld Years since construction
     * @return
     */
    public double getAgeFactor(int yearsOld);


    //TODO Add auto methods

    //TODO How to handle tax?
}
