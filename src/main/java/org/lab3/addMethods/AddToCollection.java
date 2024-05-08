package org.lab3.addMethods;


import org.lab3.common.IGenerateElement;
import org.lab3.common.IMethod;

import java.util.Collection;

/**
 * Test add to collection
 * @param <C>  implementation of collection, for example ArrayList
 * @param <E> type of content of the collection
 */
public class AddToCollection<C extends Collection<E>, E> implements IMethod<E> {
    C collection;
    IGenerateElement<E> generateElement;

    /**
     * Constructor with specified generateElement and existing collection
     * @param collection existing collection
     * @param generateElement a function that creates specific to method elements
     */
    public AddToCollection(C collection, IGenerateElement<E> generateElement) {
        this.collection = collection;
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
        collection.add(elem);
    }

    /**
     * Generates method specific content
     *
     * @return element that required by method
     */
    @Override
    public E prepareToApply() {
        return generateElement.getElement();
    }
}
