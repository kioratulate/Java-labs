package org.lab3.getMethods;

import org.lab3.common.IGenerateElement;

import java.util.List;

/**
 * A method to get the middle element of a List.
 * @param <T> The implementation of List, for example ArrayList.
 * @param <E> The type of content in the list.
 */
public class GetMiddleElementList<T extends List<E>, E> extends GetElementList<T, E> {
    /**
     * Constructs a GetMiddleElementList with the specified list and element generator.
     * @param list The existing list.
     * @param generateElement A function that generates elements specific to the method.
     */
    public GetMiddleElementList(T list, IGenerateElement<E> generateElement) {
        super(list, generateElement);
    }

    /**
     * Sets the index to the middle, which will be passed to the get method.
     * @return The element required by the method.
     */
    @Override
    public E prepareToApply() {
        ind = list.size()/2;
        return generateElement.getElement();
    }
}
