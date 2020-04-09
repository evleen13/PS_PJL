package com.sapient.week1;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

public class CheckEvenTest {
	private CheckEven app;
	@Before
    public void setup() {
        app = new CheckEven();
    }
    
    
    @Test
    public void testInputTen() {
        boolean count = app.check(10);
        assertTrue(count==true);
    }

    @Test
    public void testInputOne() {
        boolean count = app.check(1);
        assertTrue(count == false);
    }
    
    @Test
    @Ignore
    public void testInputFail() {
    	 boolean count = app.check(1);
         assertTrue(count == false);
    }
}
