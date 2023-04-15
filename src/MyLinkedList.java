public class MyLinkedList<T> implements MyList{
    private class Node<T> {
        T val;
        Node<T> next;
        Node<T> prev;
        Node(T val, Node<T> next, Node<T> prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        size = 0;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        if (head.val == o) {
            return true;
        }
        Node<T> ptr = head.next;
        for (int i = 2; i <= size; i++) {
            if (ptr.val == o) {
                return true;
            }
            ptr = ptr.next;
        }
        return false;
    }

    @Override
    public void add(Object item) {
        Node<T> newNode = new Node<T>((T) item, null, null);
        if (head == null) {
            head = newNode;
            tail = head;
        }
        else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void add(Object item, int index) {
        Node<T> newNode = new Node<T>((T) item, null, null);
        if (index == 1) {
            add(item);
            return;
        }
        Node<T> ptr = head;
        for (int i = 2; i <= size; i++) {
            if (i == index) {
                Node<T> temp = ptr.next;
                ptr.next = newNode;
                newNode.prev = ptr;
                newNode.next = temp;
                temp.prev = newNode;
            }
            ptr = ptr.next;
        }
        size++;
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


