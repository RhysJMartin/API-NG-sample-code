package trading;

import com.betfair.aping.api.ApiNgJsonRpcOperations;
import com.betfair.aping.api.ApiNgOperations;
import com.betfair.aping.entities.*;
import com.betfair.aping.enums.*;
import com.betfair.aping.exceptions.APINGException;
import trading.enums.CommonCompetitionNames;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by user on 9/29/14.
 */
public class KillingTime {

    LoginDetails myLoginDetails = new LoginDetails(new File("C:\\Users\\user\\Desktop\\login.txt"));
    private ApiNgOperations jsonOperations = ApiNgJsonRpcOperations.getInstance();

    public List<String> findSoccerMarketId() throws APINGException {
        MarketFilter myMarketFilter = new MarketFilter();

        List<EventTypeResult> myListEventTypes = jsonOperations.listEventTypes(myMarketFilter,
                myLoginDetails.getApplicationKey(), myLoginDetails.getSessionToken());

        String myEvent = "Soccer";
        Set<String> eventTypeIds = getEventTypeIds(myListEventTypes, myEvent);

        String aCompetitionName = CommonCompetitionNames.BARCLAYS_PREMIER_LEAGUE.GetCompetitionName();

        Set<String> competitionIds = getCompetitionIds(myMarketFilter, aCompetitionName);

        myMarketFilter.setCompetitionIds(competitionIds);

        String aEventName = "Stoke v Newcastle";
        Set<String> eventIds = getEventIds(myMarketFilter, aEventName);
        myMarketFilter.setEventIds(eventIds);

        Set<MarketProjection> marketProjection = new HashSet<MarketProjection>();
        marketProjection.add(MarketProjection.MARKET_DESCRIPTION);
        marketProjection.add(MarketProjection.RUNNER_DESCRIPTION);
        marketProjection.add(MarketProjection.MARKET_START_TIME);
        marketProjection.add(MarketProjection.COMPETITION);
        marketProjection.add(MarketProjection.EVENT);
        marketProjection.add(MarketProjection.EVENT_TYPE);

        String maxResults = "100";

        List<MarketCatalogue> myMarketCatalogues = jsonOperations.listMarketCatalogue(myMarketFilter, marketProjection, MarketSort.FIRST_TO_START,
                maxResults, myLoginDetails.getApplicationKey(), myLoginDetails.getSessionToken());

        String myMarketName = "Match Odds";
        List<String> marketIds = new ArrayList<String>();
        for(MarketCatalogue myMarketCatalogue: myMarketCatalogues){
            if(myMarketCatalogue.getMarketName().matches(myMarketName)){
                marketIds.add(myMarketCatalogue.getMarketId());
            }
        }

        GetMarketData myGetMarketData = new GetMarketData(marketIds, jsonOperations, myLoginDetails);

        PriceProjection priceProjection = new PriceProjection();
        Set<PriceData> priceData = new HashSet<PriceData>();
        priceData.add(PriceData.EX_BEST_OFFERS);
        //priceData.add(PriceData.EX_ALL_OFFERS);
        priceData.add(PriceData.EX_TRADED);
        //priceData.add(PriceData.SP_AVAILABLE);
        //priceData.add(PriceData.SP_TRADED);

        priceProjection.setPriceData(priceData);

        //In this case we don't need these objects so they are declared null
        OrderProjection orderProjection = OrderProjection.ALL;
        MatchProjection matchProjection = MatchProjection.NO_ROLLUP;
        String currencyCode = null;

        //List<String> marketIds = new ArrayList<String>();
        //marketIds.add(myMarketId);

        List<MarketBook> marketBookReturn = jsonOperations.listMarketBook(marketIds, priceProjection,
                orderProjection, matchProjection, currencyCode, myLoginDetails.getApplicationKey(),
                myLoginDetails.getSessionToken());

        return marketIds;
    }

    private Set<String> getEventTypeIds(List<EventTypeResult> myListEventTypes, String aEvent) {
        Set<String> eventTypeIds = new HashSet<String>();
        for (EventTypeResult eventTypeResult : myListEventTypes) {
            if(eventTypeResult.getEventType().getName().equals(aEvent)){
                System.out.println("1. EventTypeId for " + aEvent + "  is: " + eventTypeResult.getEventType().getId() + "\n");
                eventTypeIds.add(eventTypeResult.getEventType().getId().toString());
            }
        }
        return eventTypeIds;
    }

    private Set<String> getCompetitionIds(MarketFilter myMarketFilter, String aCompetitionName) throws APINGException {
        Set<String> competitionIds = new HashSet<String>();
        List<CompetitionResult> myCompetitionResults = jsonOperations.listCompetitions(myMarketFilter,
                myLoginDetails.getApplicationKey(), myLoginDetails.getSessionToken());
        for(CompetitionResult myCompetitionResult : myCompetitionResults){
            if(myCompetitionResult.getCompetition().getName().matches(aCompetitionName)){
                competitionIds.add(myCompetitionResult.getCompetition().getId());
                System.out.println(aCompetitionName + " has competition id " + myCompetitionResult.getCompetition().getId());
            }
        }
        return competitionIds;
    }

    private Set<String> getEventIds(MarketFilter myMarketFilter, String aEventName) throws APINGException {
        Set<String> eventIds = new HashSet<String>();
        List<EventResult> myEventResults = jsonOperations.listEvents(myMarketFilter,
                myLoginDetails.getApplicationKey(), myLoginDetails.getSessionToken());
        for(EventResult myEventResult : myEventResults){
            if(myEventResult.getEvent().getName().matches(aEventName)){
                eventIds.add(myEventResult.getEvent().getId());
                System.out.println(aEventName + " has event id " + myEventResult.getEvent().getId());
            }
        }
        return eventIds;
    }
}
