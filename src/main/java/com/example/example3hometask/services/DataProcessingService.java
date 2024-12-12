package com.example.example3hometask.services;

import com.example.example3hometask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.example3hometask.domain.User;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * DataProcessingService - класс, обеспечивающий работу с хранилищем данных пользователей.
 */
@Service
public class DataProcessingService {
    @Autowired
    private UserRepository repository;

    /**
     * Получение репозитория пользователей.
     * @return объект репозитория.
     */
    public UserRepository getRepository() {
        return repository;
    }

    /**
     * Сортировка пользователей по возрасту.
     * @param users список пользователей.
     * @return отсортированный список пользователей.
     */
    public List<User> sortUsersByAge(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    /**
     * Фильтрация списка пользователей по возрасту.
     * @param users список пользователей.
     * @param age возраст для поиска.
     * @return список содержащий пользователей с заданным возрастом.
     */
    public List<User> filterUsersByAge(List<User> users, int age) {
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    /**
     * Получение среднего возраста пользователей.
     * @param users список пользователей.
     * @return средний возраст пользователей.
     */
    public double calculateAverageAge(List<User> users) {
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }

    /**
     * добавление пользователя в репозиторий
     * @param user объект пользователя
     */
    public void addUserToList(User user){
        repository.getUsers().add(user);
    }



}
