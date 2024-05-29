/**
 * A node that can be used in a doubly linked list
 * The class is generic so any Java Object can be stored in it
 * @param <E>
 */
public class ListNode<E> {
    public E data;
    public ListNode<E> next;  
    public ListNode<E> prev;

    /**
     * Creates a ListNode with all null values
     */
    public ListNode() {
        this(null, null, null);
    }

    /**
     * Creates a Solitary ListNode
     * @param data
     */
    public ListNode(E data) {
        this(data, null, null);
    }

    /**
     * Creates a ListNode with
     * @param data any Java object
     * @param next points to the next ListNode in the list
     * @param prev points to the previous ListNode in the list
     */
    public ListNode(E data, ListNode<E> next, ListNode<E> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
    
    public String toString() {
      return "[" + this.data + "]";
    }
}