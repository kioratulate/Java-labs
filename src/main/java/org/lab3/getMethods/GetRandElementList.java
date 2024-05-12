package org.lab3.getMethods;

import org.lab3.common.IGenerateElement;
import org.lab3.common.IMethod;

import java.util.List;
/**
 * A method to get a random element from a List.
 * @param <T> The implementation of List, for example ArrayList.
 * @param <E> The type of content in the list.
 */
public class GetRandElementList<T extends List<E>, E> extends GetElementList<T, E> implements IMethod<E> {
    /**
     * Constructs a GetRandElementList with the specified list and element generator.
     * @param list The existing list.
     * @param generateElement A function that generates elements specific to the method.
     */
    public GetRandElementList(T list, IGenerateElement<E> generateElement) {
        super(list, generateElement);
    }
    /**
     * Sets the index to a random index between the first and last element, which will be passed to the get method.
     * @return The element required by the method.
     */
    @Override
    public E prepareToApply() {
        ind = (int)(Math.random()*list.size());
        return generateElement.getElement();
    }
}
