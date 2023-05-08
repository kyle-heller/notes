# Linked List

In Computer Science one of the most basic and fundamental data structures is the linked list, which functions similarly to an array. The principal benefit of a linked list over a conventional array is that the list elements can easily be inserted or removed without reallocation of any other elements.

In some programming languages the size of an array is a concern and one of the ways to overcome that problem and allow dynamically allocated data is using linked lists.

Luckily in Ruby arrays aren’t limited to a certain size, so you don’t have to think about overcoming that limitation.

So if array size is not a limitation in Ruby, are linked lists really necessary? The short answer to that is no; however, it’s the simplest of the dynamic data structures and it will give you a solid foundation, so you can understand more complex data structures like graphs and binary trees with more ease.

Structure of a Linked List
A linked list is a linear collection of data elements called nodes that “point” to the next node by means of a pointer.

Each node holds a single element of data and a link or pointer to the next node in the list.

A head node is the first node in the list, a tail node is the last node in the list. Below is a basic representation of a linked list:

[ NODE(head) ] -> [ NODE ] -> [ NODE(tail) ] -> nil

For a more thorough explanation, use these resources:

## Introduction:

Linked lists are a data structure that stores a collection of elements, where each element points to the next element in the list. Unlike arrays, linked lists do not require contiguous memory allocation, making them more flexible and efficient in certain use cases. Linked lists are particularly useful when elements need to be frequently inserted or deleted, as these operations can be done in constant time, compared to linear time in arrays.

## Singly Linked Lists:

Singly linked lists are a type of linked list in which each node has a reference to the next node in the list, but not to the previous node. Each node contains two fields: a data field to store the element, and a next field to store a reference to the next node in the list.

### Implementing Singly Linked Lists:

Here is an example implementation of a singly linked list in Ruby:

```ruby
class Node
  attr_accessor :data, :next_node

  def initialize(data)
    @data = data
    @next_node = nil
  end
end

class LinkedList
  attr_accessor :head

  def initialize
    @head = nil
  end
end
```

### Insertion and Deletion:

To add a node to the beginning of a singly linked list, we create a new node and make it the new head of the list:

```ruby
new_node = Node.new(data)
new_node.next_node = @head
@head = new_node
```

To delete a node from a singly linked list, we need to update the `next_node` reference of the previous node to skip over the node we want to delete:

```ruby
prev_node.next_node = node_to_delete.next_node
```

The time complexity for inserting or deleting a node at the beginning of a singly linked list is O(1). However, inserting or deleting a node in the middle of the list requires traversing the list to find the appropriate position, which takes O(n) time.

### Searching and Traversal:

To search for a specific node in a singly linked list, we start at the head of the list and iterate through the nodes until we find the desired node:

```ruby
current_node = @head
while current_node
  return current_node if current_node.data == target
  current_node = current_node.next_node
end
return nil
```

To traverse a singly linked list and perform an operation on each node, we can use a similar loop:

```ruby
current_node = @head
while current_node
  # perform operation on current_node
  current_node = current_node.next_node
end
```

The time complexity for searching or traversing a singly linked list is O(n).

### Advantages and Disadvantages:

The main advantage of using a singly linked list is that it allows for efficient insertion and deletion of nodes, particularly at the beginning of the list. Additionally, singly linked lists do not require contiguous memory allocation, so they can be more space-efficient than arrays in certain use cases.

However, singly linked lists have some disadvantages compared to arrays. For example, accessing an element in a singly linked list takes linear time, as we must traverse the list to find the desired element. Additionally, singly linked lists do not support constant-time indexing or slicing like arrays do.

### Use Cases:

Singly linked lists are a useful data structure in situations where frequent insertion or deletion of elements is required, particularly at the beginning of the list. Examples include implementing a stack or queue data structure, where elements are added or removed from one end of the list. Singly linked lists can also be used to represent sparse matrices or graphs,

Sure! Here's the same explanation with Ruby code examples:

## Doubly Linked Lists:

Doubly linked lists are similar to singly linked lists, except each node has two references instead of one: a reference to the next node and a reference to the previous node. This allows for more efficient deletion and insertion operations in the middle of the list, as we can easily update the references of the adjacent nodes.

### Implementing Doubly Linked Lists:

Here is an example implementation of a doubly linked list in Ruby:

```ruby
class Node
  attr_accessor :data, :next_node, :prev_node

  def initialize(data = nil)
    @data = data
    @next_node = nil
    @prev_node = nil
  end
end

class DoublyLinkedList
  attr_accessor :head, :tail

  def initialize
    @head = nil
    @tail = nil
  end
end
```

### Insertion and Deletion:

