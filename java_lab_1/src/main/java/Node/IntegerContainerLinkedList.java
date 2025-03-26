package Node;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class IntegerContainerLinkedList {
    Node head;
    int size;

    public IntegerContainerLinkedList() {
        head = null;
        size = 0;
    }

    public void add(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        if (index == 0) {
            int removedValue = head.data;
            head = head.next;
            size--;
            return removedValue;
        }
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        int removedValue = current.next.data;
        current.next = current.next.next;
        size--;
        return removedValue;
    }

    public int size() {
        return size;
    }

}

