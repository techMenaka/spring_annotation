package com.spring.cmd;

import com.spring.cmd.annotation.UniqueLogin;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import java.util.List;
import java.util.Objects;

/**
 * Created by menaka on 3/9/17.
 */
public class User {

    @UniqueLogin(value = "value set")
    private String login;
    private char[] password;

    private User() {
        // no-arg Jackson constructor
    }

    public User(String login, char[] password) {
        Objects.requireNonNull(login);
        Objects.requireNonNull(password);
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

}