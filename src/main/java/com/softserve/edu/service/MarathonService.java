package com.softserve.edu.service;

import com.softserve.edu.entity.Marathon;

import java.util.List;

public interface MarathonService {
    Marathon findById(Integer id);

    void save(Marathon marathon);

    List<Marathon> findAll();

    //TODO other needed methods
}
