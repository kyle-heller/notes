# Data Structures and Algorithms

## Introduction

The basic idea of a data structure is to store data in a way that meets the needs of your particular application. You might be inclined to store a particular kind of data in one giant array, but it would be rather time consuming to locate a specific value if you had a significant number and depth of items. So you need to look to other options.

Depending on the application, there are a batch of other basic data structures available to help you out. The differences between them typically have to do with trade-offs between how long it takes to first populate the structure, how long it takes to add or find elements, and how large the structure is in memory.

So in short, algorithms are the patterns and procedures used to accomplish the goal at hand. Data structures are like tools in your tool belt.

## What is an Algorithm?

An algorithm is used to describe the “step-by-step” approach where there is exactly one correct next step. In an algorithm, given the current phase of the process and the steps that are outlined, there is one single, correct way to proceed.

## What is a data structure?

A data structure is a collection of data values, the relationships among them, and the functions or operations that can be applied to the data

Data structures serve as the basis for abstract data types (ADT). The ADT defines the logical form of the data type. The data structure implements the physical form of the data type.[5]

Different types of data structures are suited to different kinds of applications, and some are highly specialized to specific tasks. For example, relational databases commonly use B-tree indexes for data retrieval,[6] while compiler implementations usually use hash tables to look up identifiers.[7]

Data structures provide a means to manage large amounts of data efficiently for uses such as large databases and internet indexing services. Usually, efficient data structures are key to designing efficient algorithms. Some formal design methods and programming languages emphasize data structures, rather than algorithms, as the key organizing factor in software design. Data structures can be used to organize the storage and retrieval of information stored in both main memory and secondary memory.[8]

## Examples of well known data structures

There are numerous types of data structures, generally built upon simpler primitive data types (like ints, floats, boolean, and returnAddress for example) Well known examples are:

- An array is a number of elements in a specific order, typically all of the same type (depending on the language, individual elements may either all be forced to be the same type, or may be of almost any type). Elements are accessed using an integer index to specify which element is required. Typical implementations allocate contiguous memory words for the elements of arrays (but this is not always a necessity). Arrays may be fixed-length or resizable.

- A linked list (also just called list) is a linear collection of data elements of any type, called nodes, where each node has itself a value, and points to the next node in the linked list. The principal advantage of a linked list over an array is that values can always be efficiently inserted and removed without relocating the rest of the list. Certain other operations, such as random access to a certain element, are however slower on lists than on arrays.

- A record (also called tuple or struct) is an aggregate data structure. A record is a value that contains other values, typically in fixed number and sequence and typically indexed by names. The elements of records are usually called fields or members. In the context of object-oriented programming, records are known as plain old data structures to distinguish them from objects.

- Hash tables, graphs, stacks, queues, trees, binary trees and tries.

## What is a stack?

In computer science, a stack is an abstract data type that represents a collection of elements with a last-in, first-out (LIFO) ordering. This means that the most recently added element is the first one to be removed.

A stack typically supports two main operations: "push", which adds an element to the top of the stack, and "pop", which removes the element from the top of the stack. In addition, a stack may also support other operations such as "peek", which returns the top element without removing it, or "isEmpty", which checks if the stack is empty.

The name "stack" comes from the analogy of a physical stack of objects, such as a stack of plates or a stack of books. When new objects are added to the stack, they are placed on top of the existing objects, and when objects are removed, they are removed from the top of the stack.

Stacks are commonly used in computer science for a variety of purposes, such as implementing function calls and recursion in programming languages, evaluating arithmetic expressions, parsing languages, and undo-redo functionality in text editors. Stacks are also used in memory management to manage the call stack, which is a region of memory used by a program to store information about function calls and their parameters.

## What is a queue?

You can find a great example of a queue simply by thinking about a typical experience at a deli. When you get in line, you pull a number and wait for your number to be called. Everyone who pulled a number before you will be given service before you, but when you’re the customer who has been in line the longest, your number will be called next.

Queues don't have indexes so they can't be accessed directly. You can add only to the back and remove only from the front.

