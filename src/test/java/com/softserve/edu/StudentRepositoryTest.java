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
    public void deleteUserTest() {
        String email1 = "petro@gmail.com";
        User user = userRepository.findUserByEmail(email1);
        Assertions.assertEquals("Petro", user.getFirstname());
        Long size = userRepository.count();

        userRepository.delete(user);
        Assertions.assertEquals(userRepository.count() - size, -1);
    }

    @Test
    public void deleteAllUserTest() {
        userRepository.deleteAll();
        Assertions.assertEquals(userRepository.count(), 0);
    }

    @Test
    public void updateUserTest() {
        String newEmail = "newEmail.com";

        String email1 = "petro@gmail.com";
        User user = userRepository.findUserByEmail(email1);
        Assertions.assertEquals("Petro", user.getFirstname());

        user.setEmail(newEmail);
        userRepository.save(user);
        User usersActual = userRepository.findUserByEmail(newEmail);
        Assertions.assertEquals("Petro", user.getFirstname());
    }

    @Test
    public void findByRoleTest() {
        List<User> userList1 = userRepository.findByRole("STUDENT");
        Assertions.assertTrue(userList1.size() == 3);

        List<User> userList2 = userRepository.findByRole("MANAGER");
        Assertions.assertTrue(userList2.size() == 1);
    }

    @Test
    public void findByEmailTest() {
        String email1 = "petro@gmail.com";
        User user = userRepository.findUserByEmail(email1);
        Assertions.assertEquals("Petro", user.getFirstname());

        String email2 = "pero@gmail.com";
        User user2 = userRepository.findUserByEmail(email2);
        Assertions.assertNull(user2);
    }

}
