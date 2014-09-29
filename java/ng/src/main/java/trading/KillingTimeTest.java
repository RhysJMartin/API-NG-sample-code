package trading;

import com.betfair.aping.exceptions.APINGException;
import junit.framework.TestCase;
import org.junit.Before;

/**
 * Created by user on 9/29/14.
 */
public class KillingTimeTest extends TestCase {
    KillingTime myKillingTime;

    @Before
    public void setUp() throws Exception {
        myKillingTime = new KillingTime();
    }

    public void testFindAllFootballCompetitions() throws APINGException {
            myKillingTime.findSoccerMarketId();
    }


}
