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

import java.util.List;
import java.util.Optional;

@DataJpaTest
public class MarathonRepositoryTest {
    @Autowired
    private MarathonRepository marathonRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void newMarathonTest() {
        String newMarathonName = "test marathon";
        Marathon marathon = new Marathon();
        marathon.setName(newMarathonName);
        int size = marathonRepository.findAll().size();

        marathonRepository.save(marathon);
        int newSize = marathonRepository.findAll().size();

        Assertions.assertEquals(newSize - size, 1);

        Assertions.assertTrue(
                marathonRepository.findAll().stream().anyMatch(
                        m -> m.getName().equals(newMarathonName)
                )
        );
    }

    @Test
    public void sizeTest() {
        List<Marathon> marathons = marathonRepository.findAll();
        Assertions.assertTrue(marathons.size() == 2);
    }

    @Test
    public void findAllTest() {
        String marathonName1 = "Java Online Marathons";
        String marathonName2 = "Python Online Marathons";
        List<Marathon> marathons = marathonRepository.findAll();
        Assertions.assertTrue(marathons.size() == 2);

        Assertions.assertTrue(marathons.stream().anyMatch(m -> m.getName().equals(marathonName1)));
        Assertions.assertTrue(marathons.stream().anyMatch(m -> m.getName().equals(marathonName2)));
    }

    @Test
    public void findByIdTest() {
        Optional<Marathon> marathon = marathonRepository.findById(100000);
        Assertions.assertFalse(marathon.isPresent());

        Optional<Marathon> marathon1 = marathonRepository.findById(1);
        Assertions.assertTrue(marathon1.isPresent());

        Optional<Marathon> marathon2 = marathonRepository.findById(2);
        Assertions.assertTrue(marathon2.isPresent());
    }

    @Test
    public void deleteTest() {
        long size = marathonRepository.count();
        Optional<Marathon> marathon1 = marathonRepository.findById(1);
        Assertions.assertTrue(marathon1.isPresent());

        marathonRepository.delete(marathon1.get());
        Long newSize = marathonRepository.count();

        Assertions.assertEquals(newSize - size, -1);
    }

    @Test
    public void deleteAllTest() {
        marathonRepository.deleteAll();
        Assertions.assertEquals(marathonRepository.findAll().size(),0);
    }
}
