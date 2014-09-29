package com.betfair.aping;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by user on 9/28/14.
 */
public class ApiNGDemoTest extends TestCase {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testMain() throws Exception {
        String[] args = {"3px2lx4xudJuwesg","vAAUCpGpTy1sJILa7mLVMRIqeZBpsBumDHR6uGxXf20=","json-rpc"};
        ApiNGDemo.main(args);
    }
}
