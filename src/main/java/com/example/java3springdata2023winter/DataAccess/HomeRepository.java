package com.example.java3springdata2023winter.DataAccess;

import com.example.java3springdata2023winter.POJOS.Home;
import org.springframework.data.repository.CrudRepository;

public interface HomeRepository extends CrudRepository <Home, Integer> {

    //No queries needed beyond what Spring will generate

}
