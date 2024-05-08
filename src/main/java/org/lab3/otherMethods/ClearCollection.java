package org.lab3.otherMethods;

import org.lab3.common.IMethod;

import java.util.Collection;

/**
 * Testing collection's method clear
 * @param <C> collection to be tested
 * @param <E> type of content of the collection
 */
public class ClearCollection<C extends Collection<E>, E> implements IMethod<E> {

    /**
     * Collection to be tested
     */
    C collection;

    /**
     * Constructor with existing list
     * @param collection existing collection
     */
    public ClearCollection(C collection) {
        this.collection = collection;
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
        collection.clear();
    }

    /**
     * Does method specific actions
     *
     * @return method specific element
     */
    @Override
    public E prepareToApply() {
        return null;
    }
}
