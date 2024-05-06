package org.lab3;

import java.util.ArrayList;

public class TestAddArrayList<T> implements TestMethod<T>{
    ArrayList<T> arrayList;
    GetElement<T> getElement;
    /**
     * Initializing testMethod by existing ArrayList
     * @param arrayList existing ArrayList
     */
    public TestAddArrayList(ArrayList<T> arrayList, GetElement<T> getElement) {

        this.arrayList = arrayList;
        this.getElement = getElement;
    }
    public TestAddArrayList(GetElement<T> getElement) {

        this.arrayList = new ArrayList<>();
        this.getElement = getElement;
    }
    /**
     * Method to be tested
     * WARNING! Inside this method should not be any unnecessary operations,
     * or performance measurement won't be correct
     * @param elem element that needs to be provided, if your method not requires any elements leave void
     */
    @Override
    public void apply(T elem) {
        arrayList.add(elem);
    }

    /**
     * Generates element that will be added to ArrayList
     * @return element that required by method or void if method requires no elements
     */
    @Override
    public T getContent() {
        return getElement.getElement(new ArrayList<>());
    }

    @Override
    public String toString() {
        return "ArrayList Add";
    }
}
