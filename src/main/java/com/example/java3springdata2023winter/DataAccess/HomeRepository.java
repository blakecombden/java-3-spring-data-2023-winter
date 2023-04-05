package com.example.java3springdata2023winter.DataAccess;

import com.example.java3springdata2023winter.POJOS.Home;
import org.springframework.data.repository.CrudRepository;

public interface HomeRepository extends CrudRepository <Home, Integer> {

    /**
     * Get all homes for a user
     * @param userId
     * @return
     */
    Iterable<Home> getAllByUserId(Integer userId);

    //Note: I am surprised this works! Spring detects it and fills in the method. Crazy.
    //If this didn't work I would have retrieved all the homes and looped through and gramed the homes that
    //matched the user id.

}
