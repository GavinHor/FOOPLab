package lab1;

interface List
{
    boolean contains (int value);
    void append(int value);
    int length();
}

class LinkedList implements List
{
    Node head;
    int len;

    public LinkedList()
    {
        head = null;
        len = 0;
    }

    public boolean contains(int value)
    {
        Node tempHead = head;
        while(tempHead != null)
        {
            if(tempHead.value == value)
            {
                return true;
            }
            tempHead = tempHead.next;
        }
        return false;
    }

    public void append(int value)
    {
        Node newNode = new Node(value);
        if (head == null)
        {
            head = newNode;
        }
        else
        {
            Node current = head;
            while(current.next != null)
            {
                current = current.next;
            }
            current.next = newNode;
        }
        len++;
    }

    public int length()
    {
        return len;
    }
}
// a Node for each element in LinkedList
class Node
{
    Node next = null;
    int value = 0;

    public Node(int value)
    {
        this.value = value;
        this.next = null;
    }
}
class ArrayList implements List
{
    int[] values;
    int len;

    public ArrayList()
    {
        values = new int[0];
        len = 0;
    }

    public boolean contains(int value)
    {
        for (int i = 0; i < len; i++) {
            if (value == values[i]) {
                return true;
            }
        }
        return false;
    }

        public void append(int value)
        {
            int[] newValues =  new int[len + 1];
            for(int i = 0; i < len; i++)
            {
                newValues[i] = values[i];
            }
            newValues[len] = value;
            values = newValues;
            len++;
        }

        public int length()
        {
            return len;
        }
}

class EfficientLinkedList implements List
{
    Node head;
    int len;
    Node tail;

    public EfficientLinkedList()
    {
        head = null;
        tail = null;
        len = 0;

    }

    public boolean contains(int value)
    {
        Node tempHead = head;
        while(tempHead != null)
        {
            if(tempHead.value == value)
            {
                return true;
            }
            tempHead = tempHead.next;
        }
        return false;
    }

    public void append(int value)
    {
        Node newNode = new Node(value);
        if (head == null)
        {
            head = newNode;
            tail = head;
        }
        else
        {
            tail.next = newNode;
            tail = tail.next;
        }
        len++;
    }

    public int length()
    {
        return len;
    }
}

class EfficientArrayList implements List
{
    int[] values;
    int len;

    public EfficientArrayList()
    {
        values = new int[0];
        len = 0;
    }

    public boolean contains(int value)
    {
        for (int i = 0; i < len; i++) {
            if (value == values[i]) {
                return true;
            }
        }
        return false;
    }

    public void append(int value)
    {
        if(len == values.length)
        {
            int[] newValues = new int[(len * 2) + 1];
            for(int i = 0; i < len; i++)
            {
                newValues[i] = values[i];
            }
            newValues[len] = value;
            values = newValues;
        }
        else
        {
            values[len] = value;
        }
        len++;
    }

    public int length()
    {
        return len;
    }
}

public class ListsExample {
    static void testList(List list)
    {
        list.append(10);
        list.append(20);

        System.out.println(list.contains(10));
        System.out.println(list.contains(20));
        System.out.println(list.contains(30));

        System.out.println(list.length());
    }

    public static void main(String[] args)
    {
        testList(new LinkedList());
        System.out.println();
        testList (new ArrayList());
    }
}