package org.lab3.removeMethods;

import org.lab3.common.IGenerateElement;

import java.util.List;

public class RemoveRandFromList<T extends List<E>, E> extends RemoveFromList<T, E> {
    public RemoveRandFromList(T list, IGenerateElement<E> generateElement) {
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
