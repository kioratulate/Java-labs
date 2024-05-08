package org.lab3.addMethods;

import org.lab3.common.IGenerateElement;
import org.lab3.common.IMethod;

import java.util.List;

public abstract class AddToList<T extends List<E>, E> implements IMethod<E> {

    T list;
    int ind;
    /**
     * Generates index where to add element
     */
    IGenerateElement<E> generateElement;

    public AddToList(T list, IGenerateElement<E> generateElement) {
        this.list = list;
        this.generateElement = generateElement;
    }

    /**
     * Method to be tested
     * WARNING! Inside this method should not be any unnecessary operations,
     * or performance measurement won't be correct
     *
     * @param elem element that needs to be provided
     */
    @Override
    public void apply(E elem) {
        list.add(ind, elem);
    }

    /**
     * Generates method specific content
     *
     * @return element that required by method
     */
    @Override
    public abstract E prepareToApply();
}
