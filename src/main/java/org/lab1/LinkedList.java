package org.lab1;

/**
 * LinkedList is a container that can contain elements with the same type, organized by Nodes
 * @author Pevtsova Angelina 61 group
 * @param <T> the type LinkedList is containing
 */
public class LinkedList<T> {

    /**
     * Head of the list
     */
    private Node<T> head;
    /**
     * Tail of the list
     */
    private Node<T> tail;

    /**
     * Size of the list
     */
    private int size;


    /**
     * Constructor of LinkedList without parameters
     * Everything sets null, 0
     */
    public LinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     *  Constructor of LinkedList by other LinkedList
     * @param list source for initialization
     */
    public LinkedList(LinkedList<T> list)
    {
        head = null;
        tail = null;
        size = 0;
        this.add(list);
    }

    /**
     * Returns true if list doesn't contain any elements and false if it does
     * @return returns true if list is empty, false if it's not
     */
    public boolean empty()
    {
        return head==null;
    }

    /**
     * Adding one element to list to tail
     * @param data element that has to be added
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
     * Adding one element to list at specified position
     * @param index position element has to be added at
     * @param data element that has to be added
     */
    public void add(int index, T data){
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
     * Adding list of elements to list to tail
     * @param list list that has to be added
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
     * Adding list of elements to list at specified position
     * @param index position list has to be added at
     * @param list list that has to be added
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
     * Deleting element from list by index
     * @param index index of element that has to be deleted
     */
    public void delete(int index){
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
     * Deleting element from list by value
     * @param deletingData value of the element that has to be deleted
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
     * Get value of the element by index
     * @param index index of element
     * @return value of the element
     */
    public T get(int index)
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
     * Determines whether list contains element of not
     * @param data value of the element
     * @return true if element is found, false if not
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
     * Get index of element by value
     * @param data value of searched element
     * @return -1 if element is not found, else index of the found element
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
     * Returns current size of list
     * @return size of list
     */
    public int getSize() {
        return size;
    }
}
