package com.example.przyklad.repository;

import com.example.przyklad.component.User;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User>users = new LinkedList<>();

    public List<User> getUsers() {
        return users;
    }

    public UserRepository() {
        users.add(new User("Jan","Kowal",87));
        users.add(new User("Janina","Kowalska",78));
        users.add(new User("Janek","Kowalek",13));
    }

    }
