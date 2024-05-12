package org.lab3.removeMethods;

import org.lab3.common.IGenerateElement;
import org.lab3.common.IMethod;

import java.util.List;

/**
 * An abstract class representing remove methods for List implementations.
 *
 * @param <T> The type of List implementation, such as ArrayList.
 * @param <E> The type of content in the list.
 */
public abstract class RemoveFromList<T extends List<E>, E> implements IMethod<E> {

    /**
     * The List being tested.
     */
    T list;
    /**
     * The index for the remove operation.
     */
    int ind;
    /**
     * The generator used to create elements.
     */
    IGenerateElement<E> generateElement;

    /**
     * Constructs a RemoveFromList object with the specified list and generator.
     *
     * @param list             The existing list.
     * @param generateElement  The function that generates elements specific to the method.
     */
    public RemoveFromList(T list, IGenerateElement<E> generateElement) {
        this.list = list;
        this.generateElement = generateElement;
    }

    /**
     * Applies the remove operation to the list.
     * @param elem The element to be removed.
     */
    @Override
    public void apply(E elem) {
           list.remove(ind);
    }

    /**
     * Prepares the index for the remove operation.
     *
     * @return The element required by the method.
     */
    @Override
    public abstract E prepareToApply();
}
