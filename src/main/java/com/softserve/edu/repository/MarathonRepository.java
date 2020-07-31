package com.softserve.edu.repository;

import com.softserve.edu.entity.Marathon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarathonRepository extends JpaRepository<Marathon, Integer> {
    List<Marathon> findAll();
    //TODO declare other needed methods
}
