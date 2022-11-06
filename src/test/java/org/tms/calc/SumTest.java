package org.tms.calc;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SumTest extends BaseTest {

    @Test (dataProvider = "Two number sum", description = "Сумма двух чисел", priority = 1,
            retryAnalyzer = Retry.class, invocationCount = 1, threadPoolSize = 2)
    public void sumTwoNumbersTest(int firstNumber, int secondNumber, int sumResult) {
        System.out.println(firstNumber + " + " + secondNumber + " = " + calculator.sum(firstNumber, secondNumber));
        Assert.assertEquals(calculator.sum(firstNumber, secondNumber), sumResult,
                "Sum is incorrect");
    }

    @DataProvider(name = "Two number sum")
    public Object[][] sumTwoNumbers() {
        return new Object[][] {
                {5, 2, 7},
                {4, 5, 9},
                {1, 1, 2}
        };
    }

    @Test (dataProvider = "Three number sum", description = "Сумма трех чисел", priority = 2,
            retryAnalyzer = Retry.class, invocationCount = 1, threadPoolSize = 2)
    public void sumThreeNumbersTest(int firstNumber, int secondNumber, int thirdNumber, int sumResult) {
        System.out.println(firstNumber + " + " + secondNumber + " + " + thirdNumber+ " = " +
                calculator.sum(calculator.sum(firstNumber, thirdNumber), secondNumber));
        Assert.assertEquals(calculator.sum(calculator.sum(firstNumber, thirdNumber), secondNumber), sumResult,
                "Sum is incorrect");
    }

    @DataProvider(name = "Three number sum")
    public Object[][] sumThreeNumbers() {
        return new Object[][] {
                {5, 2, 2, 9},
                {4, 5, -1, 8}
        };
    }

    @Test (dataProvider = "Two number sum with incorrect result",
            description = "Сумма трех чисел, но результат неверный", priority = 3,
            retryAnalyzer = Retry.class, invocationCount = 1, threadPoolSize = 2)
    public void sumTwoNumbersButIncorrectResultTest(int firstNumber, int secondNumber, int sumResult) {
        System.out.println(firstNumber + " + " + secondNumber + " = " + calculator.sum(firstNumber, secondNumber));
        Assert.assertEquals(calculator.sum(firstNumber, secondNumber), sumResult, "Sum is incorrect");
    }

    @DataProvider(name = "Two number sum with incorrect result")
    public Object[][] sumTwoNumbersWithIncorrectResult() {
        return new Object[][] {
                {5, 2, 9},
                {4, 5, 8}
        };
    }
}
