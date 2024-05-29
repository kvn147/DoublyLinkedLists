/**
 * This class is similar to the built-in doubly linked list that Java has (java.util.LinkedList) but with reduced
 * functionality
 * @param <E> the type of object stored in the list
 */
public class DoublyLinkedList<E> implements List<E> {
    private ListNode<E> front;
    private int size; // number of nodes in the list

    /**
     * Constructor creates an empty list
     */
    public DoublyLinkedList() {
        front = null;
        size = 0; // no nodes in the list
    }

    /**
     * Creates a new 'front' node without a prev or next
     * @param val object to add
     */
    public DoublyLinkedList(E val) {
        front = new ListNode<>(val, null, null);
        size = 1; // one node in the  list
    }


    /**
     * Adds a new node to the end of the list
     * Note: Reuses the add(index, value) method
     * @param val
     */
    public void add(E val) {
        add(size, val);
    }


    /**
     * Adds a new node at the specified index with the data 'val'
     * @param index should be between 0 and size
     * @param val data to add
     */
    public void add(int index, E val) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Cannot add at Index " + index);
        }

        // add a new node with val as the data to the front of the list
        if (index == 0) {
            front = new ListNode<>(val, front, null);
            // If there were more nodes in the list prior to the add(0, val) adjust the .prev to point to this
            // new node
             if ( front.next != null) {
                front.next.prev = front;
            }
        } else {
            ListNode<E> current = front;


            // TODO: traverse to the node before where you need to add the new node
            // Example: add(2, f) was called
            //  when       front ----> a ----> b ----> c ----> d ----> null
            //              null <----   <----   <----   <----
            //                               current
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            // TODO: keep an after reference to current.next
            // Example: if front ----> a ----> b ---->  c ----> d ----> null
            //              null <----   <----   <----    <----
            //                              current   after
            // after is set to node c
            ListNode<E> after = current.next;

            // TODO: construct a new ListNode(f, node c, node b) named insert
            ListNode<E> insert = new ListNode<>(val, after, current);

            // TODO: Connect the insert node into the current list
            current.next = insert;

            // TODO: if node is NOT being added to the end of an existing list, adjust prev
            if (after != null) {
                after.prev = insert;
            }

        }
        size++;

    }

    // Returns the data at a given "virtual" index
    // throws IndexOutOfBounds if the index is invalid (not 0 to size)

    /**
     * Returns the data at a given "virtual" index
     * @param index  should be between 0 and size - 1
     * @return
     */
    public E get(int index) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " does not exist.");
        }
        ListNode<E> current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    // Part 2 TODO: return the "virtual" index of val, or -1 if not found
    public int indexOf(E val) {

        ListNode<E> current = front;
        for (int i = 0; i < size; i++) {
            if (current.data == val) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    // Part 2 TODO: return the data of the node at the index provided
    public E remove(int index) {

        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Index " + index + " does not exist.");
        }

        E removed = null; // will save the data value about to be removed
        ListNode<E> current = front; // use current to move through the list

        // if removing at index 0
        if (index == 0) {
         // TODO handle this case appropriately
            removed = front.data;
            front = front.next;
            if (front != null) {
                front.prev = null;
            }
        } else {
         // TODO handle this case appropriately
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            removed = current.data;
            ListNode<E> before = current.prev;
            ListNode<E> after = current.next;

            if (before != null) {
                before.next = after;
            }
            if (after != null) {
                after.prev = before;
            }
        }
        size--;
        return removed;
    }

    // Returns the number of nodes in the list
    // O(1) because we are continuously tracking size during construct/add/remove
    public int size() {
        return size;
    }


    @Override
    public String toString() {
        if (size() == 0) {
            return "[]";
        }

        StringBuilder build = new StringBuilder();
        ListNode<E> current = front;
        while (current.next != null) {
            build.append(current.data);
            build.append(", ");
            current = current.next;
        }
        // current is on the last node
        build.append(current.data);
        return "[" + build + "] size=" + size();
    }
}