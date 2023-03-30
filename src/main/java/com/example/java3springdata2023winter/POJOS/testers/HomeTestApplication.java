package com.example.java3springdata2023winter.POJOS.testers;

import com.example.java3springdata2023winter.POJOS.Customer;
import com.example.java3springdata2023winter.POJOS.Home;
import com.example.java3springdata2023winter.POJOS.HomeQuote;
import com.example.java3springdata2023winter.POJOS.QuoteManager;

import java.time.LocalDate;
import java.util.Random;

/**
 * Playing around with the home class
 */
public class HomeTestApplication {

    public static void main(String[] args) {
        System.out.println("ca.nl.cna.Java3.capstonePOJOs.Home application testing");
        Home home = getTestHome();
        printHomeInfo(home);
        HomeQuote homeQuote = QuoteManager.getNewHomeQuote(home);
        System.out.printf("\nPremium: %d", homeQuote.getPremiumBeforeTax().intValue());
    }

    public static Customer getTestCustomer(){
        //TODO Randomize this? Add in edge cases
        return new Customer("Josh", "Taylor", LocalDate.of(1990,10,1));
    }

    public static Home getTestHome(){
        //TODO Randomize this? Add in edge cases
        Random random = new Random();
        int i = Math.abs(random.nextInt());
        System.out.printf("\n>%d", i % 3);
        if(i % 3 == 0){
            Home home = new Home();
            home.setYearBuilt(LocalDate.of(2005,1,1));
            home.setValue(400000);
            home.setHeatingType(Home.HeatingType.OIL_HEATING);
            home.setLocation(Home.Location.RURAL);
            return home;
        } else if(i % 3 == 1){
            Home home = new Home();
            home.setYearBuilt(LocalDate.of(1905,1,1));
            home.setValue(600000);
            home.setHeatingType(Home.HeatingType.WOOD_HEATING);
            home.setLocation(Home.Location.URBAN);
            return home;
        } else {
            Home home = new Home();
            home.setYearBuilt(LocalDate.of(1985,1,1));
            home.setValue(400000);
            home.setHeatingType(Home.HeatingType.OTHER_HEATING);
            home.setLocation(Home.Location.URBAN);
            return home;
        }

    }

    public static void printHomeInfo(Home home){
        System.out.printf("\nca.nl.cna.Java3.capstonePOJOs.Home details> Heating: %s, Location: %s, Age: %d", home.getHeatingType().name(), home.getLocation().name(), home.getAge());
    }

}
