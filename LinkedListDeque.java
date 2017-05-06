/**
 * Created by brukargaw on 5/5/17.
 */
public class LinkedListDeque<Item> {

    private class Node {
        public Node next;
        public Node prev;
        public Item value;

        public Node(){
            next = this;
            prev = this;
        }

        public Node(Item i, Node n , Node p){
            value = i;
            next = n;
            prev = p;

        }
    }

    // the head and tail to the linkedlist
    private Node sentinel;

    // the size of the linked list
    private int size;

    // creates an empty linkedlist
    public LinkedListDeque(){
        sentinel = new Node();
        size = 0;
    }
    /*
        Adds an item to the front of the Deque.
     */
    public void addFirst(Item i){
        if (isEmpty()){
            addToEmpty(i);
        }else{
            Node n = new Node(i, sentinel.next, sentinel);
            sentinel.next.prev = n;
            sentinel.next = n;
        }

        size++;
    }

    /*
        Adds an item to the back of the Deque.
    */
    public void addLast(Item i){
        if (isEmpty()){
            addToEmpty(i);
        }else{
            Node n = new Node(i, sentinel, sentinel.prev);
            sentinel.prev.next = n;
            sentinel.prev = n;
        }

        size++;
    }

    // helper method to add a node to an empty linkedlist
    private void addToEmpty(Item i){
        Node n = new Node(i, sentinel, sentinel);
        sentinel.next = n;
        sentinel.prev = n;
    }

    /*
         Returns true if deque is empty, false otherwise.
    */
    public boolean isEmpty(){
        if (size == 0){
            return true;
        }
        return false;
    }

    /*
        Returns the number of items in the Deque.
     */
    public int size(){
        return size;
    }

    /*
        Prints the items in the Deque from first to last, separated by a space.

     */
    public void printDeque(){
        if (!isEmpty()){
            printDeque(sentinel.next);
        }
    }

    private void printDeque(Node n){
        if (n == sentinel){
            return;
        }
        System.out.print(n.value + " " );
        printDeque(n.next);
    }

    /*
        Removes and returns the item at the front of the Deque. If no such item exists, returns null.

     */
    public Item removeFirst(){
        if (isEmpty()) return null;
        else if(size == 1) return removeToMakeEmpty();
        else{
            Node n = sentinel.next;
            sentinel.next = n.next;
            n.next.prev = sentinel;
            size--;
            return n.value;
        }

    }




    /* Removes and returns the item at the back of the Deque. If no such item exists, returns null.

     */
    public Item removeLast(){
        if (isEmpty()) return null;
        else if(size == 1) return removeToMakeEmpty();
        else{
            Node n = sentinel.prev;
            sentinel.prev = n.prev;
            n.prev.next = sentinel;
            size--;
            return n.value;
        }
    }


    private Item removeToMakeEmpty(){
        Node n = sentinel.next;
        sentinel.next = null;
        sentinel.prev = null;
        size--;
        return n.value;
    }

    /*
      Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists,
      returns null. Must not alter the deque!
    */
    public Item get(int index){
        if (isEmpty() || index >= size || index < 0) return null;
        Node n = sentinel.next;
        int i = 0;
        while (i < index){
            n = n.next;
            i++;
        }
        return n.value;
    }



    // same as get but uses recursion to get item @index
    public Item getRecursive(int index){
        if (isEmpty() || index >= size || index < 0) return null;
        return getRecursive(sentinel.next, index);
    }

    private Item getRecursive(Node n, int index){
        if (index == 0) return n.value;
        return getRecursive(n.next, index - 1);
    }

}
