package com.example.java3springdata2023winter.Controller;

import com.example.java3springdata2023winter.DataAccess.HomeRepository;
import com.example.java3springdata2023winter.POJOS.Home;
import com.example.java3springdata2023winter.User;
import com.example.java3springdata2023winter.DataAccess.UserRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@Controller //This means that this class is a Controller
@RequestMapping(path=RESTNouns.VERSION_1) //This means URL's start with /v1 (after Application path)
public class MainController {


    //Wire the ORM
    @Autowired private UserRepository userRepository;
    @Autowired private HomeRepository homeRepository;

    //USER - GET / READ All
    @GetMapping(path=RESTNouns.USER)
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    //USER - GET / READ ONE by ID
    @GetMapping(path = RESTNouns.USER + "/{id}")
    public @ResponseBody Optional<User> getUserWithId(@PathVariable Integer id){
        return userRepository.findById(id);
    }

    //USER - POST / CREATE ONE
    @PostMapping(path=RESTNouns.USER)
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return "Saved"; //TODO Send a better message
    }

    //TODO USER PUT Update
    //TODO USER DELETE

    //HOME REST

    //HOME - GET / READ All (DEBUG Only)
    @GetMapping(path=RESTNouns.USER + RESTNouns.HOME)
    public @ResponseBody Iterable<Home> getAllHomes(){
        return homeRepository.findAll();
    }

    //TODO HOME - GET / READ ONE by ID

//ECHO Home info to build out the commponents
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO) private Integer id;
//    @JsonFormat(pattern="yyyy-MM-dd")  private LocalDate yearBuilt;
//    private int value;
//    @Enumerated(EnumType.ORDINAL) private Home.HeatingType heatingType;
//    @Enumerated(EnumType.ORDINAL) private Home.Location location;

    //HOME - POST / CREATE ONE
    @PostMapping(path=RESTNouns.USER + RESTNouns.USER_ID + RESTNouns.HOME)
    public @ResponseBody String addNewHome(@PathVariable Integer id,
                                           @RequestParam LocalDate dateBuilt, @RequestParam int value,
                                           @RequestParam("heatingtype") String heatingType){
        Home home = new Home();
        home.setYearBuilt(dateBuilt);
        home.setValue(value);
        home.setHeatingType(Home.HeatingType.valueOf(heatingType));

        //TODO Manage urban / rural enumeration like heating type
        home.setLocation(Home.Location.RURAL);

        //Scope the customer
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            home.setUser(user.get());   //Link it to the user
            homeRepository.save(home);
            return "Saved"; //TODO Send a better message
        } else {
            return "Failed to find user";
        }
    }

    //TODO HOME - PUT Update
    //TODO HOME - DELETE

    //Quote REST
    /*
    To get a new Quote, send a GET request, with User ID and the Home ID as a parameter.
    Build the Quote object from the Quote manager
     */

}
