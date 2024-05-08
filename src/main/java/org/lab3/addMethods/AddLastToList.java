package org.lab3.addMethods;

import org.lab3.common.IGenerateElement;

import java.util.List;

public class AddLastToList<T extends List<E>, E> extends AddToList<T, E> {
    public AddLastToList(T list, IGenerateElement<E> generateElement) {
        super(list, generateElement);
    }

    /**
     * Generates method specific content
     *
     * @return element that required by method
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
