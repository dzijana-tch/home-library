package by.charniuk.homelibrary.service.impl;

import by.charniuk.homelibrary.model.Account;
import by.charniuk.homelibrary.model.Role;
import by.charniuk.homelibrary.repository.AccountRepository;
import by.charniuk.homelibrary.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public boolean registration(String name, String login, String password) {
        if (accountRepository.findByLogin(login) != null) {
            return false;
        }
        Account a = new Account(Role.USER, name, login, password);
        accountRepository.save(a);
        return true;
    }

    @Override
    public Account authorization(String login, String password) {
        Account a;
        a = accountRepository.findByLogin(login);
        if (a.getPassword().equals(password)) {
            return a;
        }
        return null;
    }
}
