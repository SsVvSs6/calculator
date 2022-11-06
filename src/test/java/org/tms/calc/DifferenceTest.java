package org.tms.calc;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DifferenceTest extends BaseTest {

    @Test (dataProvider = "Two number difference", description = "Разность двух чисел", priority = 1,
            retryAnalyzer = Retry.class, invocationCount = 1, threadPoolSize = 2)
    public void differenceTwoNumbersTest(int minuendNumber, int subtrahendNumber, int result) {
        System.out.println(minuendNumber + " - " + subtrahendNumber + " = " +
                calculator.difference(minuendNumber, subtrahendNumber));
        Assert.assertEquals(calculator.difference(minuendNumber, subtrahendNumber), result,
                "Difference is incorrect");
    }

    @DataProvider(name = "Two number difference")
    public Object[][] differenceTwoNumbers() {
        return new Object[][] {
                {5, 2, 3},
                {4, 5, -1},
                {1, -1, 2}
        };
    }

    @Test (dataProvider = "Three number difference", description = "Разность двух чисел", priority = 2,
            retryAnalyzer = Retry.class, invocationCount = 1, threadPoolSize = 2)
    public void differenceThreeNumbersTest(int minuendNumber, int firstSubtrahendNumber, int secondSubtrahendNumber,
                                       int result) {
        System.out.println(minuendNumber + " - " + firstSubtrahendNumber +  " - " + secondSubtrahendNumber + " = " +
                calculator.difference(calculator.difference(minuendNumber, firstSubtrahendNumber), secondSubtrahendNumber));
        Assert.assertEquals(calculator.difference(calculator.difference(minuendNumber, firstSubtrahendNumber),
                        secondSubtrahendNumber), result, "Difference is incorrect");
    }

    @DataProvider(name = "Three number difference")
    public Object[][] differenceThreeNumbers() {
        return new Object[][] {
                {5, 2, -4, 7},
                {4, 5, 0, -1},
                {1, -1, 8, -6}
        };
    }

    @Test (dataProvider = "Two number difference with incorrect result", description = "Разность двух чисел, но результат неверный",
            priority = 3, retryAnalyzer = Retry.class, invocationCount = 1, threadPoolSize = 2)
    public void differenceTwoNumbersButIncorrectResultTest(int minuendNumber, int subtrahendNumber, int result) {
        System.out.println(minuendNumber + " - " + subtrahendNumber + " = " +
                calculator.difference(minuendNumber, subtrahendNumber));
        Assert.assertEquals(calculator.difference(minuendNumber, subtrahendNumber), result,
                "Difference is incorrect");
    }

    @DataProvider(name = "Two number difference with incorrect result")
    public Object[][] differenceTwoNumbersWithIncorrectResult() {
        return new Object[][] {
                {5, 2, 9}
        };
    }
}
