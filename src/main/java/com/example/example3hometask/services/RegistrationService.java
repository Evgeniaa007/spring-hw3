package com.example.example3hometask.services;

import com.example.example3hometask.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Регистрация новых пользователей
 */
@Service
public class RegistrationService{

    private NotificationService notificationService;
    private UserService userService;
    private DataProcessingService dataProcessingService;

    public RegistrationService(NotificationService notificationService, UserService userService, DataProcessingService dataProcessingService) {
        this.notificationService = notificationService;
        this.userService = userService;
        this.dataProcessingService = dataProcessingService;
    }

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    /**
     * метод добавления пользователя в базу данных
     */
    public void processRegistration(String name, int age, String email){
        User newUser = userService.createUser(name, age, email);
        dataProcessingService.addUserToList(newUser);
        notificationService.notifyUser(newUser);
    }
}