To add a node to the beginning of a doubly linked list, we create a new node, update its `next_node` reference to the current head, and update the head's `prev_node` reference to the new node:

```ruby
new_node = Node.new(data)
new_node.next_node = @head
if @head
  @head.prev_node = new_node
end
@head = new_node
```

To delete a node from a doubly linked list, we update the `next_node` reference of the previous node to point to the next node, and the `prev_node` reference of the next node to point to the previous node:

```ruby
prev_node.next_node = node_to_delete.next_node
if node_to_delete.next_node
  node_to_delete.next_node.prev_node = prev_node
end
```

The time complexity for inserting or deleting a node at the beginning or end of a doubly linked list is O(1). Inserting or deleting a node in the middle of the list also takes O(1) time, as we only need to update the references of adjacent nodes.

### Searching and Traversal:

Searching and traversal in a doubly linked list is similar to a singly linked list, except we can also traverse backwards using the `prev_node` reference:

```ruby
current_node = @head
while current_node
  # perform operation on current_node
  current_node = current_node.next_node
end

current_node = @tail
while current_node
  # perform operation on current_node
  current_node = current_node.prev_node
end
```

The time complexity for searching or traversing a doubly linked list is O(n).

### Advantages and Disadvantages:

Doubly linked lists have the same advantages as singly linked lists for efficient insertion and deletion of nodes, but with the added advantage of being able to perform these operations efficiently in the middle of the list. Additionally, doubly linked lists allow for efficient traversal in both directions.

However, doubly linked lists have some disadvantages compared to singly linked lists. They require more memory to store the additional `prev_node` references, and they are more complex to implement and maintain.

### Use Cases:

Doubly linked lists are useful in situations where frequent insertion or deletion of elements is required, particularly in the middle of the list. They can be used to implement a variety of data structures, including doubly ended queues, circular lists, and hash tables. They are also used in some memory allocation schemes, such as in the implementation of the malloc/free functions in the C programming language.

## Circular Linked Lists:

Circular linked lists are similar to singly or doubly linked lists, except the last node's reference points back to the first node, forming a loop. This allows for efficient traversal of the list, as we can start at any node and loop through the entire list without needing to check for the end of the list.

### Implementing Circular Linked Lists:

Here is an example implementation of a circular linked list in Ruby:

```ruby
class Node
  attr_accessor :data, :next_node

  def initialize(data = nil)
    @data = data
    @next_node = nil
  end
end

class CircularLinkedList
  attr_accessor :head

  def initialize
    @head = nil
  end
end
```

### Insertion and Deletion:

Inserting a node into a circular linked list is similar to a singly linked list. To add a node to the beginning of the list, we create a new node and update its `next_node` reference to the current head. To add a node to the end of the list, we traverse the list until we reach the last node and update its `next_node` reference to the new node.

To delete a node from a circular linked list, we update the `next_node` reference of the previous node to point to the next node, as with a singly linked list. If we delete the last node in the list, we need to update the `next_node` reference of the new last node to point to the first node.

```ruby
# Add node to beginning of list
new_node = Node.new(data)
new_node.next_node = @head
@head = new_node

# Add node to end of list
new_node = Node.new(data)
if @head.nil?
  @head = new_node
else
  current_node = @head
  while current_node.next_node != @head
    current_node = current_node.next_node
  end
  current_node.next_node = new_node
end

# Delete node
if @head == node_to_delete
  @head = node_to_delete.next_node
end
current_node = @head
while current_node.next_node != node_to_delete
  current_node = current_node.next_node
end
current_node.next_node = node_to_delete.next_node
```

The time complexity for insertion or deletion at the beginning or end of a circular linked list is O(1). Inserting or deleting a node in the middle of the list takes O(n) time, as we need to traverse the list to find the correct position.

### Searching and Traversal:

Searching and traversal in a circular linked list is similar to a singly or doubly linked list, except we need to check for the end of the list by comparing the current node's `next_node` reference to the head of the list:

```ruby
current_node = @head
while current_node
  # perform operation on current_node
  current_node = current_node.next_node
  break if current_node == @head
end
```

The time complexity for searching or traversal of a circular linked list is O(n).

### Advantages and Disadvantages:

Circular linked lists have the advantage of being able to efficiently traverse the entire list without needing to check for the end of the list. They are useful in situations where we need to repeatedly loop through the entire list, such as in scheduling algorithms or for circular buffers.

However, circular linked lists also have some disadvantages. They can be more complex to implement and maintain compared to singly or doubly linked lists. Additionally, if we have a reference to a node in the list, we need to be careful to ensure that we don't accidentally create an infinite loop by following the `next_node`
