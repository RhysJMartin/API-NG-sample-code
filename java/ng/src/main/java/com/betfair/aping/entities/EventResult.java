package com.betfair.aping.entities;

/**
 * Created by user on 3/12/14.
 */
public class EventResult {

    private Event event;
    private int marketCount;

    public Event getEvent() {
        return event;
    }
    public void setEvent(Event myEvent) {
        this.event = myEvent;
    }
    public int getMarketCount() {
        return marketCount;
    }
    public void setMarketCount(int marketCount) {
        this.marketCount = marketCount;
    }

}
