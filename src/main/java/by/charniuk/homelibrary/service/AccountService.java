package by.charniuk.homelibrary.service;

import by.charniuk.homelibrary.model.Account;

public interface AccountService {

    boolean registration(String name, String login, String password);
    Account authorization(String login, String password);
}
