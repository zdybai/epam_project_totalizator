package com.epam.totalizator.core.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Event {

    public String name;
    public int id, ownerId;

    public Date startBetTime, endBetTime, eventTime;

    public boolean result;
    public boolean active;

    public Event(int id, int ownerId, String name, Date endBetTime, Date eventTime, boolean result){
        this.id = id;
        this.ownerId = ownerId;
        this.name = name;
        this.endBetTime = endBetTime;
        this.eventTime = eventTime;
        startBetTime = new Date();
        this.result = result;
        active = true;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public Date getStartBetTime() {
        return startBetTime;
    }

    public Date getEndBetTime() {
        return endBetTime;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public boolean getResult() {
        return result;
    }

    public boolean getActive() {
        return active;
    }
}
