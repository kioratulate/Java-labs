package org.lab2;

import org.lab2.calculator.Calculator;

import java.util.Scanner;

/**
 * Example of usage of Calculator
 */
public class Main {
    /**
     * Main method demonstrating the usage of the Calculator class.
     * It creates an instance of Calculator, adds a custom function, and continuously prompts the user for expressions to evaluate.
     * @param args Command-line arguments (not used in this example).
     */
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        calculator.addFunction("sum", args1 -> {
            double sum = 0;
            for (double val: args1)
                sum+=val;
            return sum;
        });
        Scanner in = new Scanner(System.in);
        boolean status = true;
        while (status)
        {
        System.out.print("Expression: ");
        String expression = in.nextLine();
        if (expression!="")
        {
            try {
                System.out.println("Result:" + calculator.processExpression(expression));
                }
            catch (Exception e){
                e.printStackTrace();
                }
        }
        else {
            status = false;
        }
        }
    }
}