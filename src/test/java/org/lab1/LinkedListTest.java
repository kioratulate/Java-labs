package org.lab1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    LinkedList<Integer> linkedList;
    @BeforeEach
    void setUp() {
        linkedList = new LinkedList<>();
    }
    @Test
    void emptyEmptyList() {
        assertTrue(linkedList.empty());
    }
    @Test
    void emptyNonEmptyList() {
        for (int i=0; i<10; i++)
            linkedList.add(i+10);
        assertFalse(linkedList.empty());
    }

    @Test
    void containsExisting() {
        linkedList.add(1);
        assertTrue(linkedList.contains(1));
    }
    @Test
    void containsNotExisting() {
        for (int i=0; i<10; i++)
            linkedList.add(i+10);
        assertFalse(linkedList.contains(1));
    }
    @Test
    void getIndexExisting() {
        for (int i=0; i<10; i++)
            linkedList.add(i+10);
        assertEquals(5, linkedList.getIndex(15));
    }
    @Test
    void getIndexNotExisting() {
        for (int i=0; i<10; i++)
            linkedList.add(i+10);
        assertEquals(-1, linkedList.getIndex(105));
    }
    @Test
    @DisplayName("When given element then adds to tail")
    void addElementToTail() {
        for (int i=0; i<10; i++)
            linkedList.add(i+10);
        linkedList.add(1);
        assertTrue(linkedList.contains(1)&&linkedList.getSize()==11&&linkedList.get(11).equals(1));
    }

    @Test
    @DisplayName("When given index and element then adds ")
    void addElementByIndex() {
        for (int i=0; i<10; i++)
            linkedList.add(i+10);
        linkedList.add(2,7);
        assertEquals(7, linkedList.get(2));
    }

    @Test
    void addListToTail() {
        int old_size=10;
        for (int i=0; i<old_size; i++)
            linkedList.add(i+10);
        LinkedList<Integer> linkedList1 = new LinkedList<>();
        for (int i=15; i<20; i++)
            linkedList1.add(i+10);
        linkedList.add(linkedList1);

        boolean contains = true;
        for (int i=1; i<= linkedList1.getSize()&&contains; i++) {
            contains = linkedList.getIndex(linkedList1.get(i)) == old_size-1 + i;
        }
        assertTrue(contains);
    }

    @Test
    void addListByIndex() {
        int old_size=10;
        for (int i=0; i<old_size; i++)
            linkedList.add(i+10);
        LinkedList<Integer> linkedList1 = new LinkedList<>();
        for (int i=15; i<20; i++)
            linkedList1.add(i+10);
        int position = 3;
        linkedList.add(position, linkedList1);

        boolean contains = true;
        for (int i=1; i<= linkedList1.getSize()&&contains; i++) {
            contains = linkedList.getIndex(linkedList1.get(i)) == position-1 + i;
        }
    }

    @Test
    void deleteByIndex() {
        int old_size=10;
        for (int i=0; i<old_size; i++)
            linkedList.add(i+10);
        var prevElem = linkedList.get(2);
        var elem = linkedList.get(3);
        var nextElem = linkedList.get(4);
        linkedList.delete(3);
        assertTrue(linkedList.getSize()==old_size-1&& !linkedList.contains(elem)&&linkedList.contains(prevElem)&&linkedList.contains(nextElem));
    }

    @Test
    void deleteByValueExisting() {
        int old_size=10;
        for (int i=0; i<old_size; i++)
            linkedList.add(i+10);
        var prevElem = linkedList.get(2);
        var elem = linkedList.get(3);

        var nextElem = linkedList.get(4);
        linkedList.delete(elem);
        assertTrue(linkedList.getSize()==old_size-1&& !linkedList.contains(elem)&&linkedList.contains(prevElem)&&linkedList.contains(nextElem));
    }
    @Test
    void deleteByValueNotExisting() {
        int old_size=10;
        for (int i=0; i<old_size; i++)
            linkedList.add(i+10);
        Integer elem = 105;
        linkedList.delete(elem);
        assertEquals(old_size, linkedList.getSize());
    }

    @Test
    void getByIndex() {
        int old_size=10;
        for (int i=0; i<old_size; i++)
            linkedList.add(i+10);
        assertEquals(11, linkedList.get(2));
    }

    @Test
    void getSize() {
        int size=10;
        for (int i=0; i<size; i++)
            linkedList.add(i+10);
        assertEquals(size, linkedList.getSize());
    }



}