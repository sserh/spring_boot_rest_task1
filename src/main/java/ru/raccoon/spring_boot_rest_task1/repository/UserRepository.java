package ru.raccoon.spring_boot_rest_task1.repository;

import org.springframework.stereotype.Repository;
import ru.raccoon.spring_boot_rest_task1.SpringBootRestTask1Application;
import ru.raccoon.spring_boot_rest_task1.model.User;

import java.util.List;

@Repository
public class UserRepository {

    public List<Authorities> getUserAuthorities(String user, String password) {

        for (User person : SpringBootRestTask1Application.personList) {
            if ((person.getUser().equals(user)) && (person.getPassword().equals(password))) {
                return person.getPermissionsList();
            }
        }
        return null;
    }
}