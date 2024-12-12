package com.example.example3hometask.controllers;

import com.example.example3hometask.domain.User;
import com.example.example3hometask.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired // Spring должен внедрить (inject) указанный bean в качестве зависимости для данного класса или метода.
    private RegistrationService service;   // Сервис регистрации пользователей.

    /**
     * Получение списка пользователей из репозитория.
     *
     * @return JSON ответ со списком пользователей.
     * @GetMapping - для определения HTTP GET запроса, который будет обрабатываться в контроллере.
     */
    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getRepository().getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user){
        service.getDataProcessingService().getRepository().getUsers().add(user);
        return "User added from body!";
    }
}
