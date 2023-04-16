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

    public void printList() {
        Node<T> newNode = head;
        while (newNode != null) {
            System.out.print(newNode.val + " ");
            newNode = newNode.next;
        }
        System.out.println();
    }

    @Override
    public boolean contains(Object o) {
        if (head.val == o) {
            return true;
        }
        Node<T> ptr = head.next;
        while (ptr != null) {
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
        checkIndex(index);
        Node<T> newNode = new Node<T>((T) item, null, null);
        if (index == 1) {
            add(item);
            return;
        }
        Node<T> ptr = head;
        for (int i = 1; i <= size; i++) {
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
        Node<T> newNode = new Node<T>((T) item, null, null);
        if (head.val == newNode.val) {
            head = head.next;
            head.prev = null;
            return true;
        }
        Node<T> ptr = head.next;
        while (ptr != null) {
            if (ptr.val == newNode.val) {
                Node<T> temp = ptr.prev;
                temp.next = ptr.next;
                Node<T> temp2 = ptr.next;
                temp2.prev = temp;
                return true;
            }
        }
        return false;
    }

    @Override
    public Object remove(int index) {
        checkIndex(index);
        if (index == 0) {
            Object removed = head.val;
            if (size == 1) {
                head = null;
                tail = null;
                size = 0;
                return removed;
            }
            head = head.next;
            head.prev = null;
            size--;
            return removed;
        }
        if (index == size-1) {
            Object removed = tail.val;
            tail = tail.prev;
            tail.next = null;
            size--;
            return removed;
        }
        Node<T> ptr = head.next;
        for (int i = 1; i <= size; i++) {
            if (index == i) {
                Node<T> p = ptr.prev;
                Node<T> n = ptr.next;
                Object removed = ptr.val;

                p.next = n;
                n.prev = p;
                size--;
                return removed;
            }
            ptr = ptr.next;
        }
        return null;
    }

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        if (index == 0) {
            return head.val;
        }
        Node<T> newNode = head.next;
        for (int i = 1; i <= size; i++) {
            if (i == index) {
                return newNode.val;
            }
            newNode = newNode.next;
        }
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

    public void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }
}


