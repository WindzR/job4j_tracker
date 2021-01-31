package ru.job4j.tracker.bank;

import java.util.*;

/**
 * класс позволяет добавлять новых пользователей USER в базу(@since version 1.5),
 * подключать новые счета ACCOUNT к USER,
 * осуществлять поиск по паспорту пользователя passport,
 * и поиск по реквизитам счета ACCOUNT объекта USER,
 * позволяет переводить денежные средства между счетами ACCOUNT.
 * @author Bodin Dmitry
 * @version 1.0
 */
public class BankService {
    /**
     * хранение счетов ACCOUNT пользователя USER осуществляется
     * в коллекции типа HashMap с именем users, ключом для поиска
     * объектов счетов ACCOUNT является объект класса USER
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * добавление пользователя USER в систему(потом в базу данных)
     * @param user объект класса USER
     */
    public void addUser(User user) {
        List<Account> account = new ArrayList<>();
        users.putIfAbsent(user, account);
    }

    /**
     * добавление счета ACCOUNT к пользователю USER
     * @param passport паспорт пользователя(ключ для поиска объектов USER)
     * @param account счет пользователя USER
     */
//    public void addAccount(String passport, Account account) {
//        User user = findByPassport(passport);
//        if (user == null) {
//            return;
//        }
//        List<Account> listAccounts = users.get(user);
//        if (!listAccounts.contains(account)) {
//            listAccounts.add(account);
//        } else {
//            System.out.println("This account is already exist!");
//        }
//    }

    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> listAccounts = users.get(user.get());
            if (!listAccounts.contains(account)) {
                listAccounts.add(account);
            } else {
                System.out.println("This account is already exist!");
            }
        }
    }

    /**
     * поиск пользователя USER по паспорту
     * @param passport паспорт пользователя(ключ для поиска)
     * @return объект класса USER
     */
//    public User findByPassport(String passport) {
//        return users.keySet()
//                .stream()
//                .filter(user -> user.getPassport().equals(passport))
//                .findFirst()
//                .orElse(null);
//    }

    public Optional<User> findByPassport(String passport) {
        Optional<User> rsl = Optional.empty();
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rsl = Optional.of(user);
                break;
            }
        }
        return rsl;
    }

    /**
     * поиск счета пользователя USER по реквизиту счета requisite
     * @param passport ключ для поиска пользователя USER
     * @param requisite ключ для поиска реквизита счета(номер счета)
     * @return счет пользователя ACCOUNT
     */
//    public Account findByRequisite(String passport, String requisite) {
//        User user = findByPassport(passport);
//        if (user != null) {
//            return users.get(user)
//                    .stream()
//                    .filter(data -> data.getRequisite().equals(requisite))
//                    .findFirst()
//                    .orElse(null);
//        }
//        return null;
//    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<Account> rsl = Optional.empty();
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            for (Account account : users.get(user.get())) {
                if (account.getRequisite().equals(requisite)) {
                    rsl = Optional.of(account);
                    break;
                }
            }
        }
        return rsl;
    }

    /**
     * осуществляет перевод между счетами денежных средств,
     * проверяет достаточность средств для перевода
     * @param srcPassport паспорт пользователя счета, с которого списываются средства
     * @param srcRequisite реквизит счета, с которого списываются средства
     * @param destPassport паспорт пользователя счета, на который начисляются средства
     * @param destRequisite реквизит счета, на который начисляются средства
     * @param amount сумма перевода
     * @return результат проведения операции (успешно/ неуспешно)
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent()
                && destAccount.isPresent()
                && amount <= srcAccount.get().getBalance()) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
