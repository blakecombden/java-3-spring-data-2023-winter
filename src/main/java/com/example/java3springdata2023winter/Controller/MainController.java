package com.example.java3springdata2023winter.Controller;

import com.example.java3springdata2023winter.DataAccess.HomeRepository;
import com.example.java3springdata2023winter.POJOS.Home;
import com.example.java3springdata2023winter.User;
import com.example.java3springdata2023winter.DataAccess.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Optional;

@Controller //This means that this class is a Controller
@RequestMapping(path=RESTNouns.VERSION_1) //This means URL's start with /v1 (after Application path)
public class MainController {


    //Wire the ORM
    @Autowired private UserRepository userRepository;
    @Autowired private HomeRepository homeRepository;

    /**
     * Get Mapping for Home
     * @return all homes
     */
    @GetMapping(path=RESTNouns.USER)
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    /**
     * Get Mapping for User based on ID
     * @param userId user id
     * @return user object
     */
    @GetMapping(path = RESTNouns.USER + "/{user_id}")
    public @ResponseBody Optional<User> getUserWithId(@PathVariable(name = "user_id") Integer userId){
        return userRepository.findById(userId);
    }

    /**
     * Post Mapping for User
     * @param name name of user
     * @param email email of user
     * @return message stating success / failure
     */
    @PostMapping(path=RESTNouns.USER)
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return "Saved"; //TODO Send a better message
    }

    /**
     * Put Mapping for User based on ID
     * @param userId user id
     * @param name name update
     * @param email email update
     * @return message stating success / failure
     */
    @PutMapping (path=RESTNouns.USER + "/{user_id}")
    public @ResponseBody String updateUser(@PathVariable(name = "user_id")  Integer userId, @RequestParam String name, @RequestParam String email){
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            user.get().setName(name);
            user.get().setEmail(email);
            userRepository.save(user.get());
            return "Updated";
        }
        return "User not found";
    }

    /**
     * Delete Mapping for User based on ID
     * @param userId user id
     * @return message stating success / failure
     */
    @DeleteMapping (path=RESTNouns.USER + "/{user_id}")
    public @ResponseBody String deleteUser(@PathVariable(name = "user_id")  Integer userId){
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            userRepository.delete(user.get());
            return "Deleted";
        }
        return "User not found";
    }

    //HOME REST

    /**
     * Get Mapping for Home
     * @return all homes
     */
    @GetMapping(path=RESTNouns.USER + RESTNouns.HOME)
    public @ResponseBody Iterable<Home> getAllHomes(){
        return homeRepository.findAll();
    }

    /**
     * Get Mapping for Home based on ID
     * @param userId user id
     * @return home object
     */
    @GetMapping(path=RESTNouns.USER + "/{user_id}" + RESTNouns.HOME)
    public @ResponseBody Iterable<Home> getAllHomesByUser(@PathVariable(name = "user_id") Integer userId){
        Optional<User> user = userRepository.findById(userId);
        Iterable<Home> homes = new LinkedList<>();

        if(user.isPresent()){
            homes = homeRepository.getAllByUserId(user.get().getId());
        }

        return homes;
    }

    /**
     * Post Mapping for Home
     * @param userId user id
     * @param dateBuilt date built
     * @param value value
     * @param heatingType heating type
     * @return
     */
    @PostMapping(path=RESTNouns.USER + "/{user_id}" + RESTNouns.HOME)
    public @ResponseBody String addNewHome(@PathVariable(name = "user_id") Integer userId,
                                           @RequestParam LocalDate dateBuilt, @RequestParam int value,
                                           @RequestParam("heatingtype") String heatingType){
        Home home = new Home();
        home.setYearBuilt(dateBuilt);
        home.setValue(value);
        home.setHeatingType(Home.HeatingType.valueOf(heatingType));

        //TODO Manage urban / rural enumeration like heating type
        home.setLocation(Home.Location.RURAL);

        //Scope the customer
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            home.setUser(user.get());   //Link it to the user
            homeRepository.save(home);
            return "Saved"; //TODO Send a better message
        } else {
            return "Failed to find user";
        }
    }

    //TODO Simplify this to Home ID, which is unqiue
    /**
     * Put Mapping for Home
     * @param userId home id
     * @param dateBuilt date built
     * @param value value
     * @param heatingType heating type
     * @return message stating success / failure
     */
    @PutMapping (path=RESTNouns.USER + "/{user_id}" + RESTNouns.HOME + "/{home_id}" )
    public @ResponseBody String updateHome(@PathVariable(name = "user_id")  Integer userId,
                                           @PathVariable(name = "home_id")  Integer homeId,
                                           @RequestParam LocalDate dateBuilt, @RequestParam int value,
                                           @RequestParam("heatingtype") String heatingType){
        Optional<Home> home = homeRepository.findById(homeId);

        if(home.isPresent()){
            home.get().setYearBuilt(dateBuilt);
            home.get().setValue(value);
            home.get().setHeatingType(Home.HeatingType.valueOf(heatingType));
            homeRepository.save(home.get());
            return "Updated";
        }
        return "Home not found";
    }

    //TODO HOME - DELETE

    //Hint: Quote REST
    /*
    To get a new Quote, send a GET request, with User ID and the Home ID as a parameter.
    Build the Quote object from the Quote manager
     */

}
