package com.betfair.aping.entities;

/**
 * Created by user on 3/6/14.
 */
public class CompetitionResult {

    private Competition competition;
    private int marketCount;
    private String competitionRegion;

    public Competition getCompetition() {
        return competition;
    }
    public void setCompetition(Competition myCompetition) {
        this.competition = myCompetition;
    }
    public int getMarketCount() {
        return marketCount;
    }
    public void setMarketCount(int marketCount) {
        this.marketCount = marketCount;
    }

    public String getCompetitionRegion() {
        return competitionRegion;
    }

    public void setCompetitionRegion(String competitionRegion) {
        this.competitionRegion = competitionRegion;
    }
}