package org.lab3.addMethods;

import org.lab3.common.IGenerateElement;

import java.util.List;

/**
 * A class for measuring the performance of adding an element in the middle of a List.
 *
 * @param <T> The type of List.
 * @param <B> The type of elements in the List.
 */
public class AddMiddleToList<T extends List<B>, B> extends AddToList<T,B> {

    /**
     * Constructs an AddMiddleToList instance with the specified list and element generator.
     *
     * @param list              The existing list.
     * @param generateElement   The function for generating elements.
     */
    public AddMiddleToList(T list, IGenerateElement<B> generateElement) {
        super(list, generateElement);
    }

    /**
     * Generates the element required by the method and prepares to add it to the middle of the List.
     *
     * @return The element required by the method.
     */
    @Override
    public B prepareToApply() {
        ind = list.size()/2; // Calculate the index to insert the element in the middle
        return generateElement.getElement();
    }
}
