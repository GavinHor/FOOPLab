package lab1;

class LinkedList implements List {
    Node head;
    int len;

    public LinkedList() {
        head = null;
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
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        len++;
    }

    public int length() {
        return len;
    }
}
