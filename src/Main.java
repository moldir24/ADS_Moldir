public class Main {
    public static void main(String[] args) {

        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        System.out.println("ArrayList: " + myArrayList.get(1));

        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("A");
        myLinkedList.add("B");
        myLinkedList.add("C");
        System.out.println("LinkedList: " + myLinkedList.getFirst());

        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(10);
        myStack.push(20);
        System.out.println("Stack Peek: " + myStack.peek());
        System.out.println("Stack Pop: " + myStack.pop());

        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        System.out.println("Queue Peek: " + myQueue.peek());
        System.out.println("Queue Dequeue: " + myQueue.dequeue());


        MyMinHeap<Integer> myMinHeap = new MyMinHeap<>();
        myMinHeap.insert(10);
        myMinHeap.insert(5);
        myMinHeap.insert(20);
        System.out.println("Min Heap Get Min: " + myMinHeap.getMin());
        System.out.println("Min Heap Extract Min: " + myMinHeap.extractMin());
    }
}
