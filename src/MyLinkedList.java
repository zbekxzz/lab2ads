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

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        System.out.print("Doubly Linked List:  ");
        if (size == 0) {
            System.out.print("empty\n");
            return;
        }
        if (head.next == null) {
            System.out.println(head.val);
            return;
        }
        System.out.print(head.val + " <-> ");
        Node<T> ptr = head.next;
        while (ptr.next != null) {
            System.out.print(ptr.val + " <-> ");
            ptr = ptr.next;
        }
        System.out.print(ptr.val + "\n");
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
        if (index == 0) {
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
            size--;
            return true;
        }
        Node<T> ptr = head.next;
        while (ptr != null) {
            if (ptr.val == newNode.val) {
                Node<T> temp = ptr.prev;
                temp.next = ptr.next;
                Node<T> temp2 = ptr.next;
                temp2.prev = temp;
                size--;
                return true;
            }
            ptr = ptr.next;
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
        Node<T> newNode = new Node<T>((T) o, null, null);
        if (head.val == newNode.val) {
            return 0;
        }
        Node<T> ptr = head.next;
        for (int i = 1; i <= size; i++) {
            if (ptr.val == newNode.val) {
                return i;
            }
            ptr = ptr.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node<T> newNode = new Node<T>((T) o, null, null);
        if (tail.val == newNode.val) {
            return size-1;
        }
        Node<T> ptr = tail.prev;
        for (int i = size-1; i >= 1; i--) {
            if (ptr.val == newNode.val) {
                return i;
            }
            ptr = ptr.prev;
        }
        return -1;
    }

    @Override
    public void sort() {
        if (isSortable()) {
            Node<T> front = head;
            Node<T> back = null;
            while (front != null) {
                back = front.next;
                while (back != null && back.prev != null && (Integer) back.val < (Integer) back.prev.val) {
                    swapValue(back, back.prev);
                    back = back.prev;
                }
                front = front.next;
            }
        }

    }

    public void swapValue(Node<T> first, Node<T> second) {
        Object value = first.val;
        first.val = second.val;
        second.val = (T) value;
    }

    public void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }
    public boolean isSortable() {
        Node<T> ptr = head;
        int intSize = 0;
        int doubleSize = 0;
        for (int i = 1; i <= size; i++) {
            try {
                int value = (Integer) ptr.val ;
                intSize++;
            } catch (ClassCastException e) {
            }
            try {
                double tempD = (Double) ptr.val;
                doubleSize++;
            } catch (ClassCastException e) {
            }
            ptr = ptr.next;
        }
        System.out.println(intSize + " " + doubleSize);
        if (intSize == size || doubleSize == size || doubleSize + intSize == size) {
            return true;
        }
        return false;
    }
}


