# Binary Search Tree

A binary search tree is a data structure that is used to organize a collection of elements in a way that allows for efficient search, insertion, and deletion of elements. The structure is called a "binary" search tree because each node in the tree has at most two children.

The idea behind a binary search tree is that each node in the tree has a key value, which is used to determine the position of the node in the tree. Nodes with smaller key values are placed to the left of the parent node, and nodes with larger key values are placed to the right.

One important property of a binary search tree is that the left subtree of any node contains only keys that are less than the key of the node, and the right subtree of any node contains only keys that are greater than the key of the node. This property allows for efficient searching of the tree, as it is possible to eliminate half of the remaining nodes at each step of the search.

Overall, binary search trees are a powerful data structure that can be used to store and retrieve data quickly and efficiently. However, the actual mechanics of how the tree is constructed and maintained can be quite complex, involving concepts such as balancing, rotation, and traversal algorithms.

## Elements of a Binary Tree

```
           4
         /   \
        2     6
       / \   / \
      1   3 5   7
```

- The `root` of the tree is the topmost node, which in this case is labeled with the number 4.
- Each `node` in the tree holds a value and has zero, one, or two `child` nodes.
- `Leaf nodes` are nodes that have no children, such as nodes 1, 3, 5, and 7 in this tree.
- The `height` of the tree is the length of the longest path from the root to a leaf node. In this case, the height of the tree is 2.
- The `depth` of a node is the length of the path from the root to that node. The root node has depth 0, and the depth increases by 1 as you move down the tree.
- `Parent` nodes have child nodes that are directly below them in the tree. For example, node 4 is the parent of nodes 2 and 6.
- `Sibling` nodes have the same parent. For example, nodes 2 and 6 are siblings.
- A `binary tree` is a tree data structure in which each node has at most two child nodes, often referred to as the `left` child and the `right` child.

## Traversal

Consider the following binary search tree:

```
       8
     /   \
    3     10
   / \      \
  1   6     14
     / \   /
    4   7 13
```

1. Inorder Traversal (Left, Root, Right): In inorder traversal, we visit the left subtree, then the root node, and then the right subtree. Inorder traversal of a BST will give you a sorted list. For this binary search tree, the inorder traversal would be:

   ```
   1 3 4 6 7 8 10 13 14
   ```

2. Preorder Traversal (Root, Left, Right): In preorder traversal, we visit the root node, then the left subtree, and then the right subtree. For this binary search tree, the preorder traversal would be:

   ```
   8 3 1 6 4 7 10 14 13
   ```

3. Postorder Traversal (Left, Right, Root): In postorder traversal, we visit the left subtree, then the right subtree, and then the root node. For this binary search tree, the postorder traversal would be:

   ```
   1 4 7 6 3 13 14 10 8
   ```

Note that the order of nodes visited for each traversal method is different, but they all visit every node in the tree exactly once.

## BFS vs DFS

Inorder, Preorder, and Postorder traversals are all examples of depth-first search (DFS) because they explore the depth of the tree first.

Breadth-first search (BFS) is a different type of traversal that explores the tree level by level, starting at the root node and moving down to each successive level.

So, inorder, preorder, and postorder traversals are all depth-first search algorithms, while level-order (which is another name for BFS) is a breadth-first search algorithm.

# Balanced Binary Search Tree

Balanced search trees (BSTs) are a type of binary search tree that automatically adjusts its shape to maintain a balanced structure. A binary search tree is a tree-based data structure that maintains a sorted set of values in which each node has at most two children, and the left subtree contains values smaller than the node's value while the right subtree contains values greater than the node's value. A BST allows fast operations for lookup, insertion, and deletion of data items.

So, while all balanced search trees are binary search trees, not all binary search trees are necessarily balanced. In a balanced search tree, the heights of the left and right subtrees of any node differ by at most one, ensuring that the tree is always reasonably well-balanced. This balance improves the performance of the search and other operations on the tree.

Therefore, balanced search trees are a specific type of binary search tree that maintains a balanced structure, while BSTs in general can be balanced or unbalanced.

## Pseudocode and Implementation

### Recursive Approach

The idea is to find the middle element of the array and make it the root of the tree, then perform the same operation on the left subarray for the root’s left child and the same operation on the right subarray for the root’s right child.

Follow the steps mentioned below to implement the approach:

- Set The middle element of the array as root.
- Recursively do the same for the left half and right half.
  - Get the middle of the left half and make it the left child of the root created in step 1.
  - Get the middle of the right half and make it the right child of the root created in step 1.
- Print the preorder of the tree.

### Time Complexity

Time Complexity: O(N)
Auxiliary Space: O(H) ~= O(log(N)), for recursive stack space where H is the height of the tree.

### Using queue – Iterative Approach

1. First initialize a queue with root node and loop until the queue is empty.
2. Remove first node from the queue and find mid element of the sorted array.
3. Create new node with previously find middle node and set left child to the deque node left child if present and also set the right child with deque node right child. Enqueue the new node onto the queue. Set the right child of the dequeued node to the middle element on the left side of the sorted array. If the dequeued node has a left child, enqueue it onto the queue. Return the root node.

### Time Complexity

Time Complexity: O(N), where N is the number of elements in array.
Auxiliary Space: O(N)
