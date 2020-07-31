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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class MarathonTest {
    @Autowired
    private MockMvc mockMvc;

//    @Autowired
//    private UserService userService;

    @Autowired
    private MarathonService marathonService;

    @Autowired
    private MarathonRepository marathonRepository;

    @Test
    public void getAllMarathonsTest() throws Exception {
        List<Marathon> expected =  marathonService.findAll();

        mockMvc.perform(MockMvcRequestBuilders.get("/marathons"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("marathons"))
                .andExpect(MockMvcResultMatchers.model().attribute("marathons", expected))
        ;
    }
}
