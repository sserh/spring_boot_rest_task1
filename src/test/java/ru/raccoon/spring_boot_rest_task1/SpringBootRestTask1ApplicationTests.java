package ru.raccoon.spring_boot_rest_task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import ru.raccoon.spring_boot_rest_task1.repository.Authorities;

import java.util.Arrays;
import java.util.stream.Stream;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringBootRestTask1ApplicationTests {

    private static final GenericContainer<?> devapp = new GenericContainer<>("devapp:1.0")
            .withExposedPorts(8080);
    private static final GenericContainer<?> prodapp = new GenericContainer<>("prodapp:1.0")
            .withExposedPorts(8081);

    String hostname = "localhost";
    String authString = "/authorize?user=admin&password=admin";
    private final String etalonString = "[\"READ\",\"WRITE\",\"DELETE\"]";

    @Autowired
    TestRestTemplate restTemplate;

    @BeforeAll
    public static void setup() {
        devapp.start();
        prodapp.start();
    }

    @Test
    void checkAdminResponseFromDevapp() {
        ResponseEntity<String> forEntityDevApp = restTemplate.getForEntity("http://" + hostname + ":" + devapp.getMappedPort(8080) + authString, String.class);
        Assertions.assertEquals(etalonString, forEntityDevApp.getBody());

    }
    @Test
    void checkAdminResponseFromProdapp() {
        ResponseEntity<String> forEntityProdApp = restTemplate.getForEntity("http://" + hostname + ":" + prodapp.getMappedPort(8081) + authString, String.class);
        Assertions.assertEquals(etalonString, forEntityProdApp.getBody());
    }

}
