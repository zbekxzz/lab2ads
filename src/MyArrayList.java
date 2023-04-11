public class MyArrayList<T> implements MyList {
    private T[] arr;
    private int size;

    public MyArrayList() {
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }

    private void increaseLength() {
        T[] newArr = (T[]) new Object[arr.length*2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        boolean bool = false;
        for (int i = 0; i < size; i++) {
            if (arr[i] == o) {
                bool = true;
            }
        }
        return bool;
    }

    @Override
    public void add(Object item) {
        if(size == arr.length){
            increaseLength();
        }
        arr[size++] = (T) item;
    }

    @Override
    public void add(Object item, int index) {
        checkIndex(index);
        if (size == arr.length) {
            increaseLength();
        }
        arr[index] = (T) item;
    }

    @Override
    public boolean remove(Object item) {
        return false;
    }

    @Override
    public Object remove(int index) {
        checkIndex(index);
        for(int i = index + 1; i < size; i++) {
            arr[i-1] = arr[i];
        }
        size--;
        return null;
    }

    @Override
    public void clear() {
        this.arr = (T[]) new Object[5];
        this.size = 5;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return arr[index];
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
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }
}
