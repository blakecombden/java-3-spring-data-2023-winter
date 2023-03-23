package com.example.java3springdata2023winter;

import org.springframework.data.repository.CrudRepository;

/**
 * UserRepository for linking User object to the database.
 * This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
 * CRUD refers Create, Read, Update, Delete
 */
public interface UserRepository extends CrudRepository<User, Integer> {

    //There is nothing in here. Hibernate handles all the CRUD
    //IF you needed a very special or different query, you would write it here.
    //See docs before attempting anything like that.

}
