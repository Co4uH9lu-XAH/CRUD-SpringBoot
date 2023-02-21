package ru.kunin.CRUDSpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.kunin.CRUDSpringBoot.dao.UserDAO;
import ru.kunin.CRUDSpringBoot.models.User;


import java.util.List;

@Component
public class UserServiceImp implements UserService{

    private final UserDAO userDao;

    @Autowired
    public UserServiceImp(UserDAO userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    @Transactional
    public void updateUser(int id, User user) {
        userDao.updateUser(id, user);
    }

    @Override
    @Transactional
    public void removeUser(int id) {
        userDao.removeUser(id);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public User getUser(int id) {
        return userDao.getUser(id);
    }
}
