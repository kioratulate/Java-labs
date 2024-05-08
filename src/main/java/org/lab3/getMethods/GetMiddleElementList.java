package org.lab3.getMethods;

import org.lab3.common.IGenerateElement;

import java.util.List;

public class GetMiddleElementList<T extends List<E>, E> extends GetElementList<T, E> {
    public GetMiddleElementList(T list, IGenerateElement<E> generateElement) {
        super(list, generateElement);
    }

    /**
     * Sets index at the middle, which will be passed into get
     *
     * @return element that required by method
     */
    @Override
    public E prepareToApply() {
        ind = list.size()/2;
        return generateElement.getElement();
    }
}
