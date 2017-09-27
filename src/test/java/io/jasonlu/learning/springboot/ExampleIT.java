package io.jasonlu.learning.springboot;

import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertThat;

/**
 * Created by jiehenglu on 17/07/10.
 */
@RunWith(SpringRunner.class)
// DEFINED_PORT表示使用默认的8080端口启动内嵌的应用服务器
@SpringBootTest(classes = {Example.class}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ExampleIT {

    @Test
    public void testHello() {
        RestTemplate rest = new RestTemplate();
        Map<String, String> params = new HashMap<>();
        params.put("key1", "value1");
        ResponseEntity<String> result = rest.getForEntity("http://localhost:8080/demo?key1={key1}", String.class, params);
        assertThat(result.getStatusCode(), Is.is(HttpStatus.OK));
        assertThat(result.getBody(), Is.is("Hello value1 !"));
    }

}
