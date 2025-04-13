import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
        }
    }

    // adds an item to the end of the list.
    @Override
    public void add(T item) {
        addLast(item);
    }

    //sets the value of an item at a specified index.
    @Override
    public void set(int index, T item) {
        Node<T> node = getNodeAt(index);
        if (node != null) {
            node.data = item;
        }
    }

    //adds an item at a specific index and shifts elements accordingly.
    @Override
    public void add(int index, T item) {
        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            Node<T> node = getNodeAt(index);
            Node<T> newNode = new Node<>(item);
            newNode.next = node;
            newNode.prev = node.prev;
            node.prev.next = newNode;
            node.prev = newNode;
            size++;
        }
    }

    //adds an item at the beginning of the list.
    @Override
    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    //adds an item at the end of the list.
    @Override
    public void addLast(T item) {
        Node<T> newNode = new Node<>(item);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    //retrieves an item by its index.
    @Override
    public T get(int index) {
        Node<T> node = getNodeAt(index);
        return node != null ? node.data : null;
    }

    //retrieves the first item in the list.
    @Override
    public T getFirst() {
        return head != null ? head.data : null;
    }

    //retrieves the last item in the list.
    @Override
    public T getLast() {
        return tail != null ? tail.data : null;
    }

    //removes an item at a specific index.
    @Override
    public void remove(int index) {
        Node<T> node = getNodeAt(index);
        if (node != null) {
            if (node.prev != null) node.prev.next = node.next;
            if (node.next != null) node.next.prev = node.prev;
            if (node == head) head = node.next;
            if (node == tail) tail = node.prev;
            size--;
        }
    }

    //removes the first item from the list.
    @Override
    public void removeFirst() {
        if (head != null) {
            head = head.next;
            if (head != null) head.prev = null;
            size--;
        }
    }

    //removes the last item from the list.
    @Override
    public void removeLast() {
        if (tail != null) {
            tail = tail.prev;
            if (tail != null) tail.next = null;
            size--;
        }
    }

    //sorts the list (empty for now).
    @Override
    public void sort() {

    }

    // finds the index of the first occurrence of an item.
    @Override
    public int indexOf(Object object) {
        int index = 0;
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(object)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    // finds the index of the last occurrence of an item.
    @Override
    public int lastIndexOf(Object object) {
        int index = size - 1;
        Node<T> current = tail;
        while (current != null) {
            if (current.data.equals(object)) {
                return index;
            }
            current = current.prev;
            index--;
        }
        return -1;
    }

    // checks if an item exists in the list.
    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    // converts the list to an array.
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }
        return array;
    }

    // clears the list.
    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    // returns the size of the list.
    @Override
    public int size() {
        return size;
    }

    // helper method to get a node at a specific index.
    private Node<T> getNodeAt(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    // iterator to traverse the list.
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
