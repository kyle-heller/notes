import java.util.NoSuchElementException;

/**
 * Your implementation of an ArrayQueue.
 */
public class ArrayQueue<T> {

    /*
     * The initial capacity of the ArrayQueue.
     *
     * DO NOT MODIFY THIS VARIABLE.
     */
    public static final int INITIAL_CAPACITY = 3;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int front;
    private int size;

    /**
     * This is the constructor that constructs a new ArrayQueue.
     * 
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast an Object[] to a T[] to get the generic typing.
     */
    public ArrayQueue() {
        // DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Adds the data to the back of the queue.
     *
     * If sufficient space is not available in the backing array, resize it to
     * double the current length. When resizing, copy elements to the
     * beginning of the new array and reset front to 0.
     *
     * Method should run in amortized O(1) time.
     *
     * @param data the data to add to the back of the queue
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void enqueue(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        int back = (front + size) % backingArray.length;
        if (size == 0) {
            backingArray[0] = data;
            size++;
        } else if (size < backingArray.length) {
            backingArray[back] = data;
            size++;
        } else if (size == backingArray.length) {
            T[] newArray = (T[]) new Object[backingArray.length*2];

            for (int i = backingArray.length; i > 0; i--) {
            newArray[i-1] = backingArray[i-1];
            }
            size++;
            newArray[size-1] = data;
            backingArray = newArray;
        }
    }

    /**
     * Removes and returns the data from the front of the queue.
     *
     * Do not shrink the backing array.
     *
     * Replace any spots that you dequeue from with null.
     *
     * If the queue becomes empty as a result of this call, do not reset
     * front to 0.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the front of the queue
     * @throws java.util.NoSuchElementException if the queue is empty
     */
    public T dequeue() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        int back = (front + size) % backingArray.length;
        T temp = backingArray[front];
        if (size == 0) {
            throw new NoSuchElementException("No such element");
        } else {
            backingArray[front] = null;
            size--;
            front++;
        }
        return null;

    }

    /**
     * Returns the backing array of the queue.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the backing array of the queue
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the queue.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the queue
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    public String toString() {
        String string = "";
        for (int i = 0; i < backingArray.length; i++) {
          string += backingArray[i] + "\n";
        }
        return string;
      }

      public static void main(String[] args) {
        ArrayQueue<String> stringList = new ArrayQueue<>();
        stringList.enqueue("one");
        System.out.println(stringList);
        stringList.enqueue("two");
        System.out.println(stringList);
        stringList.enqueue("three");
        System.out.println(stringList);
        stringList.enqueue("four");
        System.out.println(stringList);

        stringList.dequeue();
        System.out.println(stringList);

        stringList.dequeue();
        System.out.println(stringList);

        stringList.dequeue();
        System.out.println(stringList);

        // stringList.dequeue();
        // System.out.println(stringList);

        // stringList.dequeue();
        // System.out.println(stringList);


      }
}