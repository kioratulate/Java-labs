package org.lab3.addMethods;

import org.lab3.common.IGenerateElement;

import java.util.List;

public class AddMiddleToList<T extends List<B>, B> extends AddToList<T,B> {


    public AddMiddleToList(T list, IGenerateElement<B> generateElement) {
        super(list, generateElement);
    }

    /**
     * Generates method specific content
     *
     * @return element that required by method
     */
    @Override
    public B prepareToApply() {
        ind = list.size()/2;
        return generateElement.getElement();
    }
}
