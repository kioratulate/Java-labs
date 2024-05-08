package org.lab3.common;
/**
 * Interface for measuring execution time of method
 * @param <T> type of elements that required by method, for example add requires some element to add
 */
public interface IMethod<T> {
    /**
     * Method to be tested
     * WARNING! Inside this method should not be any unnecessary operations,
     * or performance measurement won't be correct
     * @param elem element that needs to be provided
     */
    void apply(T elem);
    /**
     * Does method specific actions
     * @return method specific element
     */
    T prepareToApply();
}
