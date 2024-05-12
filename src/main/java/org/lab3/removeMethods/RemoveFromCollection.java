package org.lab3.removeMethods;

import org.lab3.common.IGenerateElement;
import org.lab3.common.IMethod;

import java.util.Collection;

/**
 * A method to remove an element from a collection.
 * @param <C> The implementation of the collection, for example ArrayList.
 * @param <E> The type of content in the collection.
 */
public class RemoveFromCollection<C extends Collection<E>, E> implements IMethod<E> {
    /** The collection to be tested. */
    C collection;
    /** The generator for elements. */
    IGenerateElement<E> generateElement;

    /**
     * Constructs a RemoveFromCollection with the specified generateElement and existing collection.
     * @param collection The existing collection.
     * @param generateElement A function that creates elements specific to the method.
     */
    public RemoveFromCollection(C collection, IGenerateElement<E> generateElement) {
        this.collection = collection;
        this.generateElement = generateElement;
    }


    /**
     * Method to be tested.
     * @param elem The element to be removed.
     */
    @Override
    public void apply(E elem) {
        collection.remove(elem);
    }

    /**
     * Generates method specific content.
     * @return The element required by the method.
     */
    @Override
    public E prepareToApply() {
        return generateElement.getElement();
    }
}
