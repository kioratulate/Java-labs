package org.lab3;

import java.util.ArrayList;

public class TestAddFirstArrayList<T> extends TestAddArrayList<T> {
    /**
     * Initializing testMethod by existing ArrayList
     *
     * @param arrayList  existing ArrayList
     * @param getElement
     */
    public TestAddFirstArrayList(ArrayList<T> arrayList, GetElement<T> getElement) {
        super(arrayList, getElement);
    }

    public TestAddFirstArrayList(GetElement<T> getElement) {
        super(getElement);
    }

    /**
     * Method to be tested
     * WARNING! Inside this method should not be any unnecessary operations,
     * or performance measurement won't be correct
     *
     * @param elem element that needs to be provided, if your method not requires any elements leave void
     */
    @Override
    public void apply(T elem) {
        arrayList.addFirst(elem);

    }
}
