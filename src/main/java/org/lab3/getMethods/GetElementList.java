package org.lab3.getMethods;

import org.lab3.common.IGenerateElement;
import org.lab3.common.IMethod;

import java.util.List;

/**
 * Abstract class for retrieving elements from a List.
 */
public abstract class GetElementList<T extends List<E>, E> implements IMethod<E> {
    /**
     * The list being tested.
     */
    T list;
    /**
     * The index used for the get method.
     */
    int ind;
    /**
     * The generator used.
     */
    IGenerateElement<E> generateElement;

    /**
     * Constructs a GetElementList with the specified generator and existing list.
     * @param list The existing list.
     * @param generateElement A function that creates elements specific to the method.
     */
    public GetElementList(T list, IGenerateElement<E> generateElement) {
        this.list = list;
        this.generateElement = generateElement;
    }

    /**
     * The method to be tested.
     * @param elem The element that needs to be provided.
     */
    @Override
    public void apply(E elem) {
        elem = list.get(ind);
    }

    /**
     * Sets the index at which will be passed into get.
     * @return The element required by the method.
     */
    @Override
    public abstract E prepareToApply();
}
