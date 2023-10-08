package lab2;

import java.util.Iterator;

public class IterableGenericLists
{
    static void testList(GenericList<String> list)
    {
        for(int i = 0; i < 20; i++)
        {
            String value = "String" + i;
            if(i == 3)
            {
                continue;
            }
            list.append(value);
        }
        System.out.println(list.contains("String1")); //false
        System.out.println(list.contains("String3")); //false
        System.out.println(list.contains("String3")); //false
        System.out.println(list.length());
/*        for(int j: list)
        {
            System.out.println(j);
        }*/
    }

    public static void main(String[] args) {
        testList(new GenericArrayList<String>());
        testList(new GenericLinkedList<String>());
    }

}
///////////////////////////////////
interface GenericList<T> extends Iterable<T> {
    boolean contains(T value);

    void append(T value);

    int length();
}
/////////////////////////////////////
class GenericNode<T> {
    GenericNode<T> next = null;
    T value = null;

    public GenericNode(T value) {
        this.value = value;
        this.next = null;
    }
}
/////////////////////////////////////
class GenericLinkedList<T> implements GenericList<T> {
    GenericNode<T> head;
    GenericNode<T> tail;
    int len;

    public GenericLinkedList() {
        head = null;
        tail = null;
        len = 0;
    }

    public boolean contains(T value) {
        GenericNode<T> current = head;
        while (current != null) {
            if(current.value == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void append(T value) {
        GenericNode<T> newNode = new GenericNode<T>(value);
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
    public Iterator<T> iterator() {
        return new GenericLinkedListIterator<T>(this);
    }

    private static class GenericLinkedListIterator<T> implements Iterator<T> {
        private GenericNode<T> current;

        public GenericLinkedListIterator(GenericLinkedList<T> list) {
            current = list.head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T value = current.value;
            current = current.next;
            return value;
        }
    }
}
/////////////////////////////////////////////////
class GenericArrayList<T> implements GenericList<T> {
    static int initialCapacity = 10;

    T[] values = (T[]) new Object[initialCapacity];
    int len = 0;

    public boolean contains(T value) {
        for (int i = 0; i < len; i++) {
            if (value == values[i]) {
                return true;
            }
        }
        return false;
    }

    public void append(T value) {
        if (len == values.length) {
            T[] newValues = (T[]) new Object[(len * 2) + 1];
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
    public Iterator<T> iterator() {
        return new GenericArrayListIterator<T>(this);
    }

    private static class GenericArrayListIterator<T> implements Iterator<T> {
        private GenericArrayList<T> values;
        private int indexCurrent = 0;
        private int indexEnd;

        public GenericArrayListIterator(GenericArrayList list) {
            values = list;
            indexEnd = list.len;
        }

        @Override
        public boolean hasNext() {
            return indexCurrent < indexEnd;
        }

        @Override
        public T next() {
            T value = values.values[indexCurrent];
            indexCurrent++;
            return value;
        }
    }
}