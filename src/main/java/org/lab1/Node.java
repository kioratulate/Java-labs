package org.lab1;

import java.util.Objects;

/**
 * Node is the basic element of the LinkedList.
 * @param <T> the type of data contained by the node
 */
public class Node<T> {

    /**
     * Data contained by the node.
     */
    public T data;
    /**
     * Pointer to the next node.
     */
    public Node<T> next;

    /**
     * Constructs a new node with the specified data.
     * @param data the data to be contained by the new node
     */
    public Node(T data){
        this.data=data;
        this.next=null;
    }
    /**
     * Returns a string representation of the node's data.
     * @return a string representation of the node's data
     */
    @Override
    public String toString() {
        return data.toString();
    }
    /**
     * Indicates whether some other object is "equal to" this one comparing by data contained in node.
     * @param o the reference object with which to compare
     * @return true if this object is the same as the obj argument; false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node<?> node)) return false;
        return Objects.equals(data, node.data);
    }
}
