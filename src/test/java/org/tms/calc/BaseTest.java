package org.tms.calc;

import org.testng.annotations.*;

@Listeners(Listener.class)
public abstract class BaseTest {

    protected Calculator calculator;

    @BeforeClass
    public void startCalculation() {
        System.out.println("===== Class Test starts =====");
        calculator = new Calculator();
    }

    @BeforeMethod
    public void testMethodStart() {
        System.out.println("===== Method starts =====");
    }

    @AfterMethod
    public void testMethodEnd() {
        System.out.println("===== Method ends =====");
    }

    @AfterClass
    public void stopCalculation() {
        System.out.println("===== Class Test ends =====");
    }
}
