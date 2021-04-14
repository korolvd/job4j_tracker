package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывае работу банковского обслуживания - хранение счетов клиетов
 * и взаимодействие между счетами
 * @author job4j
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение счетов клинтов осуществляется в хэш-мапе, где клиент (user)
     * выступает ключем, а в значении хранится список счетов клиента
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет клиента, если его еще нет в хэш-мапе
     * @param user - объек клинта
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод добавляет счет, привязывая его к клиенту. Счет привязывает при условии,
     * что такой клиент существует, и у него нет уже такого счета
     * @param passport - уникльные паспортные данные клиенты
     * @param account - добавляемый счет
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            if (!users.get(user).contains(account)) {
                users.get(user).add(account);
            }
        }
    }

    /**
     * Метод ищет клиента в хэш-мапе по паспортным данным
     * @param passport - уникальные паспортные данные
     * @return возвращает клиента если найдено совпадение по паспорту
     */
    public User findByPassport(String passport) {
        User rsl = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rsl = user;
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод ищет счет в хэш-мапе по реквизитам и паспорту клиента
     * @param passport - уникальные паспортные данные
     * @param requisite - реквизиты искомого счета
     * @return возвращает счет, если счет не найден возврашает null
     */
    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (account.getRequisite().equals(requisite)) {
                    rsl = account;
                    break;
                }
            }
        }

        return rsl;
    }

    /**
     * Метод осуществляет перевод средств из одного счета в другой
     * @param srcPassport - паспорт отправителя
     * @param srcRequisite - реквизиты счета отправителя
     * @param destPassport - паспорт получателя
     * @param destRequisite - реквизиты счета получателя
     * @param amount - сумма перевода
     * @return возвращает true, если в хэш-мапе сущестуют отправтель и получатель,
     * и если достаточно средств на счете отправителя
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null
                && destAccount != null
                && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}