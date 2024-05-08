package org.lab3.getMethods;

import org.lab3.common.IGenerateElement;

import java.util.List;

public class GetLastElementList<T extends List<E>, E> extends GetElementList<T, E> {
    public GetLastElementList(T list, IGenerateElement<E> generateElement) {
        super(list, generateElement);
    }

    /**
     * Sets index at the last element, which will be passed into get
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