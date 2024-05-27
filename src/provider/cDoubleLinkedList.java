package provider;

public class cDoubleLinkedList<T> {

    private cNode<T> head;
    private cNode<T> tail;

    public cDoubleLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addToFront(T data) {
        cNode<T> newNode = new cNode<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
    }

    public void addToEnd(T data) {
        cNode<T> newNode = new cNode<>(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    public cNode<T> getHead() {
        return head;
    }

    public cNode<T> getTail() {
        return tail;
    }
}
