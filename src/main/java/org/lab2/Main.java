package org.lab2;

import org.lab2.calculator.Calculator;
import org.lab2.calculator.Function;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        calculator.addFunction("sum", args1 -> {
            double sum = 0;
            for (double val: args1)
                sum+=val;
            return sum;
        });
        Scanner in = new Scanner(System.in);
        while (true)
        {
        System.out.print("Введите выражение: ");
        String expression = in.nextLine();
        try {
            System.out.println("Результат:" + calculator.processExpression(expression));
        }
        catch (Exception e){
            System.out.println(e);
        }
        }
    }
}