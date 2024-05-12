package org.lab2.calculator;

import java.util.List;

/**
 * Interface of function that can be added to calculator
 */
public interface IFunction {
    /**
     * Applying function
     * @param args arguments of function
     * @return result value of function
     */
    double apply(List<Double> args);
}
