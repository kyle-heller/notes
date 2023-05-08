# Sorting Algorithms

## Bubble Sort:

Bubble Sort is a simple sorting algorithm that repeatedly swaps adjacent elements if they are in the wrong order.
Ruby code:

```
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

## Insertion Sort:

Insertion Sort is another simple sorting algorithm that builds the final sorted array one item at a time. It iterates through an array, comparing each element with the ones before it and inserts the current element into its correct position.
Ruby code:

```
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

## Quick Sort:

Quick Sort is a divide-and-conquer algorithm that partitions an array into two parts based on a pivot element, and then recursively sorts each part. It is a very efficient algorithm in practice and is often used in real-world applications.
Ruby code:

```
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

## Selection Sort:

Selection Sort is a simple sorting algorithm that sorts an array by repeatedly finding the minimum element from the unsorted part of the array and putting it at the beginning. It is an inefficient algorithm for large lists and generally performs worse than the more complex algorithms.
Pseudocode:

```
function selection_sort(array)
    n = length(array)
    for i = 0 to n-1 do
        min_index = i
        for j = i+1 to n-1 do
            if array[j] < array[min_index] then
                min_index = j
            end if
        end for
        swap(array[i], array[min_index])
    end for
end function
```

Strengths:

- Simple and easy to understand.
- It is an in-place sorting algorithm, which means it requires very little additional memory space.

Weaknesses:

- It has a worst-case and average-case time complexity of O(n^2), which makes it inefficient for large data sets.
- It does not perform well with linked lists.

Time complexity: O(n^2) in worst-case and average-case scenarios.
Space complexity: O(1) as it is an in-place sorting algorithm that requires only a constant amount of additional memory space.

## Merge Sort:

Merge Sort is a divide-and-conquer algorithm that divides an array into two halves, sorts each half separately, and then merges the sorted halves. It is a stable, efficient algorithm that guarantees worst-case O(n log n) performance.
Pseudocode:

```
function merge_sort(array)
    if length(array) <= 1 then
        return array
    end if
    mid = length(array) / 2
    left = merge_sort(array[0..mid-1])
    right = merge_sort(array[mid..length(array)-1])
    return merge(left, right)
end function

function merge(left, right)
    result = []
    while left.length > 0 and right.length > 0 do
        if left[0] <= right[0] then
            result.push(left.shift)
        else
            result.push(right.shift)
        end if
    end while
    result.concat(left).concat(right)
end function
```

Strengths:

- Stable sorting algorithm that always has a worst-case time complexity of O(n log n).
- It is efficient for large data sets.
- It is a parallelizable algorithm, which means it can take advantage of multiple cores or processors.

Weaknesses:

- It requires additional memory space for the merging step, which can be a drawback for large data sets.

Time complexity: O(n log n) in all scenarios.
Space complexity: O(n) due to the need to store the merged sub-arrays in a temporary array during the merging step.

## Heap Sort:

Heap Sort is a comparison-based sorting algorithm that uses a binary heap data structure to sort an array. It is an in-place algorithm that has a worst-case time complexity of O(n log n).
Pseudocode:

```
function heap_sort(array)
    build_max_heap(array)
    n = length(array)
    for i = n-1 down to 1 do
        swap(array[0], array[i])
        max_heapify(array, 0, i)
    end for
end function

function build_max_heap(array)
    n = length(array)
    for i = floor(n/2) down to 0 do
        max_heapify(array, i, n)
    end for
end function

function max_heapify(array, i, heap_size)
    left = 2*i + 1
    right = 2*i + 2
    largest = i
    if left < heap_size and array[left] > array[largest] then
        largest = left
    end if
    if right < heap_size and array[right] > array[largest] then
        largest = right
    end if
    if largest != i then
        swap(array[i], array[largest])
        max_heapify(array, largest, heap_size)
    end if
end function
```

Strengths:

- In-place sorting algorithm that requires very little additional memory space.
- Efficient sorting algorithm with a worst-case time complexity of O(n log n).

Weaknesses:

- It is not a stable sorting algorithm, which means that the order of equal elements is not preserved.
- It has a slower average-case performance than quicksort.

Time complexity: O(n log n) in all scenarios.
Space complexity: O(1) as it is an in-place sorting algorithm that requires only a constant amount of additional memory space.
