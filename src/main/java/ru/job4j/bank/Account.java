package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает базовую модель банковский счет
 * @author job3j
 * @version 1.0
 */
public class Account {
    /**
     * Объект Счет хранит собственные реквизиты для транзакций и балан
     */
    private String requisite;
    private double balance;

    /**
     * При создании счета сразу задаются параметры
     * @param requisite - уникальные реквизиты
     * @param balance - баланс
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
