public class MyLinkedList<T> implements MyList{
    private class Node<T> {
        T val;
        Node<T> next;
        Node<T> prev;
        Node(T val, Node<T> next, Node<T> prev) {
            this.val = val;
            this.next = null;
            this.prev = prev;
        }
    }
    private Node<T> head;
    private Node<T> tail;
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public void add(Object item) {

    }

    @Override
    public void add(Object item, int index) {

    }

    @Override
    public boolean remove(Object item) {
        return false;
    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public void sort() {

    }
}


