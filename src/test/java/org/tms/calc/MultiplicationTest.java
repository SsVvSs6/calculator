package org.tms.calc;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultiplicationTest extends BaseTest {

    @Test (dataProvider = "Two number multiplication", description = "Умножение двух чисел", priority = 1,
            retryAnalyzer = Retry.class, invocationCount = 1, threadPoolSize = 2)
    public void multiplicationTwoNumbersTest(int firstMultipliedNumber, int secondMultipliedNumber, int result) {
        System.out.println(firstMultipliedNumber + " * " + secondMultipliedNumber + " = " +
                calculator.multiplication(firstMultipliedNumber, secondMultipliedNumber));
        Assert.assertEquals(calculator.multiplication(firstMultipliedNumber, secondMultipliedNumber), result,
                "Multiplication is incorrect");
    }

    @DataProvider(name = "Two number multiplication")
    public Object[][] multiplicationTwoNumbers() {
        return new Object[][] {
                {5, 2, 10},
                {4, -5, -20},
                {1, -1, 2}
        };
    }

    @Test (dataProvider = "Three number multiplication", description = "Умножение трех чисел", priority = 2,
            retryAnalyzer = Retry.class, invocationCount = 2, threadPoolSize = 4)
    public void multiplicationThreeNumbersTest(int firstMultipliedNumber, int secondMultipliedNumber,
                                               int thirdMultipliedNumber, int result) {
        System.out.println(firstMultipliedNumber + " * " + secondMultipliedNumber + " * " + thirdMultipliedNumber +
                " = " + calculator.multiplication(calculator.multiplication(firstMultipliedNumber,
                thirdMultipliedNumber), secondMultipliedNumber));
        Assert.assertEquals(calculator.multiplication(
                calculator.multiplication(firstMultipliedNumber, thirdMultipliedNumber),
                secondMultipliedNumber), result, "Multiplication is incorrect");
    }

    @DataProvider(name = "Three number multiplication")
    public Object[][] multiplicationThreeNumbers() {
        return new Object[][] {
                {5, 2, 3, 30},
                {4, -5, 6, -120},
        };
    }
}
