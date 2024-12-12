package com.example.example3hometask.domain;

public class User {

    private String name;    // Имя пользователя.
    private int age;        // Возраст пользователя.
    private String email;   // Адрес электронной почты.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
