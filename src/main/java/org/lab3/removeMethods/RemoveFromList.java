package org.lab3.removeMethods;

import org.lab3.common.IGenerateElement;
import org.lab3.common.IMethod;

import java.util.List;

/**
 * Abstract class for Remove methods of List
 * @param <T> implementation of List, for example ArrayList
 * @param <E> type of content of the list
 */
public abstract class RemoveFromList<T extends List<E>, E> implements IMethod<E> {

    /**
     * Testing list
     */
    T list;
    /**
     * Index for remove method
     */
    int ind;
    /**
     * Used generator
     */
    IGenerateElement<E> generateElement;

    /**
     * Constructor with specified generateElement and existing list
     * @param list existing list
     * @param generateElement a function that creates specific to method elements
     */
    public RemoveFromList(T list, IGenerateElement<E> generateElement) {
        this.list = list;
        this.generateElement = generateElement;
    }

    /**
     * Method to be tested
     * WARNING! Inside this method should not be any unnecessary operations,
     * or performance measurement won't be correct
     *
     * @param elem element that needs to be provided
     */
    @Override
    public void apply(E elem) {
           list.remove(ind);
    }

    /**
     * Sets index at which will be passed into remove
     *
     * @return element that required by method
     */
    @Override
    public abstract E prepareToApply();
}
