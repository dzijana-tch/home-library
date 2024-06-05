package by.charniuk.homelibrary.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue
    private Long id;
   // @Enumerated(EnumType.STRING)
    private Role role;
    private String name;
    @Column(unique = true)
    private String login;
    private String password;

    public Account(Role role, String name, String login, String password) {
        this.role = role;
        this.name = name;
        this.login = login;
        this.password = password;
    }

}