Queues have two properties:

Enqueue is when you “start waiting.” It’s the equivalent of pulling a number in the deli example.
Dequeue is when it’s your turn to be served. It’s the equivalent of having your number called at the deli.

And in ruby code, you can easily implement the “deli queue” behavior by using an array and two simple methods. Queues are said to be FIFO, or “first-in-first-out.”

```ruby
a = []

a.push(1) # enqueue the number 1 in the queue
a.push(2) # enqueue the number 2 in the queue
a.push(3) # enqueue the number 3 in the queue

# dequeue the first element, 1 has been in the queue longest
puts a.shift  # => displays 1

a.push(4) # enqueue the number 4 in the queue

# dequeue the next element.  1 has been tended to
# already, so tend to the element that has been in
# the queue the longest, in this case 2
puts a.shift  # => displays 2
```

## What’s the difference between a stack and a queue?

The main difference between a stack and a queue is the order in which elements are added and removed.

In a stack, elements are added and removed from the top of the stack only, following a last-in, first-out (LIFO) ordering. The most recently added element is always the first one to be removed.

In contrast, in a queue, elements are added at the back of the queue and removed from the front of the queue, following a first-in, first-out (FIFO) ordering. The first element added to the queue is always the first one to be removed.

To illustrate the difference between a stack and a queue, consider the example of a line of people waiting to buy tickets at a movie theater. If the line operates as a stack, the last person to join the line will be the first person to buy a ticket. In contrast, if the line operates as a queue, the first person to join the line will be the first person to buy a ticket.

Both stacks and queues are useful data structures in computer science, and each has its own set of use cases. Stacks are commonly used for function call management and undo-redo functionality, while queues are used for job scheduling and event processing, among other things.

## What is a stack useful for?

Stacks are useful in contexts where we want to reverse the order of elements. For example think about an undo button on an application, the application stores the activities performed in a stack. When you press the undo button the activity that is undone is the last activity that was performed.

A stack is a useful data structure that has many applications in computer science, including:

Function call management: When a function is called, its arguments and local variables are stored on the stack. When the function returns, the values are popped off the stack.

Undo-redo functionality: In many applications, such as text editors or graphics software, a stack can be used to keep track of the history of actions, allowing users to undo or redo previous actions.

Expression evaluation: Stacks can be used to evaluate expressions, such as arithmetic or logical expressions, by converting them into postfix or prefix notation and using a stack to keep track of the operands and operators.

Memory management: Stacks are used in memory management to manage the call stack, which is a region of memory used by a program to store information about function calls and their parameters.

Parsing and syntax analysis: Stacks are used in parsing and syntax analysis of programming languages and other formal languages, to keep track of the structure of the input and to ensure that it conforms to the grammar rules.

Overall, stacks are a simple yet powerful data structure that can be used in many different contexts, and their LIFO ordering makes them particularly useful for managing and tracking the order of operations.

## What is a queue useful for?

A queue is a useful data structure that has many applications in computer science, including:

Job scheduling: In computer systems, a queue can be used to schedule jobs or processes, such as running a sequence of tasks on a computer.

Event processing: In many applications, such as message processing or network communication, a queue can be used to store and process events or messages in the order in which they are received.

Resource sharing: Queues can be used to share resources, such as printers or network connections, among multiple users, by assigning each user a position in the queue and granting access in the order of the queue.

Breadth-first search: In graph theory, a queue is used to implement the breadth-first search algorithm, which explores a graph by visiting all the nodes at a certain distance from a starting node before moving on to nodes at a greater distance.

Buffering: In many applications, such as audio and video streaming, a queue can be used to buffer data and smooth out variations in data rates, ensuring that data is delivered at a constant rate to the user.

Overall, queues are a versatile data structure that can be used in many different contexts, and their FIFO ordering makes them particularly useful for managing and tracking the order of events or processes.

## What’s the best way to implement stacks and queues in Ruby (hint: think simple)?

