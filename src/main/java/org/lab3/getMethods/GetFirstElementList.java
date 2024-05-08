package org.lab3.getMethods;

import org.lab3.common.IGenerateElement;

import java.util.List;

public class GetFirstElementList<T extends List<E>, E> extends GetElementList<T, E> {
    /**
     * Constructor with specified generateElement and existing list
     * @param list existing list
     * @param generateElement a function that creates specific to method elements
     */
    public GetFirstElementList(T list, IGenerateElement<E> generateElement) {
        super(list, generateElement);
    }

    /**
     * Sets index at 0, which will be passed into get
     *
     * @return element that required by method
     */
    @Override
    public E prepareToApply() {
        ind = 0;
        return generateElement.getElement();
    }
}
