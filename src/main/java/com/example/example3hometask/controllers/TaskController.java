package com.example.example3hometask.controllers;

import com.example.example3hometask.domain.User;
import com.example.example3hometask.services.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
/**
 * Класс, работающий с базой данных
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private DataProcessingService service;

    @GetMapping
    public List<String> getTasks(){
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    /**
     * Список пользователей, которые отсортированы по возрасту
     * @return список пользователей
     */
    @GetMapping("/sort")
    public List<User> sortUsersByAge()
    {
        return service.sortUsersByAge(service.getRepository().getUsers());
    }

    /**
     * Фильтрация по возрасту
     * @param age возраст
     * @return список, соответствующих запросу пользователей
     */
    @GetMapping("/filter/{age}")
    public List<User>filterUsersByAge(@PathVariable("age") int age){
        return service.filterUsersByAge(service.getRepository().getUsers(), age);
    }

    /**
     * Средний возраст пользователей
     * @return Средний возраст пользователей
     */
    @GetMapping("/calc")
    public double calculateAverageAge(){
        return service.calculateAverageAge(service.getRepository().getUsers());
    }
}
