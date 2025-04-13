public class MyMinHeap<T extends Comparable<T>> {
    private Object[] heap;
    private int size;

    // constructor to initialize the heap with a default capacity of 10.
    public MyMinHeap() {
        heap = new Object[10];
        size = 0;
    }

    //returns true if the heap is empty.
    public boolean empty() {
        return size == 0;
    }

    //returns the number of elements in the heap.
    public int size() {
        return size;
    }

    //returns the minimum element of the heap.
    public T getMin() {
        if (empty()) {
            return null;
        }
        return (T) heap[0];
    }

    // removes and returns the minimum element (root) from the heap.
    public T extractMin() {
        if (empty()) {
            return null;
        }
        T min = (T) heap[0];
        heap[0] = heap[--size];
        heapify(0);
        return min;
    }

    // inserts an element into the heap.
    public void insert(T item) {
        if (size == heap.length) {
            heap = java.util.Arrays.copyOf(heap, size * 2);
        }
        heap[size] = item;
        siftUp(size);
        size++;
    }

    // heapifies the heap to maintain the heap property.
    private void heapify(int index) {
        int left = leftChildOf(index);
        int right = rightChildOf(index);
        int smallest = index;

        // check if the left child is smaller than the current element.
        if (left < size && ((T) heap[left]).compareTo((T) heap[smallest]) < 0) {
            smallest = left;
        }

        // check if the right child is smaller than the current element.
        if (right < size && ((T) heap[right]).compareTo((T) heap[smallest]) < 0) {
            smallest = right;
        }

        // if the smallest element is not the current element, swap and heapify the subtree.
        if (smallest != index) {
            swap(index, smallest);
            heapify(smallest);
        }
    }

    // moves an element up in the heap to restore the heap property.
    private void siftUp(int index) {
        while (index > 0 && ((T) heap[index]).compareTo((T) heap[parentOf(index)]) < 0) {
            swap(index, parentOf(index));
            index = parentOf(index);
        }
    }

    // returns the index of the left child of a given index.
    private int leftChildOf(int index) {
        return 2 * index + 1;
    }

    // returns the index of the right child of a given index.
    private int rightChildOf(int index) {
        return 2 * index + 2;
    }

    // returns the index of the parent of a given index.
    private int parentOf(int index) {
        return (index - 1) / 2;
    }

    // swaps two elements in the heap.
    private void swap(int index1, int index2) {
        Object temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }
}
