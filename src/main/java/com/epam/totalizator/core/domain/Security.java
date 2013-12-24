package com.epam.totalizator.core.domain;

import com.mongodb.BasicDBObject;

public class Security{
	public String login, pass;
	public int userId;

	public Security(String login, String pass, int userId){
		this.login = login;
		this.pass = pass;
		this.userId = userId;
	}

	public BasicDBObject getDBObject(){
		BasicDBObject object = new BasicDBObject();
		object.put("login", login);
		object.put("pass", pass);
		object.put("userId", userId);
		return object;
	}
}