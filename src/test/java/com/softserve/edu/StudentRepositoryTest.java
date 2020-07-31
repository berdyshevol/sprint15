package com.softserve.edu;

import com.softserve.edu.entity.Role;
import com.softserve.edu.entity.User;
import com.softserve.edu.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

@DataJpaTest
public class StudentRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void newUserTest(){
        User user = new User();
        user.setRole(Role.STUDENT);
        user.setEmail("newUser@email.com");
        user.setFirstname("firstName");
        user.setLastname("lastName");
        user.setPassword("pass");

        userRepository.save(user);
        User actual = userRepository.findUserByEmail("newUser@email.com");

        Assertions.assertEquals("firstName", actual.getFirstname());
    }

    @Test
    public void findByRoleTest() {
        List<User> userList1 = userRepository.findByRole("STUDENT");
        Assertions.assertTrue(userList1.size() == 3);

        List<User> userList2 = userRepository.findByRole("MANAGER");
        Assertions.assertTrue(userList2.size() == 1);
    }

}
