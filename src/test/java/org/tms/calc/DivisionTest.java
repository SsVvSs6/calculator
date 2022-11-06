package org.tms.calc;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivisionTest extends BaseTest {

    @Test(dataProvider = "Two number division", description = "Деление двух чисел", priority = 1,
            retryAnalyzer = Retry.class, invocationCount = 1, threadPoolSize = 2)
    public void divisionTwoNumbersTest(int dividendNumber, int dividerNumber, double result) {
        System.out.println(dividendNumber + " / " + dividerNumber + " = " +
                calculator.division(dividendNumber, dividerNumber));
        Assert.assertEquals(calculator.division(dividendNumber, dividerNumber), result,
                "Division is incorrect");
    }

    @DataProvider(name = "Two number division")
    public Object[][] divisionTwoNumbers() {
        return new Object[][]{
                {5, 2, 2.5},
                {4, -5, -0.8},
                {1, -1, -1}
        };
    }

    @Test(dataProvider = "Three number division", description = "Деление трех чисел", priority = 1,
            retryAnalyzer = Retry.class, invocationCount = 1, threadPoolSize = 2)
    public void divisionThreeNumbersTest(int dividendNumber, int firstDividerNumber, int secondDividerNumber,
                                         double result) {
        System.out.println("(" + dividendNumber + " / " + firstDividerNumber + ") / " +secondDividerNumber + " = " +
                calculator.division(calculator.division(dividendNumber, firstDividerNumber),
                        secondDividerNumber));
        Assert.assertEquals(calculator.division(calculator.division(dividendNumber, firstDividerNumber),
                        secondDividerNumber), result,
                "Division is incorrect");
    }

    @DataProvider(name = "Three number division")
    public Object[][] divisionThreeNumbers() {
        return new Object[][]{
                {5, 2, 5, 0.5},
                {4, -5, -2, 0.4},
        };
    }
}
