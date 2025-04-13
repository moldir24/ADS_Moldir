import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    private Object[] elements;
    private int size;

    //сonstructor to initialize the list with an initial capacity of 10 elements.
    public MyArrayList() {
        elements = new Object[10];
        size = 0;
    }

    // adds an item to the end of the list.
    @Override
    public void add(T item) {
        ensureCapacity();
        elements[size++] = item;
    }

    // sets a new item at a specific index in the list.
    @Override
    public void set(int index, T item) {
        if (index >= 0 && index < size) {
            elements[index] = item;
        }
    }

    // adds an item at a specific index in the list and shifts elements if needed.
    @Override
    public void add(int index, T item) {
        if (index >= 0 && index <= size) {
            ensureCapacity();
            System.arraycopy(elements, index, elements, index + 1, size - index);
            elements[index] = item;
            size++;
        }
    }

    // adds an item at the beginning of the list.
    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    //adds an item at the end of the list.
    @Override
    public void addLast(T item) {
        add(item);
    }

    //gets the element at a specific index.
    @Override
    public T get(int index) {
        if (index >= 0 && index < size) {
            return (T) elements[index];
        }
        return null;
    }

    //gets the first element of the list.
    @Override
    public T getFirst() {
        if (size > 0) {
            return (T) elements[0];
        }
        return null;
    }

    // gets the last element of the list.
    @Override
    public T getLast() {
        if (size > 0) {
            return (T) elements[size - 1];
        }
        return null;
    }

    // removes an element at a specific index and shifts elements to fill the gap.
    @Override
    public void remove(int index) {
        if (index >= 0 && index < size) {
            System.arraycopy(elements, index + 1, elements, index, size - index - 1);
            elements[--size] = null;
        }
    }

    // removes the first element.
    @Override
    public void removeFirst() {
        remove(0);
    }

    // removes the last element.
    @Override
    public void removeLast() {
        if (size > 0) {
            elements[--size] = null;
        }
    }

    // sorts the list.
    @Override
    public void sort() {
        Arrays.sort(elements, 0, size);
    }

    // finds the index of the first occurrence of an element.
    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    // finds the index of the last occurrence of an element.
    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    // checks if an element exists in the list.
    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    // converts the list into an array.
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    //clears the list by setting all elements to null and size to 0.
    @Override
    public void clear() {
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }

    //returns the size of the list.
    @Override
    public int size() {
        return size;
    }

    //ensures that there is enough space in the array to add new elements.
    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, size * 2);
        }
    }

    //iterator to traverse the list elements.
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int current = 0;

            @Override
            public boolean hasNext() {
                return current < size;
            }

            @Override
            public T next() {
                return (T) elements[current++];
            }
        };
    }
}
