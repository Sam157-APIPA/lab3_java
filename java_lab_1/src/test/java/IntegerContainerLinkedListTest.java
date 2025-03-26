import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Node.IntegerContainerLinkedList;

public class IntegerContainerLinkedListTest {

    @Test
    void testAddAndGet() {
        IntegerContainerLinkedList list = new IntegerContainerLinkedList();
        list.add(10);
        list.add(20);
        list.add(30);

        assertEquals(30, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(10, list.get(2));
        assertEquals(3, list.size());
    }

    @Test
    void testAddAndSize() {
        IntegerContainerLinkedList list = new IntegerContainerLinkedList();
        assertEquals(0, list.size());

        list.add(10);
        assertEquals(1, list.size());

        list.add(20);
        assertEquals(2, list.size());

        list.add(30);
        assertEquals(3, list.size());
    }

    @Test
    void testRemove() {
        IntegerContainerLinkedList list = new IntegerContainerLinkedList();
        list.add(10);
        list.add(20);
        list.add(30);

        assertEquals(30, list.remove(0));
        assertEquals(2, list.size());
        assertEquals(20, list.get(0));
        assertEquals(10, list.get(1));

        assertEquals(10, list.remove(1));
        assertEquals(1, list.size());
        assertEquals(20, list.get(0));

        assertEquals(20, list.remove(0));
        assertEquals(0, list.size());

    }

    @Test
    void testRemoveFromEmptyList() {
        IntegerContainerLinkedList list = new IntegerContainerLinkedList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }

    @Test
    void testGetFromEmptyList() {
        IntegerContainerLinkedList list = new IntegerContainerLinkedList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }


    @Test
    void testRemoveIndexOutOfBounds() {
        IntegerContainerLinkedList list = new IntegerContainerLinkedList();
        list.add(10);
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
    }

    @Test
    void testGetIndexOutOfBounds() {
        IntegerContainerLinkedList list = new IntegerContainerLinkedList();
        list.add(10);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
    }

    @Test
    void testAddManyAndCheckSize() {
        IntegerContainerLinkedList list = new IntegerContainerLinkedList();
        int numElements = 1000;

        for (int i = 0; i < numElements; i++) {
            list.add(i);
        }

        assertEquals(numElements, list.size());
        for(int i = 0; i < numElements; i++){
            assertEquals(numElements - 1 -i, list.get(i));
        }
    }
}
