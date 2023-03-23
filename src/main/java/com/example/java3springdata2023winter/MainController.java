package com.example.java3springdata2023winter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller //This means that this class is a Controller
@RequestMapping(path="/v1") //This means URL's start with /v1 (after Application path)
public class MainController {

    public static final String USER = "/users";

    @Autowired //Connect this to the UserRepository
    private UserRepository userRepository;

    //READ All
    @GetMapping(path=USER)
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    //READ ONE by ID
    @GetMapping(path = USER + "/{id}")
    public @ResponseBody Optional<User> getUserWithId(@PathVariable Integer id){
        return userRepository.findById(id);
    }

    //CREATE ONE
    @PostMapping(path=USER)
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return "Saved"; //TODO Send a better message
    }


}
