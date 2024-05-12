package org.lab3.addMethods;

import org.lab3.common.IGenerateElement;

import java.util.List;

/**
 * A class for measuring the performance of adding an element at a random position in a List.
 *
 * @param <T> The type of List.
 * @param <E> The type of elements in the List.
 */
public class AddRandToList<T extends List<E>, E> extends AddToList<T, E> {
    /**
     * Constructs an AddRandToList instance with the specified list and element generator.
     *
     * @param list              The existing list.
     * @param generateElement   The function for generating elements.
     */
    public AddRandToList(T list, IGenerateElement<E> generateElement) {
        super(list, generateElement);
    }

    /**
     * Generates the element required by the method and prepares to add it at a random position in the List.
     *
     * @return The element required by the method.
     */
    @Override
    public E prepareToApply() {
        ind = (int)(Math.random()*list.size());// Calculate a random index to insert the element
        return generateElement.getElement();
    }
}
