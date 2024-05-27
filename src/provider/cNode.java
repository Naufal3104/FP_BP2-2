package provider;

/**
 *
 * @author LENOVO
 */
public class cNode<T> {

    private T data;
    private cNode<T> next;
    private cNode<T> prev;

    cNode(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public cNode<T> getNext() {
        return next;
    }

    public void setNext(cNode<T> next) {
        this.next = next;
    }

    public cNode<T> getPrev() {
        return prev;
    }

    public void setPrev(cNode<T> prev) {
        this.prev = prev;
    }
}
