package com.giusescara.tutorial.springbootcrud.web;

import com.giusescara.tutorial.springbootcrud.SpringBootCrudApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest(classes = SpringBootCrudApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTestEmployeeController {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @Sql({"classpath:/schema.sql", "classpath:/data.sql"})
    public void testGetAllEmployees() {
        String url = "http://localhost:" + port + "/employees";

        List response = this.restTemplate.getForObject(url, List.class);

        Assert.isTrue(response != null, "The response of employees list is not null");
        Assert.notEmpty(response, "The employees list is not empty.");
        Assert.isTrue(response.size() == 3, "There is 3 employees inside the employees list.");
        Assert.noNullElements(response, "All employees are defined");
    }


}
