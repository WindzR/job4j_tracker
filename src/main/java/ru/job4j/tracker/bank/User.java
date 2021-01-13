package ru.job4j.bank;

import java.util.Objects;

/**
 * класс описывает пользователя банковского сервиса,
 * является моделью описания данных USER
 * @author Bodin Dmitry
 * @version 1.0
 */
public class User {
    /**
     * Хранение данных осуществляется в объекте String
     * String passport является ключом при поиске конкретного USER
     * String username имя пользователя
     */
    private String passport;
    private String username;

    /**
     * конструктор класса USER
     * @param passport при инициализации USER, добавляем в память паспорт пользователя
     * @param username при инициализации USER, добавляем в память имя пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * геттер passport
     * @return возвращает passport, - ключ для поиска по объектам типа USER
     */
    public String getPassport() {
        return passport;
    }

    /**
     * сеттер passport
     * @param passport переписывает passport, - ключ для поиска по объектам типа USER
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * геттер username
     * @return возвращает username, - имя объектов типа USER
     */
    public String getUsername() {
        return username;
    }

    /**
     * сеттер username
     * @param username переписывает username, - имя объектов типа USER
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * переопреление equals для USER
     * @param o переопределяем o и приводим его к объекту USER
     * @return passport, переопределяем equals только для поля passport
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * переопределение hashcode для USER
     * @return hashcode для поля passport
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
