package by.charniuk.homelibrary.controller;

import by.charniuk.homelibrary.model.Account;

public interface AccountController {

    String registration(String name, String login, String password);
    Account authorization(String login, String password);
}
