package org.lab3.addMethods;

import org.lab3.common.IGenerateElement;
import org.lab3.common.IMethod;

import java.util.Collection;

/**
 * A class for measuring the performance of adding all elements of one collection to another collection.
 *
 * @param <C> The type of collection to which elements are being added.
 * @param <E> The type of collection from which elements are being added.
 * @param <B> The type of elements in both collections.
 */
public class AddAllToCollection<C extends Collection<B>, E extends Collection<B>, B> implements IMethod<E> {

    /**
     * The existing collection to which elements are being added.
     */
    C collection;
    /**
     * The function for generating elements.
     */
    IGenerateElement<E> generateElement;
    /**
     * Constructs an AddAllToCollection instance with the specified collection and element generator.
     *
     * @param collection      The existing collection.
     * @param generateElement The function for generating elements.
     */
    public AddAllToCollection(C collection, IGenerateElement<E> generateElement) {
        this.collection = collection;
        this.generateElement = generateElement;
    }

    /**
     * Adds all elements from the provided collection to the existing collection.
     *
     * @param elem The collection from which elements are to be added.
     */
    @Override
    public void apply(E elem) {
        collection.addAll(elem);
    }

    /**
     * Generates the collection of elements required by the method.
     *
     * @return The collection of elements required by the method.
     */
    @Override
    public E prepareToApply() {
        return generateElement.getElement();
    }
}
