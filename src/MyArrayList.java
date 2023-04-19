public class MyArrayList<T> implements MyList {
    private T[] arr;
    private int size;

    public MyArrayList() {
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }

    public void printList() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }
    private void increaseLength() {
        T[] newArr = (T[]) new Object[arr.length*2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
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
        if (size == arr.length) {
            increaseLength();
        }
        T[] newArr = (T[]) new Object[arr.length];
        for (int i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }
        for (int i = index; i < size; i++) {
            newArr[i+1] = arr[i];
        }
        newArr[index] = (T) item;
        arr = newArr;
        size++;
    }

    @Override
    public boolean remove(Object item) {
        boolean removed = false;
        for (int i = 0; i < size; i++) {
            if (arr[i] == item) {
                remove(i);
                removed = true;
            }
        }
        return removed;
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
        for (int i = 0; i < size; i++) {
            if (arr[i] == o) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i] == o) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void sort() {
        if (isSortable().equals("int")) {
            int n = size;
            for (int i = 0; i < n-1; i++)
                for (int j = 0; j < n-i-1; j++)
                    if ((int) arr[j] > (int) arr[j+1])
                    {
                        // swap temp and arr[i]
                        T temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
        }
        if (isSortable().equals("double")) {
            int n = size;
            for (int i = 0; i < n-1; i++)
                for (int j = 0; j < n-i-1; j++)
                    if ((Double) arr[j] > (Double) arr[j+1])
                    {
                        // swap temp and arr[i]
                        T temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
        }
    }
    public void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    public String isSortable() {
        int intSize = 0;
        int doubleSize = 0;
        for (int i = 0; i < size; i++) {
            try {
                int value = (Integer) arr[i];
                intSize++;
            } catch (ClassCastException e) {
            }
            try {
                double tempD = (Double) arr[i];
                doubleSize++;
            } catch (ClassCastException e) {
            }
        }
        if (intSize == size) {
            return "int";
        }
        if (doubleSize == size) {
            return "double";
        }
        return "0";
    }
}
