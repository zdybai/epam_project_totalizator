package com.epam.totalizator.core.domain;

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
}
