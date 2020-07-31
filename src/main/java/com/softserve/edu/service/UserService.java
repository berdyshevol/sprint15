package com.softserve.edu.service;

import com.softserve.edu.entity.Role;
import com.softserve.edu.entity.User;

import java.util.List;

public interface UserService {

    User findById(Integer id);

    List<User> findByRole(Role role);
    List<User> findByRole(String role);

    User save(User entity);

    void removeStudent(User byId);

    void addToMarathon(Integer studentId, Integer marathonId);

    //TODO other needed methods

}
