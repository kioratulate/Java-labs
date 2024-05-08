package org.lab3.removeMethods;

import org.lab3.common.IGenerateElement;
import org.lab3.common.IMethod;

import java.util.Collection;

public class RemoveFromCollection<C extends Collection<E>, E> implements IMethod<E> {
    C collection;
    IGenerateElement<E> generateElement;

    public RemoveFromCollection(C collection, IGenerateElement<E> generateElement) {
        this.collection = collection;
        this.generateElement = generateElement;
    }


    /**
     * Method to be tested
     * WARNING! Inside this method should not be any unnecessary operations,
     * or performance measurement won't be correct
     *
     * @param elem element that needs to be provided
     */
    @Override
    public void apply(E elem) {
        collection.remove(elem);
    }

    /**
     * Generates method specific content
     *
     * @return element that required by method
     */
    @Override
    public E prepareToApply() {
        return generateElement.getElement();
    }
}
