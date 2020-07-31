package com.softserve.edu.controller;


import com.softserve.edu.entity.Role;
import com.softserve.edu.service.MarathonService;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/marathons")
public class MarathonController {
    Logger logger = LoggerFactory.getLogger(StudentController.class);
    private final MarathonService marathonService;

    public MarathonController(MarathonService marathonService) {
        this.marathonService = marathonService;
    }

    @GetMapping
    public String getAllMarathons(Model model) {
        logger.info("Get all marathons");
        model.addAttribute("marathons", marathonService.findAll());
        return "marathones";
    }

    //TODO implement other needed methods
}
