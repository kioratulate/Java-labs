package org.lab3.getMethods;

import org.lab3.common.IGenerateElement;

import java.util.List;

/**
 * A method to get the last element of a List.
 * @param <T> The implementation of List, for example ArrayList.
 * @param <E> The type of content in the list.
 */
public class GetLastElementList<T extends List<E>, E> extends GetElementList<T, E> {
    /**
     * Constructs a GetLastElementList with the specified list and element generator.
     * @param list The existing list.
     * @param generateElement A function that generates elements specific to the method.
     */
    public GetLastElementList(T list, IGenerateElement<E> generateElement) {
        super(list, generateElement);
    }

    /**
     * Sets the index to the last element, which will be passed to the get method.
     * If the list is empty, sets the index to 0.
     * @return The element required by the method.
     */
    @Override
    public E prepareToApply() {
        if (list.isEmpty())
            ind = 0;
        else
            ind = list.size()-1;
        return generateElement.getElement();
    }
}