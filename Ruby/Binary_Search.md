# Binary Search

Overview: https://www.youtube.com/watch?v=T98PIp4omUA

In binary search, the idea of the algorithm is to divide and conquer, reducing the search area by half each time, trying to find a target number.

In order to leverage this power however, our array must first be sorted, else we cannot make assumptions about the array's contents (aka greater or less than value).

### Worst-case scenario:

We have to divide a list of n elements in half repeatedly to find the target element, either because the target element will be found at the end of the last division or doesn't exist in the array at all.

Log(n)

### Best-case scenario

The target element is the midpoint of the full array, and so we can stop looking immediately after start.

Ω(1)

## Pseudocode

Repeat until the (sub)array is of size 0:

1. Calculate the middle point of the current (sub)array.
2. If the target is at the middle, stop.
3. Otherwise, if the target is less than what's at the middle, repeat, changing the end point to be just to the left of the middle.
4. Otherwise, if the target is greater than what's at the middle, repeat, changing the start point to be just to the right of the middle.

### Example where target is in the array:

| Target | Start | End |
| ------ | :---: | --: |
| 0      |   0   |   0 |

| 11  | 23  |   8 | 14  | 30  | 9   | 6   | 17  | 22  | 28  | 25  | 15  | 7   | 10  | 19  |
| --- | :-: | --: | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |

First we need to sort so that we can make assumptions about the array.

| 6   |  7  |   8 | 9   | 10  | 11  | 14  | 15  | 17  | 19  | 22  | 23  | 25  | 28  | 30  |
| --- | :-: | --: | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| 0   |  1  |   2 | 3   | 4   | 5   | 6   | 7   | 8   | 9   | 10  | 11  | 12  | 13  | 14  |

Now that the array is sorted.
Fill in the target, fill in the start and end, find the midpoint ((start + end) / 2)

| Target | Start | End | Mid |
| ------ | :---: | --: | --: |
| 19     |   0   |  14 |   7 |

| 6   |  7  |   8 | 9   | 10  | 11  | 14  | 15  | 17  | 19  | 22  | 23  | 25  | 28  | 30   |
| --- | :-: | --: | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | ---- |
| S 0 |  1  |   2 | 3   | 4   | 5   | 6   | M 7 | 8   | 9   | 10  | 11  | 12  | 13  | E 14 |

Is the value of array[mid] what we are looking for?
Array[7] is 15 and we are looking for 19.
The target 19 is greater than the middle value 15
So we change the start point to be just to the right of the midpoint and repeat the process.

| Target | Start | End | Mid |
| ------ | :---: | --: | --: |
| 19     |   8   |  14 |  11 |

So now we've elminated over half the problem. So now instead of searching over 15 we can just search over 7.
| 17 | 19 | 22 | 23 | 25 | 28 | 30 |
| :---: | --- | --- | ---- | --- | --- | ----: |
| S 8 | 9 | 10 | M 11 | 12 | 13 | E 14 |

Is the value of Array[11] what we are looking for?
The target 19 is less than the middle value 23
So we change the end point to be just to the left of the midpoint and repeat the process.

| Target | Start | End | Mid |
| ------ | :---: | --: | --: |
| 19     |   8   |  10 |   9 |

| 17  | 19  | 22   |
| --- | --- | ---- |
| S 8 | M 9 | E 10 |

Is the value of Array[9] what we are looking for?
The target 19 equals the midpoint value 19 so we have found our target and we can stop.

### Example where target is not in the array:

| Target | Start | End | Mid |
| ------ | :---: | --: | --: |
| 40     |   0   |   6 |   3 |

| 6   |  7  |   8 | 9   | 10  | 11  | 14  |
| --- | :-: | --: | --- | --- | --- | --- |
| S 0 |  1  |   2 | M 3 | 4   | 5   | E 6 |

Is the value of array[mid] what we are looking for?
Array[3] is 9 and we are looking for 40.
The target 40 is greater than the middle value 9
So we change the start point to be just to the right of the midpoint and repeat the process.

| Target | Start | End | Mid |
| ------ | :---: | --: | --: |
| 40     |   4   |   6 |   5 |

| 10  | 11  | 14  |
| --- | --- | --- |
| S 4 | M 5 | E 6 |

Is the value of array[mid] what we are looking for?
Array[5] is 11 and we are looking for 40.
The target 40 is greater than the middle value 11
So we change the start point to be just to the right of the midpoint and repeat the process.

| Target | Start | End | Mid |
| ------ | :---: | --: | --: |
| 40     |   6   |   6 |   6 |

| 14    |
| ----- |
| SME 6 |

Is the value of array[mid] what we are looking for?
Array[5] is 14 and we are looking for 40.
The target 40 is greater than the middle value 14
So we change the start point to be just to the right of the midpoint and repeat the process.

Well now the start point would be greater than the end point. The two ends of our array have crossed over and this would indicate that the target is not in the array. Aka we have a subarray of size 0.

| Target | Start | End | Mid |
| ------ | :---: | --: | --: |
| 40     |   7   |   6 |   6 |
