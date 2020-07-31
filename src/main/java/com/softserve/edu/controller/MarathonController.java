package com.softserve.edu.controller;


import com.softserve.edu.entity.Role;
import com.softserve.edu.service.MarathonService;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/marathons")
public class MarathonController {
    private final MarathonService marathonService;

    public MarathonController(MarathonService marathonService) {
        this.marathonService = marathonService;
    }

    @GetMapping
    public String getAllMarathons(Model model) {
        model.addAttribute("marathons", marathonService.findAll());
        return "marathones";
    }

    //TODO implement other needed methods
}
