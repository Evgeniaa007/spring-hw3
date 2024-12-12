package com.example.example3hometask.services;

import com.example.example3hometask.domain.User;
import org.springframework.stereotype.Service;

/**
 * Консольные уведомления
 */
@Service
public class NotificationService {

    /**
     * Уведомление о создании нового пользователя.
     * @param user объект пользователя.
     */
    public void notifyUser(User user) {
        System.out.println("A new user has been created: " + user.getName());
    }

}
