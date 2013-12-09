package com.epam.totalizator.core;

import com.epam.totalizator.core.domain.*;
import java.util.*;

public class DBManager {
    public DBManager(){
    }

    public ArrayList<Event> GetEvents() {
        ArrayList<Event> events = new ArrayList<Event>();
        events.add(new Event(1, "First event", new Date(), new Date(), true));
        events.add(new Event(2, "Second event", new Date(), new Date(), true));
        events.add(new Event(3, "Third event", new Date(), new Date(), false));
        return events;
    }
}
