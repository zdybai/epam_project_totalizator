package com.epam.totalizator.core.domain;

import com.mongodb.BasicDBObject;

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
    String pass;

    public User(String login, String pass, int cash, int id){
        this.cash = cash;
        this.id = id;
        this.login = login;
        this.pass = pass;
    }

    public BasicDBObject getDBObject(){
        BasicDBObject object = new BasicDBObject();
        object.put("login", login);
        object.put("cash", cash);
        object.put("id", id);
        object.put("pass", pass);
        return object;
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
