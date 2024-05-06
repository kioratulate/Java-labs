package org.lab3;

/**
 * Interface for measuring execution time of method
 * @param <T> type of elements that required by method, for example add requires some element to add,
 *           if your method not requires any elements leave void
 */
public interface TestMethod<T> {
    /**
     * Method to be tested
     * WARNING! Inside this method should not be any unnecessary operations,
     * or performance measurement won't be correct
     * @param elem element that needs to be provided, if your method not requires any elements leave void
     */
    public void apply(T elem);

    /**
     * Generates method specific content
     * @return element that required by method or void if method requires no elements
     */
    public T getContent();
}
