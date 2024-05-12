package org.lab3.common;

/**
 * Interface for element generators.
 * @param <T> the type of the generated element
 */
public interface IGenerateElement<T> {
    /**
     * Generates method-specific content.
     * @return the element required by the method
     */
    T getElement();
}
