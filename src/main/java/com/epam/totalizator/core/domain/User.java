package com.epam.totalizator.core.domain;

/**
 * Created with IntelliJ IDEA.
 * User: Zdybai
 * Date: 23.12.13
 * Time: 22:47
 * To change this template use File | Settings | File Templates.
 */
public class User {
    String login;
    int cash;
    int id;

    public User(String login, int cash, int id){
        this.cash = cash;
        this.id = id;
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public int getCash() {
        return cash;
    }

    public int getId() {
        return id;
    }
}
