package com.softserve.edu.repository;

import com.softserve.edu.entity.Role;
import com.softserve.edu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select * from Users u where u.role = ?1", nativeQuery = true)
    List<User> findByRole(String role);

    List<User> findByRole(Role role);

    User findUserByEmail(String email);

    //TODO declare other needed methods
}
