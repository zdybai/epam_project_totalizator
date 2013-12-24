package com.epam.totalizator.core.domain;

import com.mongodb.BasicDBObject;

public class Bet {

    int betId, ownerId, eventId;
    int amount;
    boolean status;
    public Bet(int betId, int ownerId, int eventId, int amount, boolean status){
        this.betId = betId;
        this.ownerId = ownerId;
        this.eventId = eventId;
        this.amount = amount;
        this.status = status;
    }

    public int getBetId() {
        return betId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public int getEventId() {
        return eventId;
    }

    public int getAmount() {
        return amount;
    }

    public boolean getStatus() {
        return status;
    }

    public BasicDBObject getDBObject(){
        BasicDBObject object = new BasicDBObject();
        object.put("betId", betId);
        object.put("ownerId", ownerId);
        object.put("eventId", eventId);
        object.put("amount", amount);
        object.put("status", status);
        return object;
    }
}
