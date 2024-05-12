package org.lab3.otherMethods;


import org.lab3.common.IMethod;

import java.util.Collection;

/**
 * A method to test the clear method of a collection.
 * @param <C> The collection to be tested.
 * @param <E> The type of content in the collection.
 */
public class ClearCollection<C extends Collection<E>, E> implements IMethod<E> {

    /**
     * The collection to be tested.
     */
    C collection;

    /**
     * Constructs a ClearCollection with the specified collection.
     * @param collection The existing collection.
     */
    public ClearCollection(C collection) {
        this.collection = collection;
    }

    /**
     * The method to be tested.
     *
     * @param elem The element that needs to be provided.
     */
    @Override
    public void apply(E elem) {
        collection.clear();
    }

    /**
     * Does method-specific actions.
     * @return The method-specific element.
     */
    @Override
    public E prepareToApply() {
        return null;
    }
}
