package org.lab1;

/**
 * LinkedList represents a generic container organized by nodes, capable of holding elements of the same type.
 *
 * @author This class is authored by Pevtsova Angelina from the 61 group.
 *
 * @param <T> the type of elements contained in the LinkedList
 */
public class LinkedList<T> {

    /**
     * Represents the head node of the LinkedList.
     */
    private Node<T> head;
    /**
     * Represents the tail node of the LinkedList.
     */
    private Node<T> tail;

    /**
     * Represents the size of the LinkedList.
     */
    private int size;


    /**
     * Constructs an empty LinkedList with default values (head and tail set to null, size set to 0).
     */
    public LinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Constructs a LinkedList by copying the elements from another LinkedList.
     *
     * @param list the source LinkedList for initialization
     */
    public LinkedList(LinkedList<T> list)
    {
        head = null;
        tail = null;
        size = 0;
        this.add(list);
    }

    /**
     * Checks if the LinkedList is empty.
     *
     * @return true if the LinkedList is empty, false otherwise
     */
    public boolean empty()
    {
        return head==null;
    }

    /**
     * Adds an element to the tail of the LinkedList.
     *
     * @param data the element to be added
     */
    public void add(T data){
        Node<T> newNode = new Node<>(data);
        if(head==null)
         head=newNode;
        else
            tail.next=newNode;

        tail=newNode;
        this.size+=1;
    }

    /**
     * Adds an element to the LinkedList at the specified index.
     *
     * @param index the position at which the element should be added
     * @param data the element to be added
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public void add(int index, T data) throws IndexOutOfBoundsException {
        if (index>size+1)
            throw new IndexOutOfBoundsException("Index out of bounds");
        Node<T> newNode = new Node<>(data);
        if(head==null)
            head=newNode;
        else {
            Node<T> current = head;
            Node<T> previous = null;

            for (int ind = 0; ind < index-1; ind += 1) {
                previous = current;
                current = current.next;
            }

            if (previous!=null) previous.next = newNode;
            newNode.next = current;
        }
        size+=1;
    }

    /**
     * Adds all elements from a given LinkedList to the tail of this LinkedList.
     *
     * @param list the LinkedList whose elements are to be added
     */
    public void add(LinkedList<T> list)
    {
        Node<T> current = list.head;
        while(current!=null) {
            this.add(current.data);
            current = current.next;
        }
    }
    /**
     * Adds all elements from a given LinkedList to this LinkedList at the specified index.
     *
     * @param index the position at which the elements should be added
     * @param list the LinkedList whose elements are to be added
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public void add(int index, LinkedList<T> list)
    {
        if (index>size+1)
            throw new IndexOutOfBoundsException("Index out of bounds");

        Node<T> current = head;
        int ind = 0;
        for (;ind<index-1; ind+=1)
        {
            current = current.next;
        }

        Node<T> newCurrent = list.head;
        while(newCurrent!=null) {
            this.add(ind, newCurrent.data);
            ind+=1;
            newCurrent=newCurrent.next;
        }
    }

    /**
     * Deletes the element at the specified index from the LinkedList.
     *
     * @param index the index of the element to be deleted
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public void delete(int index) throws IndexOutOfBoundsException {
        if (index>size+1)
            throw new IndexOutOfBoundsException("Index out of bounds");

        Node<T> current = head;
        Node<T> previous = null;
        int ind =0;

        while(current != null){
            if (ind == index-1 ){
                if (previous == null){
                    head = current.next;
                } else {
                    previous.next=current.next;
                }
                break;
            }
            previous=current;
            current = current.next;
            ind +=1;
        }
        size-=1;
    }

    /**
     * Deletes the first occurrence of the specified element from the LinkedList.
     *
     * @param deletingData the element to be deleted
     */
    public void delete(T deletingData)
    {
        Node<T> current = head;
        Node<T> previous = null;
        boolean found = false;
        while(current != null){
            if (current.data.equals(deletingData)){
                found = true;
                if (previous == null){
                    head = current.next;
                } else {
                    previous.next=current.next;
                }
                break;
            }
            previous=current;
            current = current.next;
        }
        if (found)
            size-=1;
    }

    /**
     * Retrieves the element at the specified index from the LinkedList.
     *
     * @param index the index of the element to be retrieved
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public T get(int index) throws IndexOutOfBoundsException
    {
        Node<T> current = head;
        int ind = 0;

        while (current != null) {
            if (ind == index - 1) {
                return current.data;
            }
            ind += 1;
            current = current.next;
        }
        throw new IndexOutOfBoundsException("Index out of bounds");
    }

    /**
     * Checks if the LinkedList contains the specified element.
     *
     * @param data the element to be checked for existence
     * @return true if the element is found, false otherwise
     */
    public boolean contains(T data)
    {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Retrieves the index of the first occurrence of the specified element in the LinkedList.
     *
     * @param data the element to be searched for
     * @return the index of the first occurrence of the element, or -1 if not found
     */
    public int getIndex(T data)
    {
        Node<T> current = head;
        int ind = 0;

        while (current != null) {
            if (current.data.equals(data)) {
                return ind;
            }
            ind += 1;
            current = current.next;
        }
        return -1;
    }
    @Override
    public String toString() {
        Node<T> current = head;
        StringBuilder result = new StringBuilder("Linked list(size: " + this.size + "):\n");
        while(current != null)
        {
            result.append(current.data);
            if (current.next!=null)
                result.append(", ");
            current = current.next;
        }
        result.append(".");
        return  result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LinkedList<?> that)) return false;
        if (((LinkedList<?>) o).head.getClass()!=this.head.getClass()) return false;

        Node<T> current = this.head;
        Node<?> current_o = ((LinkedList<?>) o).head;
        boolean equal = true;
        while(current!=null && equal) {
            equal = current.data == current_o.data;
            if (equal)
            {
                current = current.next;
                current_o = current_o.next;
            }
        }
        return equal;
    }

    /**
     * Returns current size of list.
     * @return size of list
     */
    public int getSize() {
        return size;
    }
}
