# Graphs

Graphs are a fundamental data structure used to model relationships between objects. A graph is composed of a set of vertices (also called nodes) and a set of edges (also called links or arcs) connecting these vertices. In Ruby, you can represent a graph using various data structures, but the most common ones are:

1. Adjacency Matrix: A two-dimensional array where the value of matrix[i][j] represents the weight of the edge connecting vertex i to vertex j. If there is no edge between vertices i and j, the value should be 0 or nil.

2. Adjacency List: A hash where each key represents a vertex, and its corresponding value is an array of vertices that it is connected to. If the edges have weights, you can store them in a nested array or a hash.

Here's an example of how to represent a simple graph using an adjacency matrix and an adjacency list:

## Adjacency Matrix

An adjacency matrix is a way to represent a graph as a matrix, where the rows and columns represent the vertices in the graph, and the values in the matrix represent the edges between them. If the edges have weights, the values can be the weights instead of 1 or 0.

Here's an example of a graph represented as an adjacency matrix:

```ruby
# A graph with 4 vertices and 5 edges
# 0--1
# | /|
# |/ |
# 2--3
adj_matrix = [
  [0, 1, 1, 0],  # vertex 0 is connected to vertices 1 and 2
  [1, 0, 1, 1],  # vertex 1 is connected to vertices 0, 2, and 3
  [1, 1, 0, 1],  # vertex 2 is connected to vertices 0, 1, and 3
  [0, 1, 1, 0]   # vertex 3 is connected to vertices 1 and 2
]
```

In this example, the adjacency matrix is a 4x4 matrix, where the rows and columns correspond to the four vertices in the graph. The entry at `adj_matrix[i][j]` represents the edge between vertex `i` and vertex `j`. In this case, the value is 1 if there is an edge connecting the two vertices, and 0 otherwise. For example, `adj_matrix[0][1]` is 1, indicating that there is an edge between vertex 0 and vertex 1.

One advantage of using an adjacency matrix representation is that it makes it easy to check whether two vertices are connected or not, simply by checking the value at `adj_matrix[i][j]`. However, it can be less space-efficient than other representations, especially for sparse graphs.

## Adjacency List

An adjacency list is another way to represent a graph, where each vertex is associated with a list of its neighboring vertices. If the edges have weights, the adjacency list can include the weights as well.

Here's an example of a graph represented as an adjacency list:

```ruby
# A graph with 4 vertices and 5 edges
# 0--1
# | /|
# |/ |
# 2--3
adj_list = {
  0 => [1, 2],  # vertex 0 is connected to vertices 1 and 2
  1 => [0, 2, 3],  # vertex 1 is connected to vertices 0, 2, and 3
  2 => [0, 1, 3],  # vertex 2 is connected to vertices 0, 1, and 3
  3 => [1, 2]   # vertex 3 is connected to vertices 1 and 2
}
```

In this example, the adjacency list is a hash where the keys are the vertices in the graph and the values are lists of the vertices that each vertex is connected to. For example, the key `0` has a value of `[1, 2]`, indicating that vertex 0 is connected to vertices 1 and 2.

One advantage of using an adjacency list representation is that it is space-efficient for sparse graphs, where only a small fraction of possible edges actually exist. It also makes it easy to find all the neighboring vertices of a given vertex, simply by looking up the corresponding value in the hash. However, it can be less efficient for certain graph algorithms that require information about all the edges in the graph.

## Edge Lists

An edge list is a simple way to represent a graph as a list of edges, where each edge is represented as a tuple or an array of two vertices that it connects. If the edges have weights, the weight can be included as a third element in the tuple or array.

Here's an example of a graph represented as an edge list:

```ruby
# A graph with 4 vertices and 5 edges
# 0--1
# | /|
# |/ |
# 2--3
edges = [
  [0, 1],  # edge connecting vertices 0 and 1
  [0, 2],  # edge connecting vertices 0 and 2
  [1, 2],  # edge connecting vertices 1 and 2
  [1, 3],  # edge connecting vertices 1 and 3
  [2, 3]   # edge connecting vertices 2 and 3
]
```

In this example, the edge list consists of five tuples, where each tuple represents an edge in the graph. For example, the first tuple `[0, 1]` represents the edge that connects vertex `0` and vertex `1`.

One advantage of using an edge list representation is that it is space-efficient, as it only stores the edges and not the vertices. This can be useful when dealing with very large graphs. However, it can be less efficient for certain graph algorithms that require information about the vertices as well as the edges.