In Ruby, stacks and queues can be implemented using arrays. The simplicity and flexibility of arrays make them a great choice for implementing stacks and queues.

To implement a stack using an array, you can use the push method to add elements to the top of the stack and the pop method to remove elements from the top of the stack. For example:

```ruby
stack = []
stack.push(1)
stack.push(2)
stack.push(3)
puts stack.pop  # Output: 3
puts stack.pop  # Output: 2
puts stack.pop  # Output: 1
```

To implement a queue using an array, you can use the push method to add elements to the back of the queue and the shift method to remove elements from the front of the queue. For example:

```ruby
queue = []
queue.push(1)
queue.push(2)
queue.push(3)
puts queue.shift  # Output: 1
puts queue.shift  # Output: 2
puts queue.shift  # Output: 3
```

## Why bother having many different search algorithms?

Having many different search algorithms is important because different algorithms are better suited for different types of data and search problems. Some algorithms may be more efficient than others for certain types of data, while others may be better suited for specific search requirements, such as finding the shortest path or the optimal solution.

For example, binary search is a very efficient algorithm for searching through sorted arrays, while linear search is a simple algorithm that works well for small arrays or unsorted data. Depth-first search is a useful algorithm for searching through trees and graphs, while breadth-first search is better for finding the shortest path between two nodes in a graph.

Having many different search algorithms also allows for a more flexible and adaptable approach to problem-solving. When faced with a new search problem, a programmer can choose the algorithm that is best suited for the task at hand, rather than relying on a one-size-fits-all approach.

Furthermore, by having many different search algorithms, researchers and developers can continue to explore and improve upon existing algorithms, creating new and more efficient approaches to search problems. This ongoing research and development helps to push the boundaries of what is possible with search algorithms, leading to new applications and discoveries in fields such as artificial intelligence, data science, and computer graphics.

## What is a Linked List?

A linked list is a data structure used in computer science to store a sequence of elements, where each element is linked to the next element through a pointer or reference. In a linked list, each element, also known as a node, consists of two parts: a data field, which stores the element's value, and a pointer or reference field, which points to the next node in the sequence.

Linked lists are dynamic data structures that can grow or shrink in size during runtime, unlike arrays, which have a fixed size. There are two main types of linked lists: singly linked lists and doubly linked lists.

In a singly linked list, each node has a pointer to the next node in the sequence, but not to the previous node. This means that traversal of the list can only be done in one direction, from the head (the first node) to the tail (the last node).

In a doubly linked list, each node has a pointer to both the next node and the previous node in the sequence. This allows for traversal of the list in both directions.

Linked lists are used in a variety of applications, including implementation of stacks, queues, and hash tables. They are also useful for dynamic memory allocation and for representing sparse data structures. However, linked lists have some disadvantages compared to arrays, such as slower access times and higher memory usage due to the need for additional pointers.

```ruby
# Define a Node class that represents a single node in the linked list
class Node
  attr_accessor :data, :next

  def initialize(data)
    @data = data
    @next = nil
  end
end

# Define a LinkedList class that manages the nodes in the list
class LinkedList
  def initialize
    @head = nil
  end

  # Insert a new node at the beginning of the list
  def insert_first(data)
    new_node = Node.new(data)
    new_node.next = @head
    @head = new_node
  end

  # Insert a new node at the end of the list
  def insert_last(data)
    new_node = Node.new(data)

    # If the list is empty, set the new node as the head
    if @head.nil?
      @head = new_node
      return
    end

    # Traverse the list to find the last node and set its 'next' pointer to the new node
    current_node = @head
    while current_node.next != nil
      current_node = current_node.next
    end

    current_node.next = new_node
  end

  # Remove the first node from the list
  def remove_first
    return nil if @head.nil?

    # Set the head to the next node in the list
    removed_node = @head
    @head = @head.next
    removed_node.next = nil

    return removed_node
  end

  # Traverse the list and return the node that matches the specified data value
  def find_node(data)
    return nil if @head.nil?

    current_node = @head
    while current_node != nil
      return current_node if current_node.data == data
      current_node = current_node.next
    end

    return nil
  end

  # Traverse the list and return the node at the specified index
  def get_node(index)
    return nil if @head.nil?

    current_node = @head
    i = 0
    while current_node != nil && i < index
      current_node = current_node.next
      i += 1
    end

    return current_node if i == index
    return nil
  end
end
```

