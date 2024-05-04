package org.lab2.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator;
    @BeforeEach
    void setup(){
        calculator = new Calculator();
    }
    @Test
    void processExpressionPositiveInput() {
        String expression = "7 - 11 *((8-11)+2*5 + 5.5*7.2 - 100/4)/7.2";
        try {
            assertEquals(-26,  calculator.processExpression(expression));
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }
    @Test
    void processExpressionNegativeInput() {
        String expression = "((8-11)(+2*5 + 5.5*7.2 - 100/4)/7.2";
        try {
            assertEquals(-26,  calculator.processExpression(expression));
        }
        catch (Exception e){
            System.out.println();
            assertEquals("java.lang.RuntimeException: Wrong syntax at 7", e.toString());
        }
    }
}