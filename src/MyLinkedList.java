public class MyLinkedList<T> implements MyList{
    /**
     * every element is Node which have 3 parameters - value of element, reference to next and previous elements
     */
    private class Node<T> {
        T val;
        Node<T> next;
        Node<T> prev;

        /**
         * @function Node - constructor to create Node with given item
         * @param val - given element to create node
         * @param next - reference to next Node
         * @param prev - reference to previous Node
         */
        Node(T val, Node<T> next, Node<T> prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
    private Node<T> head; // head or start of the list
    private Node<T> tail; // tail or end of the list
    private int size;

    /**
     * @function MyLinkedList - constructor that creating new linked list
     * @noparam
     * @return void
     */
    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    /**
     * @function size - returning size of linked list
     * @noparam
     * @return int
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * @function isEmpty - checking is linked list empty or not
     * @norapam
     * @return boolean
     */
    public boolean isEmpty() {
        return head == null; // returning true if list is empty, false otherwise
    }

    /**
     * @function printList - displaying linked list in console
     * @noparam
     * @return void
     */
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

    /**
     * @function contains - checking and returning true if linked list contains given item, false otherwise
     * @param o - item to check
     * @return boolean
     */
    @Override
    public boolean contains(Object o) {
        if (head.val == o) {
            return true;
        }
        Node<T> ptr = head.next;
        while (ptr != null) {
            if (ptr.val == o) { // checking if element contains in linked list
                return true;
            }
            ptr = ptr.next;
        }
        return false;
    }

    /**
     * @function add - adding element to linked list at tail
     * @param item - element to add
     * @return void
     */
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

    /**
     * @function add - adding element to linked list at specific index
     * @param item - element to add
     * @param index - index of element to add
     * @return void
     */
    @Override
    public void add(Object item, int index) {
        checkIndex(index); // checking if given index acceptable
        Node<T> newNode = new Node<T>((T) item, null, null);
        if (index == 0) {
            add(item);
            return;
        }
        Node<T> ptr = head;
        for (int i = 1; i < size; i++) {
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

    /**
     * @function remove - deleting element in linked list
     * @param item - element to delete
     * @return boolean
     */
    @Override
    public boolean remove(Object item) {
        Node<T> newNode = new Node<T>((T) item, null, null);
        if (head.val == newNode.val) { // checking if element contains in linked list
            head = head.next;
            head.prev = null;
            size--;
            return true;
        }
        Node<T> ptr = head.next;
        while (ptr != null) {
            if (ptr.val == newNode.val) { // checking if element contains in linked list
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

    /**
     * @function remove - deleting element at specific index
     * @param index - index of element to delete
     * @return Object
     */
    @Override
    public Object remove(int index) {
        checkIndex(index);
        // checking if given index acceptable
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

    /**
     * @function clear - clearing all linked list by creating new
     * @noparam
     * @return void
     */
    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    /**
     * @function get - returning element in linked list by specific index
     * @param index - index of element to get
     * @return Object
     */
    @Override
    public Object get(int index) {
        checkIndex(index); // checking if given index acceptable
        if (index == 0) {
            return head.val;
        }
        Node<T> newNode = head.next;
        for (int i = 1; i < size; i++) {
            if (i == index) {
                return newNode.val;
            }
            newNode = newNode.next;
        }
        return null;
    }

    /**
     * @function indexOf - returning index of given element in linked list
     * @param o - element to find
     * @return int
     */
    @Override
    public int indexOf(Object o) {
        Node<T> newNode = new Node<T>((T) o, null, null);
        if (head.val == newNode.val) {
            return 0;
        }
        Node<T> ptr = head.next;
        for (int i = 1; i <= size; i++) {
            if (ptr.val == newNode.val) { // checking if element contains in linked list
                return i;
            }
            ptr = ptr.next;
        }
        return -1;
    }

    /**
     * @function lastIndexOf - returning last index of given element in linked list
     * @param o - element to find
     * @return - int
     */
    @Override
    public int lastIndexOf(Object o) {
        Node<T> newNode = new Node<T>((T) o, null, null);
        if (tail.val == newNode.val) { // checking if element equal to tail of linked list
            return size-1;
        }
        Node<T> ptr = tail.prev;
        for (int i = size-2; i >= 0; i--) {
            if (ptr.val == newNode.val) { // checking if element contains in linked list
                return i;
            }
            ptr = ptr.prev;
        }
        return -1;
    }

    /**
     * @function sort - sorting elements by insertion sort
     * @noparam
     * @return void
     */
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

    /**
     * @function swapValue - function to swap two Nodes, used in sort
     * @param first - first node
     * @param second - second node
     * @return void
     */
    public void swapValue(Node<T> first, Node<T> second) {
        Object value = first.val;
        first.val = second.val;
        second.val = (T) value;
    }

    /**
     * @function checkIndex - checking given index, throw error if index not acceptable
     * @param index - index to check
     * @return void
     */
    public void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * @function isSortable - checking if linked list contains all integers or doubles
     * @noparam
     * @return boolean
     */
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
        if (intSize == size || doubleSize == size || doubleSize + intSize == size) {
            return true;
        }
        return false;
    }
}


