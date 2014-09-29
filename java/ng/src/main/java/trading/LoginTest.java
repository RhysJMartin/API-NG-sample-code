package trading;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by user on 9/28/14.
 */
public class LoginTest extends TestCase {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testReadLoginInfo() throws Exception {
        Login myLogin = new Login();
        myLogin.readLoginInfo();
    }
}
