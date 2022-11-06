package org.tms.calc;

public class Calculator {

    public Calculator() {
    }

    public int sum(int firstNumber, int secondNumber) {

        return firstNumber + secondNumber;
    }

    public int difference(int minuendNumber, int subtrahendNumber) {

        return minuendNumber - subtrahendNumber;
    }

    public int multiplication(int firstMultipliedNumber, int secondMultipliedNumber) {

        return firstMultipliedNumber * secondMultipliedNumber;
    }

    public double division(double dividendNumber, double dividerNumber) {

        return dividendNumber / dividerNumber;
    }
}
