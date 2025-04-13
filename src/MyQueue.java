public class MyQueue<T> {
    private Object[] elements;
    private int size;
    private int front;
    private int rear;

    //constructor to initialize the queue with a capacity of 10.
    public MyQueue() {
        elements = new Object[10];
        size = 0;
        front = 0;
        rear = 0;
    }

    //returns true if the queue is empty.
    public boolean empty() {
        return size == 0;
    }

    //returns the number of elements in the queue.
    public int size() {
        return size;
    }

    //returns the front element of the queue without removing it.
    public T peek() {
        if (empty()) {
            return null;
        }
        return (T) elements[front];
    }

    //adds an element to the rear of the queue.
    public void enqueue(T item) {
        ensureCapacity();
        elements[rear] = item;
        rear = (rear + 1) % elements.length;
        size++;
    }

    //removes and returns the front element of the queue.
    public T dequeue() {
        if (empty()) {
            return null;
        }
        T item = (T) elements[front];
        elements[front] = null;
        front = (front + 1) % elements.length;
        size--;
        return item;
    }

    //ensures the queue has enough capacity to accommodate new elements.
    private void ensureCapacity() {
        if (size == elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[(front + i) % elements.length];
            }
            elements = newElements;
            front = 0;
            rear = size;
        }
    }
}
