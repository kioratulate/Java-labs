package org.lab3.common;
/**
 * Interface for measuring the execution time of a method.
 * @param <T> the type of elements required by the method; for example, 'add' requires an element to add
 */
public interface IMethod<T> {
    /**
     * Method to be tested.
     * WARNING! Inside this method, there should not be any unnecessary operations,
     * or the performance measurement won't be correct.
     * @param elem the element that needs to be provided
     */
    void apply(T elem);
    /**
     * Prepares the method for execution by generating the required element and other method specific actions.
     * @return the method-specific element
     */
    T prepareToApply();
}
