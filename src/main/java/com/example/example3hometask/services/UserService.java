package com.example.example3hometask.services;

import com.example.example3hometask.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Создание пользователей
 */
@Service
public class UserService {

    @Autowired
    private NotificationService notificationService;

//    public UserService(NotificationService notificationService){
//        this.notificationService = notificationService;
//    }

    public User createUser(String name, int age, String email) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);
        notificationService.notifyUser(user);

        return user;
    }

}
