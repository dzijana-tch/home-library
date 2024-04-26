package by.charniuk.homelibrary.repository;

import by.charniuk.homelibrary.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByLogin(String login);

}