package ru.raccoon.spring_boot_rest_task1.model;

import ru.raccoon.spring_boot_rest_task1.repository.Authorities;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String user;
    private final String password;
    private final List<Authorities> permissionsList = new ArrayList<>();

    public User(String personName, String personPassword, List<Authorities> permissionsList) {
        this.user = personName;
        this.password = personPassword;
        this.permissionsList.addAll(permissionsList);
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public List<Authorities> getPermissionsList() {
        return permissionsList;
    }
}
