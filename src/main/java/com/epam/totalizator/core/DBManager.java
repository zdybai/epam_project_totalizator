package com.epam.totalizator.core;

import com.epam.totalizator.core.domain.*;
import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.*;

public class DBManager {
    DB db;
    public DBManager() throws UnknownHostException {
        MongoClient mongoClient = new MongoClient(new ServerAddress("localhost", 27017));
        db = mongoClient.getDB("totalizator");
    }

   /* public ArrayList<Event> getEvents() {
        ArrayList<Event> events = new ArrayList<Event>();
        /*DBCollection eventsColl = db.getCollection("events");
        DBCursor cursor = eventsColl.find();
        while(cursor.hasNext()) {
            DBObject obj = cursor.next();
            int id = Integer.parseInt(obj.get("id").toString());
            String name = obj.get("name").toString();
            Date endBetTime = new Date(obj.get("endBetTime").toString());
            Date eventTime = new Date(obj.get("eventTime").toString());
            Date startBetTime = new Date(obj.get("startBetTime").toString());
            Boolean result = Boolean.parseBoolean(obj.get("result").toString());
            events.add(new Event(id, name, endBetTime, eventTime, result));
        }
        events.add(new Event(1, 1, "Name1", new Date(), new Date(), true));
        events.add(new Event(2, 2, "Name2", new Date(), new Date(), true));
        events.add(new Event(3, 1, "Name3", new Date(), new Date(), true));
        return events;
    }*/
/*
    public ArrayList<Event> getEvents(int userId) {
        ArrayList<Event> events = new ArrayList<Event>();
        events.add(new Event(2, 2, "Name2", new Date(), new Date(), true));
        return events;
    }*/

    public List<Bet> getBets(int eventId) {
        List<Bet> bets = new ArrayList<Bet>();
        DBCollection betsColl = db.getCollection("bets");
        DBCursor cursor = betsColl.find(new BasicDBObject("eventId", eventId));

        while(cursor.hasNext()) {
            DBObject obj = cursor.next();

            //int id = Integer.parseInt(obj.get("betId").toString());
            int eventId1 = (int) Double.parseDouble(obj.get("eventId").toString());
            int userId = (int) Double.parseDouble(obj.get("userId").toString());
            int amount = (int) Double.parseDouble(obj.get("amount").toString());
            boolean result = Boolean.parseBoolean(obj.get("userId").toString());

            bets.add(new Bet(1, userId, eventId1, amount, result));
        }

        return bets;
    }

    /*
    public User login(String login, String password) {
        //return null;
        return new User("user", 100, 2);
    }

    public User register(String login, String password) {
        //return null;
        return new User("user", 100, 1);
    }*/

    public List<Event> getEvents(){
        List<Event> events = new ArrayList<Event>();
        DBCollection eventsColl = db.getCollection("events");
        DBCursor cursor = eventsColl.find();

        while(cursor.hasNext()) {
            DBObject obj = cursor.next();

            int id = (int) Double.parseDouble(obj.get("id").toString());
            String name = obj.get("name").toString();
            Date endBetTime = (Date) obj.get("endBetTime");
            Date eventTime = (Date) obj.get("eventTime");
            Date startBetTime = (Date) obj.get("startBetTime");
            boolean result = Boolean.parseBoolean(obj.get("result").toString());

            Event event = new Event(id, 0, name, endBetTime, eventTime, result);
            event.startBetTime = startBetTime;
            events.add(event);
        }

        return events;
    }

    public List<Event> getEventsById(int userId){
        List<Event> events = new ArrayList<Event>();
        DBCollection eventsColl = db.getCollection("events");
        DBCursor cursor = eventsColl.find(new BasicDBObject("ownerId", userId));

        while(cursor.hasNext()) {
            DBObject obj = cursor.next();


            int id = (int) Double.parseDouble(obj.get("id").toString());
            String name = obj.get("name").toString();
            Date endBetTime = (Date) obj.get("endBetTime");
            Date eventTime = (Date) obj.get("eventTime");
            Date startBetTime = (Date) obj.get("startBetTime");
            boolean result = Boolean.parseBoolean(obj.get("result").toString());

            Event event = new Event(id, userId, name, endBetTime, eventTime, result);
            event.startBetTime = startBetTime;
            events.add(event);
        }

        return events;
    }

    public void createBet(int betId, int ownerId, int eventId, int amount, boolean status){
        Bet bet = new Bet(betId, ownerId, eventId, amount, status);
        db.getCollection("bets").insert(bet.getDBObject())  ;
    }

    public User login(String login, String pass){
        DBCursor cursor = db.getCollection("users").find(new BasicDBObject("login", login));
        if (cursor.hasNext()){
            DBObject obj = cursor.next();
            String passCheck = (String) obj.get("pass").toString();
            if (passCheck.equals(pass)){
                int cash = Integer.parseInt(obj.get("cash").toString());
                int id = Integer.parseInt(obj.get("id").toString());
                User user = new User(login, pass, cash, id);
                return user;
            }
        }
        return null;
    }

    public User register(String login, String pass){
        User user = new User(login, pass, 100, 2);
        db.getCollection("users").insert(user.getDBObject());
        return user;
    }
}
