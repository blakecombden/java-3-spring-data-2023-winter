package com.example.java3springdata2023winter.POJOS;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Generates quotes
 *
 * @author Josh
 */
public class QuoteManager {

    //TODO Is this strict to the Builder Pattern for Quotes? Rename Builder?

    /**
     * Get a new home quote
     * @param home
     * @return
     */
    public static HomeQuote getNewHomeQuote(Home home){
        return new HomeQuote(LocalDate.now(), LocalDate.now().plusDays(30), getHomeQuotePremium(home), home);
    }

    /**
     * Get a home quote premium
     * @param home
     * @return
     */
    private static BigDecimal getHomeQuotePremium(Home home){
        //TODO This should be a factory!
        InsuranceRates insuranceRates = new HardCodedRates();

        BigDecimal bigDecimal = new BigDecimal(insuranceRates.getHomeBasePremium());
        bigDecimal = bigDecimal.multiply(BigDecimal.valueOf(insuranceRates.getHeatingTypeFactor(home.getHeatingType())));
        bigDecimal = bigDecimal.multiply(BigDecimal.valueOf(insuranceRates.getLocationFactor(home.getLocation())));
        bigDecimal = bigDecimal.multiply(BigDecimal.valueOf(insuranceRates.getAgeFactor(home.getAge())));
        return  bigDecimal;
    }

}
