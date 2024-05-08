package org.lab3.removeMethods;

import org.lab3.common.IGenerateElement;

import java.util.List;

public class RemoveLastFromList<T extends List<E>, E> extends RemoveFromList<T, E> {
    public RemoveLastFromList(T list, IGenerateElement<E> generateElement) {
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
