package org.lab1;

public class Main {

    public static void main(String[] args) {
        System.out.println("Example of usage:");
        System.out.println("Creating new list:");
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i=0; i<10; i++)
            linkedList.add(i+10);
        System.out.println(linkedList);
        System.out.println("Removing 4th element from created list:");
        linkedList.delete(4);
        System.out.println(linkedList);
        System.out.println("Adding 7 as 2th element of created list:");
        linkedList.add(2, 7);
        System.out.println(linkedList);
        System.out.println("Creating new list:");
        LinkedList<Integer> linkedList1 = new LinkedList<>();
        for (int i=0; i<10; i++)
            linkedList1.add(i+20);
        System.out.println("Merging two lists, inserting second list starting from 2 position:");
        linkedList.add(2, linkedList1);
        System.out.println(linkedList);
        System.out.println("Comparing two lists:");
        System.out.println(linkedList.equals(linkedList1));
        System.out.println("Initializing new list by other existing list:");
        LinkedList<Integer> linkedList2= new LinkedList<>(linkedList);
        System.out.println(linkedList2);
    }
}
