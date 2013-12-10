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

    public ArrayList<Event> getEvents() {
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
        }*/
        events.add(new Event(1, "Name1", new Date(), new Date(), true));
        events.add(new Event(2, "Name2", new Date(), new Date(), true));
        events.add(new Event(3, "Name3", new Date(), new Date(), true));
        return events;
    }

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
}
