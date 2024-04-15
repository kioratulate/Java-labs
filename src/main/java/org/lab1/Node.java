package org.lab1;

import java.util.Objects;

/**
 * Node is the basic element of the LinkedList
 * @param <T> the type of data contained by node
 */
public class Node<T> {

    /**
     * Data contained by node
     */
    public T data;
    /**
     * Pointer to a next node
     */
    public Node<T> next;

    /**
     * Constructor of node
     * @param data data that will be in new node
     */
    public Node(T data){
        this.data=data;
        this.next=null;
    }

    @Override
    public String toString() {
        return data.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node<?> node)) return false;
        return Objects.equals(data, node.data);
    }
}
