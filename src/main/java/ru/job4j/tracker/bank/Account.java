package ru.job4j.bank;

import java.util.Objects;

/**
 * класс Account описывает модель данных аккаунта(счета) пользователя user
 * @author Bodin Dmitry
 * @version 1.0
 */
public class Account {
    /**
     * Хранение данных осуществляется
     * String requisite реквизиты счета
     * double balance баланс счета
     */
    private String requisite;
    private double balance;

    /**
     * конструктор объекта Account
     * @param requisite инициализация реквизитов счета в памяти
     * @param balance инициализация баланса счета в памяти
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * геттер поля requisite
     * @return requisite, номер счета объекта Account
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * сеттер поля requisite
     * @param requisite , позволяет переписать данные счета Account
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * геттер поля balance
     * @return balance, баланс счета объекта Account
     */
    public double getBalance() {
        return balance;
    }

    /**
     * сеттер поля requisite
     * @param balance , позволяет изменять(списывать или начисления) счета Account
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * переопреление equals для ACCOUNT
     * @param o переопределяем o и приводим его к объекту ACCOUNT
     * @return requisite, переопределяем equals только для поля requisite
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * переопределение hashcode для ACCOUNT
     * @return hashcode для поля requisite
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }

    @Override
    public String toString() {
        return "Account{"
                + "requisite='" + requisite + '\''
                + ", balance=" + balance
                + '}';
    }
}
