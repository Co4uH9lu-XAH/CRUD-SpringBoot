package ru.kunin.CRUDSpringBoot.service;


import ru.kunin.CRUDSpringBoot.models.User;

import java.util.List;

public interface UserService {

    void addUser(User user);
    void updateUser(int id, User user);
    void removeUser(int id);
    List<User> getAllUsers();
    User getUser (int id);
}
