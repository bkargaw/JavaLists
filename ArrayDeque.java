/**
 * Created by brukargaw on 5/5/17.
 */
public class ArrayDeque<Item> {

    private int nextFirst;
    private int nextLast;
    private int size;
    private Item[] items;

    public ArrayDeque(){
        items = (Item[]) new Object[8];
        nextFirst = 3;
        nextLast= 4;
        size = 0;
    }

    /*
        Adds an item to the front of the Deque.
     */
    public void addFirst(Item i) {
        if (size == capacity()) resize(capacity() * 2);

        items[nextFirst] = i;

        if ( nextFirst == 0){
            nextFirst = capacity() - 1;
        }else {
            nextFirst--;
        }

        size++;
    }

    /*
        Adds an item to the back of the Deque.
    */
    public void addLast(Item i){
        if (size == capacity()) resize(capacity() * 2);

        items[nextLast] = i;

        if (nextLast == capacity() - 1){
            nextLast = 0;
        }else {
            nextLast++;
        }

        size++;
    }

    private int capacity(){
        return items.length;
    }

    private void resize(int capacity){
        Item[] newItems = (Item[]) new Object[capacity];
        System.arraycopy(items,0, newItems, 1, capacity());
        nextFirst = 0;
        nextFirst = capacity;
        items = newItems;
    }


    /*
         Returns true if deque is empty, false otherwise.
    */
    public boolean isEmpty(){
        if(size == 0) return true;
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
        for(Item i:items){
            if (i != null)System.out.print(i + " ");
        }
    }


    /*
        Removes and returns the item at the front of the Deque. If no such item exists, returns null.

     */
    public Item removeFirst(){
        if (size == 0) return null;

        if(nextFirst == capacity() -1){
            nextFirst = 0;
        }else{
            nextFirst++;
        }
        size--;
        Item i = items[nextFirst];
        items[nextFirst] = null;
        return i;
    }


    /* Removes and returns the item at the back of the Deque. If no such item exists, returns null.

     */
    public Item removeLast(){
        if (size == 0) return null;

        if(nextLast == 0){
            nextLast = capacity() - 1;
        }else{
            nextLast--;
        }
        size--;
        Item i = items[nextLast];
        items[nextLast] = null;
        return i;
    }


    /*
      Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists,
      returns null. Must not alter the deque!
    */
    public Item get(int index){
        if (index > size() - 1 || index < 0 ) {
            return null;
        }
        if( nextFirst < nextLast){
            return items[nextFirst + index + 1];
        }else{
            if( nextFirst + index + 1 < capacity()){
                return items[nextFirst + index + 1];
            }else{
                return items[index - (capacity() + nextFirst + 1)];
            }
        }
    }

    public static void main ( String[] args){
        ArrayDeque<Integer> array = new ArrayDeque<>();
        array.addFirst(1);
//        array.printDeque();
        System.out.println(array.get(0));
    }

}
