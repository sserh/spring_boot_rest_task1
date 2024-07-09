package ru.raccoon.spring_boot_rest_task1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.raccoon.spring_boot_rest_task1.model.User;
import ru.raccoon.spring_boot_rest_task1.repository.Authorities;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringBootRestTask1Application {

    public static List<User> personList = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestTask1Application.class, args);

        personList.add(new User("user", "password", List.of(Authorities.READ)));
        personList.add(new User("admin", "admin", List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE)));
        personList.add(new User("guest", "guest", List.of()));

    }

}
