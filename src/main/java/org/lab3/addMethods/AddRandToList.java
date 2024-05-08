package org.lab3.addMethods;

import org.lab3.common.IGenerateElement;

import java.util.List;

public class AddRandToList<T extends List<E>, E> extends AddToList<T, E> {
    public AddRandToList(T list, IGenerateElement<E> generateElement) {
        super(list, generateElement);
    }

    /**
     * Generates method specific content
     *
     * @return element that required by method
     */
    @Override
    public E prepareToApply() {
        ind = (int)(Math.random()*list.size());
        return generateElement.getElement();
    }
}
