package org.lab1;

import java.util.Objects;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    public LinkedList(LinkedList list)
    {
        this.add(list);
    }
    public void add(int data){
        Node newNode = new Node(data);
        if(head==null)
         head=newNode;
        else
            tail.next=newNode;

        tail=newNode;
        this.size+=1;
    }

    public void add(int index, int data){
        if (index>size+1)
            throw new IndexOutOfBoundsException("Index out of bounds");

        Node newNode = new Node(data);
        Node current = head;
        //Node previous = null;

        for (int ind = 0; ind<index; ind+=1)
        {
         //       previous = current;
                current = current.next;
        }
        current.next=newNode;
        current = newNode;
    }

    public void add(LinkedList list)
    {
        Node current = list.head;
        while(current!=null) {
            this.add(current.data);
            current = current.next;
        }
    }

    public void add(int index, LinkedList list)
    {
        if (index>size+1)
            throw new IndexOutOfBoundsException("Index out of bounds");

        Node current = head;
      //  Node previous = null;
        int ind = 0;
        for (;ind<index; ind+=1)
        {
   //         previous = current;
            current = current.next;
        }

        Node newCurrent = list.head;
        while(newCurrent!=null) {
            this.add(ind, newCurrent.data);
            ind+=1;
            newCurrent=newCurrent.next;
        }
    }

    public void delete(int index){
        if (index>size+1)
            throw new IndexOutOfBoundsException("Index out of bounds");

        Node current = head;
        Node previous = null;
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
    }
    public int get(int index)
    {
        Node current = head;
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

    @Override
    public String toString() {
        Node current = head;
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
        if (!(o instanceof LinkedList that)) return false;
        if (this.size!=((LinkedList) o).size) return false;

        boolean equal=true;
        Node current = this.head;
        Node current_o = ((LinkedList) o).head;
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
    public int getSize() {
        return size;
    }
}
