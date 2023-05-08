# Merge Sort

Merge sort is a sorting algorithm that works by dividing an unsorted array into smaller and smaller subarrays, until each subarray contains just one element. It then merges these subarrays back together in a sorted order.

The basic idea of merge sort is to repeatedly divide the array in half until each subarray contains just one element. This is done recursively, so that each half of each subarray is itself divided in half until only single elements remain. At this point, the subarrays are sorted.

Next, adjacent subarrays are merged back together, with the smallest element in each subarray being compared and placed in the correct position in a new merged subarray. This process is repeated until all the subarrays are merged back together, resulting in a fully sorted array.

Merge sort has a time complexity of O(n log n), which means that it is efficient for sorting large arrays. However, it also has a space complexity of O(n), which means that it can be memory-intensive for very large arrays.

```ruby
on input of n elements
  if n < 2
    return
  else

  sort left half of elements
  sort right half of elements
  merge sorted halves
```

These seem simple enough but in practice it can grow messy quickly. That's because we'll keep splitting each sub-array further into left and right halves/chunks until the sub-arrays are only a single value at which point we can consider them sorted necessarily.

Once they are broken into single value chunks we can start to put the halves back together comparing each value for that specific half. Once the half is sorted we can repeat the merging process with the left and the right sub-array. What's crazy is those two sections merged together are likely just the left or right half of a sub-array further up the chain.

So this process is going to happen repeatedly starting with the smallest component parts and then merge its way back up.

The merge process works as follows:

5 2 1 3

Left half(1) 5 2
Left half(2) 5
Right half(2) 2

Is 5 or 2 smaller? 2 so plug that back into a new array corresponding with Left half(1)

Left half(1) 2

Now is 5 or the next element in the array smaller? There are no other elements so 2 is the smallest

Now we have Left half(1) 2 5 - we can already see this is more in order than it was before.

Now lets do that again with the right half of the original array 5 2 1 3

Right half(1) 1 3
Left half(2) 1
Right half(2) 3

Is 1 or 3 smaller? 1 so plug that back into a new array corresponding with Right half(1)

Right half(1) 1

Now is 3 or the next element in the array smaller? There are no other elements so 3 is the smallest

Now we have Right half(1) 1 3 - for this half it turns out it was already technically sorted.

Now we have our two sorted sub-arrays and its time to merge those together as well

Left half(1) 2 5
Right half(1) 1 3

Is 2 or 1 smaller? 1

Array 1

Is 2 or 3 smaller? 2

Array 1 2

Is 5 or 3 smaller?

Array 1 2 3

Is 5 or nothing smaller?

Array 1 2 3 5

At this point we have completed this merge sort and the array is now sorted. With larger arrays you can imagine this process might be carried out many many times at many different layers. That's what makes recursion such a great tool for this type of search.

---
