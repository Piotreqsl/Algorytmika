package Data_Structures;

public class Queue<Item> {
    private Node first;
    private Node last;
    private int N;

    private class Node
    {
        Item item;
        Node next;
    }

    public boolean isEmpty() { return  N == 0;}
    public int size() {return  N;}

    public void enqueue(Item item)
    {
        Node oldlast = last;
        Node last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last; //If queue is empty the only one element is first and last
        else oldlast.next = last;    //else set reference normally.
        N++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if(isEmpty()) last = null; //If after removal queue is empty delete last reference
        N--;
        return item;
    }
}
