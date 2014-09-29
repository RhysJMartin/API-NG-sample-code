package com.betfair.aping.containers;

import com.betfair.aping.entities.CompetitionResult;
import com.betfair.aping.entities.EventResult;

import java.util.List;

/**
 * Created by user on 3/12/14.
 */
public class EventResultContainer extends Container{

    private List<EventResult> result;

    public List<EventResult> getResult() {
        return result;
    }

    public void setResult(List<EventResult> result) {
        this.result = result;
    }
}
