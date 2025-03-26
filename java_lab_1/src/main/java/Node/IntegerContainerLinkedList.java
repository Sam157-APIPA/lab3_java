package Node;

/**
 * Represents a node in a singly linked list.
 */
class Node {
    /**
     * The data stored in this node.
     */
    int data;
    /**
     * A reference to the next node in the list.  Null if this is the last node.
     */
    Node next;

    /**
     * Constructs a new Node with the specified data.
     *
     * @param d The data to be stored in the node.
     */
    Node(int d) {
        data = d;
        next = null;
    }
}

/**
 *  A container class that stores integers using a singly linked list.  This class
 *  provides methods for adding, retrieving, and removing elements.
 *  It is intended to be a basic implementation without using Java's built-in collections.
 */
public class IntegerContainerLinkedList {
    /**
     * The head of the linked list.  This is the first node in the list.  It is null
     * if the list is empty.
     */
    Node head;
    /**
     * The number of elements currently stored in the list.
     */
    int size;

    /**
     * Constructs an empty IntegerContainerLinkedList.  The head is initialized to null,
     * and the size is initialized to 0.
     */
    public IntegerContainerLinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Adds a new integer value to the beginning of the list.
     *
     * @param value The integer value to be added.
     */
    public void add(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * Retrieves the integer value at the specified index in the list.
     *
     * @param index The index of the element to retrieve (0-based).
     * @return The integer value at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of range
     *         ({@code index < 0 || index >= size()}).
     */
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

    /**
     * Removes the integer value at the specified index in the list.
     *
     * @param index The index of the element to remove (0-based).
     * @return The integer value that was removed.
     * @throws IndexOutOfBoundsException if the index is out of range
     *         ({@code index < 0 || index >= size()}).
     */
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

    /**
     * Returns the number of elements in the list.
     *
     * @return The number of elements currently stored in the list.
     */
    public int size() {
        return size;
    }

}