## What is Binary Search?

Binary search is a search algorithm used to find the position of a target value (usually a number) within a sorted list or array. The algorithm works by repeatedly dividing the search interval in half, eliminating half of the remaining elements in each iteration, until the target value is found or the search interval is empty.

The basic steps of the binary search algorithm are as follows:

- Start with the middle element of the sorted array.
- If the middle element matches the target value, return its position.
- If the middle element is greater than the target value, search the left half of the array.
- If the middle element is less than the target value, search the right half of the array.
- Repeat steps 1-4 with the new search interval until the target value is found or the search interval is empty.

Binary search has a time complexity of O(log n), which means that it can search through a large array or list in a relatively small number of steps. This makes binary search an efficient algorithm for finding elements in a sorted data structure, especially for large datasets.

However, binary search requires the data to be sorted, which can add an additional overhead to the algorithm. Additionally, binary search may not be the best option for smaller datasets or for datasets that are frequently updated, as the overhead of sorting the data may outweigh the benefits of the search algorithm.

## What is breadth-first-search (BFS)?

Breadth-first search (BFS) is a graph traversal algorithm that explores all the vertices of a graph in breadth-first order. Starting at a given source vertex, BFS visits all the vertices of the graph that are reachable from the source vertex in a level-by-level fashion, visiting all vertices at each level before moving on to the next level.

The basic steps of the BFS algorithm are as follows:

1. Create a queue and enqueue the source vertex.
2. Mark the source vertex as visited.
3. While the queue is not empty, do the following:
   - Dequeue the vertex at the front of the queue.
   - For each unvisited neighbor of the dequeued vertex, mark it as visited and enqueue it.
4. Repeat step 3 until the queue is empty.

BFS can be used to solve various graph problems, such as finding the shortest path between two vertices, checking if a graph is bipartite, and finding the connected components of a graph.

The time complexity of BFS is O(V + E), where V is the number of vertices in the graph and E is the number of edges. In the worst case, BFS may visit all vertices and edges of the graph, making it a relatively slow algorithm for very large graphs. However, BFS is often faster than other graph traversal algorithms when the graph is dense or when the path to the target vertex is not very deep, as BFS tends to find the shortest path first.

## What is depth-first-search (DFS)?

Depth-first search (DFS) is a graph traversal algorithm that explores all the vertices of a graph in depth-first order. Starting at a given source vertex, DFS explores as far as possible along each branch before backtracking and exploring the next branch. This means that DFS visits all vertices in a path as deep as possible before exploring vertices at a shallower depth.

The basic steps of the DFS algorithm are as follows:

1. Create a stack and push the source vertex.
2. While the stack is not empty, do the following:
   - Pop the vertex at the top of the stack.
   - If the vertex is unvisited, mark it as visited and do the following:
     - For each unvisited neighbor of the popped vertex, push it onto the stack.
3. Repeat step 2 until the stack is empty.

DFS can be used to solve various graph problems, such as finding the connected components of a graph, detecting cycles in a graph, and generating a topological sort of a directed acyclic graph.

The time complexity of DFS is O(V + E), where V is the number of vertices in the graph and E is the number of edges. In the worst case, DFS may visit all vertices and edges of the graph, making it a relatively slow algorithm for very large graphs. However, DFS can be faster than BFS for certain types of graphs, such as those with long paths or with many vertices that have few neighbors.

## What situations would you want to use BFS?

BFS is useful for several graph-related problems, including:

Finding the shortest path between two vertices: BFS guarantees that it finds the shortest path between two vertices if the graph is unweighted.

Testing if a graph is bipartite: BFS can be used to test if a graph is bipartite by coloring the vertices of the graph in two different colors while traversing the graph.

