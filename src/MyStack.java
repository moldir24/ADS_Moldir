public class MyStack<T> {
    private Object[] elements;
    private int size;

    // constructor to initialize the stack with a capacity of 10.
    public MyStack() {
        elements = new Object[10];
        size = 0;
    }

    // checks if the stack is empty.
    public boolean empty() {
        return size == 0;
    }

    // returns the current size of the stack.
    public int size() {
        return size;
    }

    // returns the top element of the stack without removing it.
    public T peek() {
        if (empty()) {
            return null;
        }
        return (T) elements[size - 1];
    }

    // pushes an item onto the stack.
    public void push(T item) {
        ensureCapacity();
        elements[size++] = item;
    }

    // removes and returns the top item from the stack.
    public T pop() {
        if (empty()) {
            return null;
        }
        T item = (T) elements[size - 1];
        elements[--size] = null;
        return item;
    }

    // ensures the array has enough capacity to add more elements.
    private void ensureCapacity() {
        if (size == elements.length) {
            elements = java.util.Arrays.copyOf(elements, size * 2);
        }
    }
}
