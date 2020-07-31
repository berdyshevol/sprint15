package com.softserve.edu.controller;

import com.softserve.edu.entity.Marathon;
import com.softserve.edu.entity.Role;
import com.softserve.edu.entity.User;
import com.softserve.edu.service.MarathonService;
import com.softserve.edu.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/students")
public class StudentController {
    Logger logger = LoggerFactory.getLogger(StudentController.class);

    private final UserService userService;
    private final MarathonService marathonService;

    public StudentController(UserService userService, MarathonService marathonService) {
        this.userService = userService;
        this.marathonService = marathonService;
    }

    @GetMapping
    String getAllStudents(Model model) {
        logger.info("Get all students");
        model.addAttribute("students", userService.findByRole(Role.STUDENT));
        return "students";
    }

    @GetMapping("/add")
    String gotoStudent(Model model) {
        model.addAttribute("student", new User());
        return "student";
    }

    @PostMapping("/add")
    String addStudent(@ModelAttribute User student) {
        student.setRole(Role.STUDENT);
        userService.save(student);
        return "redirect:";
    }

    @GetMapping("/edit/{id}")
    String edit(@PathVariable Integer id, Model model) {
        User student = userService.findById(id);
        model.addAttribute("student", student);
        return "student_edit";
    }

    @PostMapping("/edit/{id}")
    String editStudent(@ModelAttribute User editedStudent, @PathVariable Integer id) {
        User student = userService.findById(id);
        student.setEmail(editedStudent.getEmail());
        student.setFirstname(editedStudent.getFirstname());
        student.setLastname(editedStudent.getLastname());
        userService.save(student);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    String removeStudent(@PathVariable Integer id) {
        userService.removeStudent(userService.findById(id));
        return "redirect:";
    }

    @GetMapping("/{id}")
    String addToMarathon(@PathVariable Integer id, Model model) {
        Marathon marathon = marathonService.findById(id);
        model.addAttribute("marathon", marathon);
        model.addAttribute("students", userService.findByRole(Role.STUDENT));
        return "add_to_marathon";
    }

    @GetMapping("/{m_id}/add/{s_id}")
    String addStudentToMarathon(@PathVariable("m_id") Integer marathonId, @PathVariable("s_id") Integer studentId, Model model) {
        userService.addToMarathon(studentId, marathonId);
        model.addAttribute("id", marathonId);
        return "redirect:/students";
    }
    //TODO implement needed methods

}
