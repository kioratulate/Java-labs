package org.lab3.removeMethods;

import org.lab3.common.IGenerateElement;

import java.util.List;
/**
 * Removes the middle element from a List.
 *
 * @param <T> The implementation of List, for example, ArrayList.
 * @param <E> The type of content in the list.
 */
public class RemoveMiddleFromList<T extends List<E>, E> extends RemoveFromList<T, E> {
    /**
     * Constructs a RemoveMiddleFromList object with the specified list and generator.
     *
     * @param list             The existing list.
     * @param generateElement  The function that generates elements specific to the method.
     */
    public RemoveMiddleFromList(T list, IGenerateElement<E> generateElement) {
        super(list, generateElement);
    }

    /**
     * Prepares the index for the remove operation by setting it to the middle index of the list.
     *
     * @return The element required by the method.
     */
    @Override
    public E prepareToApply() {
        ind = list.size()/2;
        return generateElement.getElement();
    }
}
