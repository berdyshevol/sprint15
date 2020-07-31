package com.softserve.edu;

import com.softserve.edu.entity.Marathon;
import com.softserve.edu.repository.MarathonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

@DataJpaTest
public class MarathonRepositoryTest {
    Logger logger = LoggerFactory.getLogger(MarathonRepositoryTest.class);
    @Autowired
    private MarathonRepository marathonRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void newMarathonTest() {
        Marathon marathon = new Marathon();
        marathon.setName("test marathon");
        int size = marathonRepository.findAll().size();

        marathonRepository.save(marathon);
        int newSize = marathonRepository.findAll().size();

        Assertions.assertTrue(newSize - size == 1);
    }
}
