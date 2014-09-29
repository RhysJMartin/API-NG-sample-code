package trading;

import com.betfair.aping.api.ApiNgOperations;
import com.betfair.aping.entities.MarketBook;
import com.betfair.aping.entities.PriceProjection;
import com.betfair.aping.enums.MatchProjection;
import com.betfair.aping.enums.OrderProjection;
import com.betfair.aping.enums.PriceData;
import com.betfair.aping.exceptions.APINGException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
* Created by user on 3/29/14.
*/
final class GetMarketData {

    List<String> marketIds;
    ApiNgOperations jsonOperations;
    LoginDetails myLoginDetails;

    GetMarketData(List<String> marketIds, ApiNgOperations jsonOperations, LoginDetails myLoginDetails){
        this.marketIds = marketIds;
        this.jsonOperations = jsonOperations;
        this.myLoginDetails = myLoginDetails;
    }

    List<MarketBook> GetData() throws APINGException {
    PriceProjection priceProjection = new PriceProjection();
    Set<PriceData> priceData = new HashSet<PriceData>();
    priceData.add(PriceData.EX_BEST_OFFERS);
    //priceData.add(PriceData.EX_ALL_OFFERS);
    priceData.add(PriceData.EX_TRADED);
    //priceData.add(PriceData.SP_AVAILABLE);
    //priceData.add(PriceData.SP_TRADED);
    priceProjection.setPriceData(priceData);

    OrderProjection orderProjection = OrderProjection.ALL;
    MatchProjection matchProjection = MatchProjection.NO_ROLLUP;
    String currencyCode = null;

    List<MarketBook> marketBookReturn = jsonOperations.listMarketBook(marketIds, priceProjection,
            orderProjection, matchProjection, currencyCode, myLoginDetails.getApplicationKey(),
            myLoginDetails.getSessionToken());
        return marketBookReturn;
}
}