Finding the connected components of a graph: BFS can be used to find the connected components of a graph by visiting all vertices that are reachable from a given vertex.

Detecting cycles in a graph: BFS can be used to detect cycles in a graph by keeping track of the parent of each vertex and checking if a vertex is visited more than once.

Web crawling and social network analysis: BFS can be used to crawl web pages or analyze social networks by visiting all the vertices in a network that are reachable from a given vertex.

Overall, BFS is useful in situations where the goal is to explore the graph systematically and visit all vertices in a breadth-first order.

## What situations would you want to use DFS instead?

Depth-first search (DFS) is a graph traversal algorithm that visits all vertices in a path as deep as possible before exploring vertices at a shallower depth. This property makes DFS useful for several graph-related problems, including:

Finding the connected components of a graph: DFS can be used to find the connected components of a graph by visiting all vertices that are reachable from a given vertex.

Generating a topological sort of a directed acyclic graph (DAG): DFS can be used to generate a topological sort of a DAG by ordering the vertices in reverse order of their finishing times.

Detecting cycles in a graph: DFS can be used to detect cycles in a graph by keeping track of the parent of each vertex and checking if a vertex is visited more than once.

Finding the strongly connected components of a directed graph: DFS can be used to find the strongly connected components of a directed graph by visiting all vertices that are reachable from a given vertex and then performing a second DFS on the reversed graph.

Generating mazes and solving puzzles: DFS can be used to generate mazes and solve puzzles by exploring all possible paths in a graph.

Overall, DFS is useful in situations where the goal is to explore the graph systematically and visit all vertices in a depth-first order. DFS is also useful for problems that require backtracking or exploring all possible paths in a graph.

## When would BFS be impractical?

BFS can be impractical or inefficient for large graphs or graphs with a large branching factor. It is important to consider the specific problem and the properties of the graph when choosing a graph traversal algorithm.

- Memory usage: BFS requires storing all the vertices at a given level in memory before moving on to the next level. This means that BFS can use a large amount of memory for graphs with a large number of vertices or for graphs with a large branching factor.

- Time complexity: BFS has a time complexity of O(V + E), where V is the number of vertices and E is the number of edges in the graph. This means that BFS can be slow for graphs with a large number of vertices or for graphs with a large number of edges.

- Depth-first search: For certain problems, DFS may be a better choice than BFS. For example, DFS is often used for generating mazes and solving puzzles, as well as for problems that require backtracking or exploring all possible paths in a graph.

- Shortest path in weighted graphs: BFS can find the shortest path between two vertices in an unweighted graph. However, for weighted graphs, Dijkstra's algorithm or A\* algorithm may be more practical and efficient.

## When would DFS be impractical?

DFS can be impractical or inefficient for certain types of graphs or certain types of problems. It is important to consider the specific problem and the properties of the graph when choosing a graph traversal algorithm.

- Pathfinding in a weighted graph: DFS is not suitable for finding the shortest path between two vertices in a weighted graph since it does not consider the weights of the edges. Dijkstra's algorithm or A\* algorithm are more suitable for such problems.

- Infinite cycles or infinite paths: If the graph contains infinite cycles or infinite paths, DFS may run indefinitely, leading to a stack overflow error or an infinite loop.

- Large depth: If the graph has a large depth, DFS may visit many vertices that are not relevant to the problem, leading to wasted computation.

- Graphs with many branching paths: If the graph has many branching paths, DFS may visit a large number of vertices and edges, leading to a large computational cost.

- Applications requiring shortest paths: If the application requires finding the shortest path between two points, DFS may not be suitable since it does not guarantee that the shortest path will be found.

## What abstract data type would you use to defer/store nodes in a breadth-first tree traversal?

To perform a breadth-first tree traversal, we typically use a queue data structure to store the nodes that we need to visit next. The queue allows us to process nodes in the order that they were added to the queue, which ensures that we visit all the nodes at a given level of the tree before moving on to the next level.

