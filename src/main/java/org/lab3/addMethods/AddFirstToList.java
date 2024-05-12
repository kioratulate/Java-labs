package org.lab3.addMethods;

import org.lab3.common.IGenerateElement;

import java.util.List;

/**
 * A class for measuring the performance of adding an element first to a List.
 *
 * @param <T> The type of List.
 * @param <E> The type of elements in the List.
 */
public class AddFirstToList<T extends List<E>, E> extends AddToList<T, E> {
    /**
     * Constructs an AddFirstToList instance with the specified list and element generator.
     *
     * @param list              The existing list.
     * @param generateElement   The function for generating elements.
     */
    public AddFirstToList(T list, IGenerateElement<E> generateElement) {
        super(list, generateElement);
    }
    /**
     * Generates the element required by the method and prepares to add it to the beginning of the List.
     *
     * @return The element required by the method.
     */
    @Override
    public E prepareToApply() {
        ind = 0; // Adding the element at the beginning of the List
        return generateElement.getElement();
    }
}
