package Kenneth.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.ModelResultMatchers;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/3/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc //mockMvc 提供servlet的环境
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void index() throws Exception {


    }

    @Test
    public void createPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/posts/createPage"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}