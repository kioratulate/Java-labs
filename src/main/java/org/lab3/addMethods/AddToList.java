package org.lab3.addMethods;

import org.lab3.common.IGenerateElement;
import org.lab3.common.IMethod;

import java.util.List;

/**
 * An abstract class for adding an element to a List.
 *
 * @param <T> The type of List.
 * @param <E> The type of elements in the List.
 */
public abstract class AddToList<T extends List<E>, E> implements IMethod<E> {
    /** The List to which elements are added. */
    T list;
    /** The index where the element is added. */
    int ind;
    /** Generates the element to be added. */
    IGenerateElement<E> generateElement;

    /**
     * Constructs an AddToList instance with the specified list and element generator.
     *
     * @param list              The existing list.
     * @param generateElement   The function for generating elements.
     */
    public AddToList(T list, IGenerateElement<E> generateElement) {
        this.list = list;
        this.generateElement = generateElement;
    }

    /**
     * Applies the method to add an element to the List.
     *
     * @param elem  The element to be added to the List.
     */
    @Override
    public void apply(E elem) {
        list.add(ind, elem);
    }

    /**
     * Generates an element specific to the method.
     *
     * @return The element required by the method.
     */
    @Override
    public abstract E prepareToApply();
}
