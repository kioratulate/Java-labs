package org.lab3.addMethods;

import org.lab3.common.IGenerateElement;
import org.lab3.common.IMethod;

import java.util.Collection;

public class AddAllToCollection<C extends Collection<B>, E extends Collection<B>, B> implements IMethod<E> {

    C collection;
    IGenerateElement<E> generateElement;
    /**
     * Constructor with specified generateElement and existing collection
     *
     * @param collection      existing collection
     * @param generateElement a function that creates specific to method elements
     */
    public AddAllToCollection(C collection, IGenerateElement<E> generateElement) {
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
        collection.addAll(elem);
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
