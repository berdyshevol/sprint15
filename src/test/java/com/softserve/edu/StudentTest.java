package com.softserve.edu;

import com.softserve.edu.entity.Marathon;
import com.softserve.edu.entity.Role;
import com.softserve.edu.entity.User;
import com.softserve.edu.repository.MarathonRepository;
import com.softserve.edu.service.MarathonService;
import com.softserve.edu.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class StudentTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    @Autowired
    private MarathonService marathonService;

    @Autowired
    private MarathonRepository marathonRepository;

    @Test
    public void getAllStudentsTest() throws Exception {
        List<User> expected = userService.findByRole(Role.STUDENT);

        mockMvc.perform(MockMvcRequestBuilders.get("/students"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("students"))
                .andExpect(MockMvcResultMatchers.model().attribute("students", expected));
    }

    @Test
    public void testAddStudent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/students/add")
                .param("email", "test@email.com")
                .param("firstname", "fName")
                .param("lastname", "lName"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection());
    }

    @Test
    public void testEdit() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/students/edit/1")
                .param("email", "test@email.com")
                .param("firstname", "fName")
                .param("lastname", "lName"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection());
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/students/delete/1"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection());
    }

//    @Test
//    public void testStudentsListOfMarathon() throws Exception {
//        Marathon marathonE = marathonService.findById(1);
//        List<User> userE = userService.findByRole(Role.STUDENT);
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/students/1"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.model().attributeExists("marathon"))
//                .andExpect(MockMvcResultMatchers.model().attribute("marathon", marathonE))
//                .andExpect(MockMvcResultMatchers.model().attributeExists("students"))
//                .andExpect(MockMvcResultMatchers.model().attribute("students", userE))
//                ;
//    }

//    @Test
//    public void testAddToMarathon() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/students/1/add/1"))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
}
