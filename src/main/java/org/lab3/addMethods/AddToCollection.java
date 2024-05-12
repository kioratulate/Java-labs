package org.lab3.addMethods;



import org.lab3.common.IGenerateElement;
import org.lab3.common.IMethod;

import java.util.Collection;
public class AddToCollection<C extends Collection<E>, E> implements IMethod<E> {
    C collection;
    IGenerateElement<E> generateElement;

    /**
     * Constructs an AddToCollection instance with the specified collection and element generator.
     *
     * @param collection       The existing collection.
     * @param generateElement  A function that creates elements specific to the method.
     */
    public AddToCollection(C collection, IGenerateElement<E> generateElement) {
        this.collection = collection;
        this.generateElement = generateElement;
    }
    /**
     * Applies the method to add an element to the collection.
     *
     * @param elem  The element to be added to the collection.
     */
    @Override
    public void apply(E elem) {
        collection.add(elem);
    }

    /**
     * Generates an element specific to the method.
     *
     * @return The element required by the method.
     */
    @Override
    public E prepareToApply() {
        return generateElement.getElement();
    }
}
