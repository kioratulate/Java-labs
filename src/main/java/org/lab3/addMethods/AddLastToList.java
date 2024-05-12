package org.lab3.addMethods;

import org.lab3.common.IGenerateElement;

import java.util.List;

/**
 * A class for measuring the performance of adding an element last to a List.
 *
 * @param <T> The type of List.
 * @param <E> The type of elements in the List.
 */
public class AddLastToList<T extends List<E>, E> extends AddToList<T, E> {
    /**
     * Constructs an AddLastToList instance with the specified list and element generator.
     *
     * @param list              The existing list.
     * @param generateElement   The function for generating elements.
     */
    public AddLastToList(T list, IGenerateElement<E> generateElement) {
        super(list, generateElement);
    }

    /**
     * Generates the element required by the method and prepares to add it to the end of the List.
     *
     * @return The element required by the method.
     */
    @Override
    public E prepareToApply() {
        if (list.isEmpty()) // If the list is empty, add the element at index 0
            ind = 0;
        else
            ind = list.size()-1; // If the list is not empty, add the element at the last index
        return generateElement.getElement();
    }
}
