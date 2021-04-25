package ru.job4j.bank;

import java.util.*;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            if (!users.get(user.get()).contains(account)) {
                users.get(user.get()).add(account);
            }
        }
    }

    /**
     * Метод ищет клиента в хэш-мапе по паспортным данным
     * @param passport - уникальные паспортные данные
     * @return возвращает клиента если найдено совпадение по паспорту
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод ищет счет в хэш-мапе по реквизитам и паспорту клиента
     * @param passport - уникальные паспортные данные
     * @param requisite - реквизиты искомого счета
     * @return возвращает счет, если счет не найден возврашает null
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user.get())
                    .stream()
                    .filter(a -> a.getRequisite().equals(requisite))
                    .findFirst();
        }
        return Optional.empty();
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
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent()
                && destAccount.isPresent()
                && srcAccount.get().getBalance() >= amount) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}