As we traverse the tree, we add the children of each node to the queue, so that we can process them in the next iteration of the loop. This allows us to visit all the nodes in the tree in breadth-first order.

Using a queue to store the nodes in a breadth-first tree traversal ensures that we visit all the nodes at a given level before moving on to the next level, which can be important in some applications. It also ensures that we visit all the nodes in the tree, regardless of the tree's shape, and that we do so in a systematic and efficient way.

## What abstract data type would you use to defer/store nodes in a depth-first tree traversal?

To perform a depth-first tree traversal, we typically use a stack data structure to store the nodes that we need to visit next. The stack allows us to process nodes in the reverse order of their depth-first search, which ensures that we visit all the nodes in a given subtree before moving on to its parent.

As we traverse the tree, we add the children of each node to the top of the stack, so that we can process them first in the next iteration of the loop. This allows us to visit all the nodes in the tree in depth-first order.

Using a stack to store the nodes in a depth-first tree traversal ensures that we visit all the nodes in a given subtree before moving on to its parent, which can be important in some applications. It also ensures that we visit all the nodes in the tree, regardless of the tree's shape, and that we do so in a systematic and efficient way.

## What are the common sorting algorithms?

### Bubble Sort:

Bubble Sort is a simple sorting algorithm that repeatedly swaps adjacent elements if they are in the wrong order.
Ruby code:

```ruby
def bubble_sort(array)
  n = array.length
  loop do
    swapped = false
    (n-1).times do |i|
      if array[i] > array[i+1]
        array[i], array[i+1] = array[i+1], array[i]
        swapped = true
      end
    end
    break unless swapped
  end
  array
end
```

Strengths:

- Simple and easy to understand.
- Good for small data sets with few elements.
- It requires very little additional memory space.

Weaknesses:

- Inefficient for large data sets and takes a long time to execute.
- It has a worst-case and average-case time complexity of O(n^2), which makes it unsuitable for large data sets.

Time complexity: O(n^2) in worst-case and average-case scenarios.
Space complexity: O(1) as it is an in-place sorting algorithm that requires only a constant amount of additional memory space.

### Insertion Sort:

Insertion Sort is another simple sorting algorithm that builds the final sorted array one item at a time. It iterates through an array, comparing each element with the ones before it and inserts the current element into its correct position.
Ruby code:

```ruby
def insertion_sort(array)
  for i in 1..array.length-1
    value = array[i]
    j = i-1
    while j>=0 and array[j] > value
      array[j+1] = array[j]
      j = j-1
    end
    array[j+1] = value
  end
  array
end
```

Strengths:

- Simple and easy to implement.
- It works well with small data sets, especially if the data is almost sorted.
- It is efficient for small data sets and performs well with linked lists.

Weaknesses:

- Inefficient for large data sets and takes a long time to execute.
- It has a worst-case and average-case time complexity of O(n^2), which makes it unsuitable for large data sets.

Time complexity: O(n^2) in worst-case and average-case scenarios.
Space complexity: O(1) as it is an in-place sorting algorithm that requires only a constant amount of additional memory space.

### Quick Sort:

Quick Sort is a divide-and-conquer algorithm that partitions an array into two parts based on a pivot element, and then recursively sorts each part. It is a very efficient algorithm in practice and is often used in real-world applications.
Ruby code:

```ruby
def quick_sort(array)
  return array if array.length <= 1
  pivot = array.sample
  left, right = array.partition { |element| element < pivot }
  quick_sort(left) + quick_sort(right)
end
```

Strengths:

- Efficient sorting algorithm with a worst-case time complexity of O(n log n).
- It is widely used and well-known.
- It is an in-place sorting algorithm, which means it requires very little additional memory space.

Weaknesses:

- The worst-case time complexity is O(n^2), which can happen when the pivot chosen is always the smallest or largest element in the list.
- It is not a stable sorting algorithm, which means that the order of equal elements is not preserved.

