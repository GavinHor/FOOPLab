package lab1;

class EfficientLinkedList implements List {
    Node head;
    int len;
    Node tail;

    public EfficientLinkedList() {
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
}
