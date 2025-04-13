This project is a collection of different data structures in Java. Data structures are ways to store and organize data so that it can be accessed and used efficiently. In this project, we have implemented several common data structures:
MyList: A basic interface that defines common list operations.
MyArrayList: A dynamic array that resizes itself when it's full.
MyLinkedList: A list made up of nodes, where each node points to the next one.
MyStack: A data structure that follows the Last In, First Out (LIFO) principle.
MyQueue: A data structure that follows the First In, First Out (FIFO) principle.
MyMinHeap: A special type of binary tree where the smallest element is always at the top.

Here are the main functions used in this project for each data structure:
MyList Interface:
This is an interface that defines the common operations for all list-based data structures:
add: Adds an item to the list.
remove: Removes an item from the list.
set: Sets an item at a specific index in the list.
get: Gets the item at a specific index.
size: Returns the number of items in the list.
clear: Clears all elements in the list.
indexOf: Finds the index of a specific item.
toArray: Converts the list into an array.
MyArrayList:
An array-based list that grows when it runs out of space. This uses:
ensureCapacity: Checks if there is enough space in the array, and if not, it doubles the array size.
add: Adds an item to the end of the list and increases the size.
remove: Removes an item from a specific index and shifts the remaining items.
get: Retrieves the item at a specific index.
MyLinkedList:
A linked list that uses nodes to store data. Each node has a reference to the next node and sometimes the previous one. Functions include:
addFirst: Adds an item at the beginning of the list.
addLast: Adds an item at the end of the list.
removeFirst: Removes the first item from the list.
removeLast: Removes the last item from the list.
get: Gets an item at a specific index.
MyStack:
A stack follows the LIFO principle, where the last item added is the first to be removed. Functions include:
push: Adds an item to the top of the stack.
pop: Removes and returns the item at the top.
peek: Looks at the item at the top without removing it.
empty: Checks if the stack is empty.
MyQueue:
A queue follows the FIFO principle, where the first item added is the first to be removed. Functions include:
enqueue: Adds an item to the end of the queue.
dequeue: Removes and returns the item at the front.
peek: Looks at the item at the front without removing it.
empty: Checks if the queue is empty.
MyMinHeap:
A heap is a special type of binary tree where each parent is smaller than its children. A min-heap has the smallest element at the top. Functions include:
insert: Adds an element to the heap and reorders it.
extractMin: Removes and returns the smallest element (the root).
heapify: Ensures that the heap property is maintained.

How the Project Works:
MyList Interface: This is the foundation of all list-based data structures. It defines the main actions that a list can perform, such as adding, removing, and getting items, checking the size, and clearing the list.
MyArrayList: This data structure is based on an array. When the array reaches its limit, it automatically expands to accommodate more items. It allows you to add items, remove them, get an item by its index, and check the size of the list.
MyLinkedList: A linked list uses nodes where each node points to the next and sometimes the previous node. This allows easy addition and removal of items from the beginning and end of the list.
MyStack: A stack works by following the LIFO (Last In, First Out) principle. The last item you add is the first one to be removed. It has methods for adding items (push), removing items (pop), and looking at the top item without removing it (peek).
MyQueue: A queue follows the FIFO (First In, First Out) principle. The first item added is the first one to be removed. It provides methods for adding items (enqueue), removing items (dequeue), and checking the front item (peek).
MyMinHeap: A min-heap is a type of binary tree where the smallest element is always at the top. This structure allows you to quickly find and remove the smallest element and insert new elements while maintaining the heap property.
