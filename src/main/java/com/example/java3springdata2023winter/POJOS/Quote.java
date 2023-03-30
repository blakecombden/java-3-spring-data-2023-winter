package com.example.java3springdata2023winter.POJOS;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * The quote class for Taylor's insurance. This is a base class that should be extended by home and auto quotes.
 * Quotes are offers that have a time period and can be accepted. You should give flexibility to quotes that you
 * don't necessarily give to policies. For example - you may allow a quote to be modified but you would not modify
 * a policy after it is bound as a legal contract.
 *
 * @author Josh
 */
public abstract class Quote {

    //TODO this class is ideal for a Builder Pattern
    private LocalDate startDate;
    private LocalDate endDate;      //TODO use this or just keep it to 1 year after start?
    private BigDecimal premiumBeforeTax;
    private BigDecimal premiumAfterTax;

    //TODO Remove this and use a builder?
    public Quote(LocalDate startDate, LocalDate endDate, BigDecimal premium) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.premiumBeforeTax = premium;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    //TODO update to PremiumBeforeTax
    public BigDecimal getPremiumBeforeTax() {
        return premiumBeforeTax;
    }

    //public BigDecimal getTaxTotal()

}
