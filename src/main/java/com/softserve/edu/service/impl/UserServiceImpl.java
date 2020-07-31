package com.softserve.edu.service.impl;

import com.softserve.edu.entity.Marathon;
import com.softserve.edu.entity.Role;
import com.softserve.edu.entity.User;
import com.softserve.edu.repository.MarathonRepository;
import com.softserve.edu.repository.UserRepository;
import com.softserve.edu.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Data
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
@Transactional
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private MarathonRepository marathonRepository;

    public User findById(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> findByRole(Role role) {
        return userRepository.findByRole(role);
    }

    @Override
    public List<User> findByRole(String role) {
        return userRepository.findByRole(role);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void removeStudent(User byId) {
        //TODO
    }

    @Override
    public void addToMarathon(Integer studentId, Integer marathonId) {
        User user = userRepository.findById(studentId).get();
        Marathon marathon = marathonRepository.findById(marathonId).get();
//        user.getMarathons().add(marathon);
        userRepository.save(user);
    }

    //TODO other needed methods

}
