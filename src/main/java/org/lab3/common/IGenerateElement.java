package org.lab3.common;

/**
 * Interface for element generators
 * @param <T> type of generated element
 */
public interface IGenerateElement<T> {
    /**
     * Generates method specific content
     * @return element that required by method
     */
    T getElement();
}
