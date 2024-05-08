package org.lab3.getMethods;

import org.lab3.common.IGenerateElement;
import org.lab3.common.IMethod;

import java.util.List;
public class GetRandElementList<T extends List<E>, E> extends GetElementList<T, E> implements IMethod<E> {

    public GetRandElementList(T list, IGenerateElement<E> generateElement) {
        super(list, generateElement);
    }
    /**
     * Sets index at random index between first and last element, which will be passed into get
     *
     * @return element that required by method
     */
    @Override
    public E prepareToApply() {
        ind = (int)(Math.random()*list.size());
        return generateElement.getElement();
    }
}
