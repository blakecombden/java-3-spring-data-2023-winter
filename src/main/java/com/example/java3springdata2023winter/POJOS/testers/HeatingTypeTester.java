package com.example.java3springdata2023winter.POJOS.testers;

import com.example.java3springdata2023winter.POJOS.Home;

import java.sql.SQLOutput;

public class HeatingTypeTester {

    public static void main(String[] args) {
        System.out.println("Testing an enumeration");

        Home.HeatingType heatingType;

        heatingType = Home.HeatingType.OIL_HEATING;
        System.out.printf("\nOIL_HEATING: %s", heatingType.name());

        heatingType = Home.HeatingType.OTHER_HEATING;
        System.out.printf("\nOTHER_HEATING: %s", heatingType.name());

        heatingType = Home.HeatingType.WOOD_HEATING;
        System.out.printf("\nWOOD_HEATING: %s", heatingType.name());


    }

}
