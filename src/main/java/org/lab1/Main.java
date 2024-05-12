package org.lab1;

/**
 * Example of usage of LinkedList
 */
public class Main {
    /**
     * Main method to demonstrate the usage of LinkedList.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        System.out.println("Example of usage:");
        System.out.println("Creating new list:");

        // Creating a new instance of LinkedList
        LinkedList<Integer> linkedList = new LinkedList<>();

        // Adding elements to the list
        for (int i=0; i<10; i++)
            linkedList.add(i+10);
        // Printing the contents of the list
        System.out.println(linkedList);

        // Removing the 4th element from the list
        System.out.println("Removing 4th element from created list:");
        linkedList.delete(4);
        System.out.println(linkedList);

        // Adding 7 as the 2nd element of the list
        System.out.println("Adding 7 as 2th element of created list:");
        linkedList.add(2, 7);
        System.out.println(linkedList);

        // Creating a new list
        System.out.println("Creating new list:");
        LinkedList<Integer> linkedList1 = new LinkedList<>();
        for (int i=0; i<10; i++)
            linkedList1.add(i+20);

        // Merging two lists, inserting the second list starting from the 2nd position
        System.out.println("Merging two lists, inserting second list starting from 2 position:");
        linkedList.add(2, linkedList1);
        System.out.println(linkedList);

        // Comparing two lists
        System.out.println("Comparing two lists:");
        System.out.println(linkedList.equals(linkedList1));

        // Initializing a new list by copying an existing list
        System.out.println("Initializing new list by other existing list:");
        LinkedList<Integer> linkedList2= new LinkedList<>(linkedList);
        System.out.println(linkedList2);
    }
}
