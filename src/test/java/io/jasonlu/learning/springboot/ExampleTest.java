package io.jasonlu.learning.springboot;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * Created by jiehenglu on 17/07/17.
 */
@RunWith(SpringRunner.class)
// Mock表示使用模拟的应用服务器，默认值就是这个
@SpringBootTest(classes = Example.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class ExampleTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testContext() {
        assertNotNull(context);
    }

    @Test
    public void testHello() throws Exception {
        mockMvc.perform(get("/demo")
            .param("key1", "value1")
        ).andExpect(content().string("Hello value1 !"));
    }
}
