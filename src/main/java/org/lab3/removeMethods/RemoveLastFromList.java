package org.lab3.removeMethods;

import org.lab3.common.IGenerateElement;

import java.util.List;

/**
 * Removes the last element from a List.
 *
 * @param <T> The implementation of List, for example, ArrayList.
 * @param <E> The type of content in the list.
 */
public class RemoveLastFromList<T extends List<E>, E> extends RemoveFromList<T, E> {
    /**
     * Constructs a RemoveLastFromList object with the specified list and generator.
     *
     * @param list             The existing list.
     * @param generateElement  The function that generates elements specific to the method.
     */
    public RemoveLastFromList(T list, IGenerateElement<E> generateElement) {
        super(list, generateElement);
    }

    /**
     * Prepares the index for the remove operation.
     * If the list is empty, sets the index to 0; otherwise, sets it to the index of the last element.
     *
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
