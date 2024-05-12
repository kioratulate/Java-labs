package org.lab3.removeMethods;

import org.lab3.common.IGenerateElement;
import java.util.List;

/**
 * A method to remove the first element from a List.
 * @param <T> The implementation of List, for example ArrayList.
 * @param <E> The type of content in the list.
 */
public class RemoveFirstFromList<T extends List<E>, E> extends RemoveFromList<T, E> {
    /**
     * Constructs a RemoveFirstFromList with the specified generateElement and existing list.
     * @param list The existing list.
     * @param generateElement A function that creates elements specific to the method.
     */
    public RemoveFirstFromList(T list, IGenerateElement<E> generateElement) {
        super(list, generateElement);
    }

    /**
     * Sets the index at 0, which will be passed into remove.
     * @return The element required by the method.
     */
    @Override
    public E prepareToApply() {
        ind = 0;
        return generateElement.getElement();
    }
}
