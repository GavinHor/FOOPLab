package lab2;

import java.util.Iterator;

public class IterableIntegerLists
{
    static void testList(IntegerList list)
    {
        list.append(10);
        list.append(20);
        System.out.println(list.contains(10));
        System.out.println(list.contains(20));
        System.out.println(list.contains(30));
        System.out.println(list.length());
        printList(list);
        printListBadly(list);
    }

    public static void printListBadly(IntegerList list) {
        if (list instanceof LinkedList linkedList) {
            Node current = linkedList.head;
            while (current != null) {
                System.out.println(current.value);
                current = current.next;
            }
        } else if (list instanceof ArrayList arrayList) {
            for (int i = 0; i < arrayList.len; i++) {
                System.out.println(arrayList.values[i]);
            }
        } else {
            throw new IllegalArgumentException(
                    "Unknown list implementation: " + list.getClass().getName());
        }
    }

    static void printList(IntegerList list) {
        for (Integer e : list)
        {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        testList(new LinkedList());
        testList(new ArrayList());
    }
}
////////////////////////////////////////////////
interface IntegerList extends Iterable<Integer> {
    boolean contains(int value);

    void append(int value);

    int length();
}
/////////////////////////////////////////////////
class Node {
    Node next = null;
    int value = 0;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}
//////////////////////////////////////////////////
class ArrayList implements IntegerList {
    int[] values;
    int len;

    public ArrayList() {
        values = new int[0];
        len = 0;
    }

    public boolean contains(int value) {
        for (int i = 0; i < len; i++) {
            if (value == values[i]) {
                return true;
            }
        }
        return false;
    }

    public void append(int value) {
        if (len == values.length) {
            int[] newValues = new int[(len * 2) + 1];
            for (int i = 0; i < len; i++) {
                newValues[i] = values[i];
            }
            newValues[len] = value;
            values = newValues;
        } else {
            values[len] = value;
        }
        len++;
    }

    public int length() {
        return len;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new ArrayList.ArrayListIterator(this);
    }

    private static class ArrayListIterator implements Iterator<Integer> {
        private ArrayList values;
        private int indexCurrent = 0;
        private int indexEnd;

        public ArrayListIterator(ArrayList list) {
            values = list;
            indexEnd = list.len;
        }

        @Override
        public boolean hasNext() {
            return indexCurrent < indexEnd;
        }

        @Override
        public Integer next() {
            int value = values.values[indexCurrent];
            indexCurrent++;
            return value;
        }
    }
}
/////////////////////////////////////////////////////////////////////
class LinkedList implements IntegerList {
    Node head;
    int len;
    Node tail;

    public LinkedList() {
        head = null;
        tail = null;
        len = 0;
    }

    public boolean contains(int value) {
        Node tempHead = head;
        while (tempHead != null) {
            if (tempHead.value == value) {
                return true;
            }
            tempHead = tempHead.next;
        }
        return false;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
        len++;
    }

    public int length() {
        return len;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new LinkedListIterator(this);
    }

    private static class LinkedListIterator implements Iterator<Integer> {
        private Node current;

        public LinkedListIterator(LinkedList list) {
            current = list.head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Integer next() {
            int value = current.value;
            current = current.next;
            return value;
        }
    }
}

