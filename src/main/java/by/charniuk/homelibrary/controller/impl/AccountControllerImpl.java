package by.charniuk.homelibrary.controller.impl;

import by.charniuk.homelibrary.controller.AccountController;
import by.charniuk.homelibrary.model.Account;
import by.charniuk.homelibrary.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/account")
@AllArgsConstructor
public class AccountControllerImpl implements AccountController {

    private final AccountService accountService;

    @PostMapping("signup/{name}&{login}&{password}")
    @Override
    public String registration(@PathVariable String name, @PathVariable String login, @PathVariable String password) {
        if (accountService.registration(name, login, password)) {
            return "Registration completed successfully";
        }
        return "User with this login already exists";
    }

    @GetMapping("login/{login}&{password}")
    @Override
    public Account authorization(@PathVariable String login, @PathVariable String password) {
        return accountService.authorization(login, password);
    }
}
