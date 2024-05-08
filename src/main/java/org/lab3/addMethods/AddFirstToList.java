package org.lab3.addMethods;

import org.lab3.common.IGenerateElement;

import java.util.List;

public class AddFirstToList<T extends List<E>, E> extends AddToList<T, E> {
    public AddFirstToList(T list, IGenerateElement<E> generateElement) {
        super(list, generateElement);
    }
    /**
     * Generates method specific content
     *
     * @return element that required by method
     */
    @Override
    public E prepareToApply() {
        ind = 0;
        return generateElement.getElement();
    }
}