Time complexity: O(n log n) in best-case and average-case scenarios, but O(n^2) in worst-case scenarios.
Space complexity: O(log n) on average due to the recursive nature of the algorithm, but O(n) in worst-case scenarios due to the use of the call stack.

### Selection Sort:

Selection Sort is a simple sorting algorithm that sorts an array by repeatedly finding the minimum element from the unsorted part of the array and putting it at the beginning. It is an inefficient algorithm for large lists and generally performs worse than the more complex algorithms.
Pseudocode:

```ruby
def selection_sort(array)
  n = array.length
  for i in 0...n
    min_index = i
    for j in (i+1)...n
      if array[j] < array[min_index]
        min_index = j
      end
    end
    array[i], array[min_index] = array[min_index], array[i]
  end
  array
end
```

Strengths:

- Simple and easy to understand.
- It is an in-place sorting algorithm, which means it requires very little additional memory space.

Weaknesses:

- It has a worst-case and average-case time complexity of O(n^2), which makes it inefficient for large data sets.
- It does not perform well with linked lists.

Time complexity: O(n^2) in worst-case and average-case scenarios.
Space complexity: O(1) as it is an in-place sorting algorithm that requires only a constant amount of additional memory space.

### Merge Sort:

Merge Sort is a divide-and-conquer algorithm that divides an array into two halves, sorts each half separately, and then merges the sorted halves. It is a stable, efficient algorithm that guarantees worst-case O(n log n) performance.
Pseudocode:

```ruby
def merge_sort(array)
  return array if array.length <= 1

  mid = array.length / 2
  left = merge_sort(array[0...mid])
  right = merge_sort(array[mid...array.length])

  merge(left, right)
end

def merge(left, right)
  result = []
  while !left.empty? && !right.empty?
    if left[0] <= right[0]
      result.push(left.shift)
    else
      result.push(right.shift)
    end
  end
  result.concat(left).concat(right)
end
```

Strengths:

- Stable sorting algorithm that always has a worst-case time complexity of O(n log n).
- It is efficient for large data sets.
- It is a parallelizable algorithm, which means it can take advantage of multiple cores or processors.

Weaknesses:

- It requires additional memory space for the merging step, which can be a drawback for large data sets.

Time complexity: O(n log n) in all scenarios.
Space complexity: O(n) due to the need to store the merged sub-arrays in a temporary array during the merging step.

### Heap Sort:

Heap Sort is a comparison-based sorting algorithm that uses a binary heap data structure to sort an array. It is an in-place algorithm that has a worst-case time complexity of O(n log n).
Pseudocode:

```ruby
def heap_sort(array)
  n = array.length
  build_max_heap(array, n)
  for i in (n-1).downto(1)
    array[0], array[i] = array[i], array[0]
    max_heapify(array, 0, i)
  end
  array
end

def build_max_heap(array, heap_size)
  for i in (heap_size/2-1).downto(0)
    max_heapify(array, i, heap_size)
  end
end

def max_heapify(array, i, heap_size)
  left = 2*i + 1
  right = 2*i + 2
  largest = i
  if left < heap_size && array[left] > array[largest]
    largest = left
  end
  if right < heap_size && array[right] > array[largest]
    largest = right
  end
  if largest != i
    array[i], array[largest] = array[largest], array[i]
    max_heapify(array, largest, heap_size)
  end
end
```

Strengths:

- In-place sorting algorithm that requires very little additional memory space.
- Efficient sorting algorithm with a worst-case time complexity of O(n log n).

Weaknesses:

- It is not a stable sorting algorithm, which means that the order of equal elements is not preserved.
- It has a slower average-case performance than quicksort.

Time complexity: O(n log n) in all scenarios.
Space complexity: O(1) as it is an in-place sorting algorithm that requires only a constant amount of additional memory space.

## Misc

The Algorithm Designer's Mantra

"Perhaps the most important principle for the good
algorithm designer is to refuse to be content."
-Aho, Hopcroft, and Ullman, The Design and
Analysis of Computer Algorithms, 1974

CAN WE DO BETTER?
[than the "obvious" method]
