package com.softserve.edu.service.impl;

import com.softserve.edu.entity.Marathon;
import com.softserve.edu.repository.MarathonRepository;
import com.softserve.edu.service.MarathonService;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Data
@Transactional
@Service
public class MarathonServiceImpl implements MarathonService {
    private MarathonRepository marathonRepository;

    public MarathonServiceImpl(MarathonRepository marathonRepository) {
        this.marathonRepository = marathonRepository;
    }

    public Marathon findById(Integer id) {
        return marathonRepository.findById(id).get();
    }

    @Override
    public void save(Marathon marathon) {
        marathonRepository.save(marathon);
    }

    @Override
    public List<Marathon> findAll() {
        return marathonRepository.findAll();
    }

    //TODO other needed methods

}
