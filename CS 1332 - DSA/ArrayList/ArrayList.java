import java.util.NoSuchElementException;

/**
 * Your implementation of an ArrayList.
 */
public class ArrayList<T> {

  /*
   * The initial capacity of the ArrayList.
   *
   * DO NOT MODIFY THIS VARIABLE!
   */
  public static final int INITIAL_CAPACITY = 9;

  /*
   * Do not add new instance variables or modify existing ones.
   */
  private T[] backingArray;
  private int size;

  /**
   * This is the constructor that constructs a new ArrayList.
   * 
   * Recall that Java does not allow for regular generic array creation,
   * so instead we cast an Object[] to a T[] to get the generic typing.
   */
  public ArrayList() {
      //DO NOT MODIFY THIS METHOD!
      backingArray = (T[]) new Object[INITIAL_CAPACITY];
  }

  /**
   * Adds the data to the front of the list.
   *
   * This add may require elements to be shifted.
   *
   * Method should run in O(n) time.
   *
   * @param data the data to add to the front of the list
   * @throws java.lang.IllegalArgumentException if data is null
   */
  public void addToFront(T data) {
      // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
              if (data == null) {
        throw new IllegalArgumentException("Data cannot be null");
      }
      else if (size == 0) {
      backingArray[0] = data;
      size++;
      } 
      else if (size != 0 && size < backingArray.length) {
        // Iterate through moving data to the right
        for (int i = backingArray.length - 1; i > 0; i--) {
            backingArray[i] = backingArray[i-1];
        }
        backingArray[0] = data;
        size++;
    }
    else if (size != 0 && size == backingArray.length) {
      T[] newArray = (T[]) new Object[backingArray.length*2];
      newArray[0] = data;

      for (int i = backingArray.length; i > 0; i--) {
        newArray[i] = backingArray[i-1];
      }
      size++;
      backingArray = newArray;
    }


  }

  /**
   * Adds the data to the back of the list.
   *
   * Method should run in amortized O(1) time.
   *
   * @param data the data to add to the back of the list
   * @throws java.lang.IllegalArgumentException if data is null
   */
  public void addToBack(T data) {
      // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
      if (data == null) {
        throw new IllegalArgumentException("Data cannot be null");
      }
      else if (size == 0) {
      backingArray[size] = data;
      size++;
      } 
      else if (size != 0 && size < backingArray.length) {
        backingArray[size] = data;
        size++;
    }
    else if (size != 0 && size == backingArray.length) {
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
   * Removes and returns the first data of the list.
   *
   * Do not shrink the backing array.
   *
   * This remove may require elements to be shifted.
   *
   * Method should run in O(n) time.
   *
   * @return the data formerly located at the front of the list
   * @throws java.util.NoSuchElementException if the list is empty
   */
  public T removeFromFront() {
      // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
if (size == 0) {
        throw new NoSuchElementException("No such element");
      } 
      else if (size != 0) {
        // Iterate through moving data to the left
        T oldValue =  backingArray[0];

        for (int i = 1; i < backingArray.length; i++) {
            backingArray[i-1] = backingArray[i];
        }
        if (size == backingArray.length) {
          backingArray[size-1] = null;
        }
        size--;
        return oldValue;
      }
      else {
        return null;
      }
  }

  /**
   * Removes and returns the last data of the list.
   *
   * Do not shrink the backing array.
   *
   * Method should run in O(1) time.
   *
   * @return the data formerly located at the back of the list
   * @throws java.util.NoSuchElementException if the list is empty
   */
  public T removeFromBack() {
      // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
if (size == 0) {
        throw new NoSuchElementException("No such element");
      } else if (size > 0) {
        T oldValue =  backingArray[size-1];
        backingArray[size-1] = null;
        size--;
        return oldValue;
      }
      else {
        return null;
      }
  }

  /**
   * Returns the backing array of the list.
   *
   * For grading purposes only. You shouldn't need to use this method since
   * you have direct access to the variable.
   *
   * @return the backing array of the list
   */
  public T[] getBackingArray() {
      // DO NOT MODIFY THIS METHOD!
      return backingArray;
  }

  /**
   * Returns the size of the list.
   *
   * For grading purposes only. You shouldn't need to use this method since
   * you have direct access to the variable.
   *
   * @return the size of the list
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
      ArrayList<String> stringList = new ArrayList<>();
      System.out.println(stringList.size());

      // stringList.removeFromFront();
      // // stringList.removeFromBack();

      stringList.addToFront("1a");
      System.out.println(stringList.size());

      stringList.addToBack("2a");

      System.out.println(stringList.size());
      stringList.addToBack("3a");

      System.out.println(stringList.size());
      stringList.addToBack("4a");

      System.out.println(stringList.size());
      stringList.addToBack("5a");

      System.out.println(stringList.size());
      stringList.addToBack("6a");

      System.out.println(stringList.size());
      stringList.addToBack("7a");

      System.out.println(stringList.size());
      stringList.addToBack("8a");

      System.out.println(stringList.size());
      stringList.addToBack("9a");

      System.out.println(stringList.toString());
      System.out.println(stringList.size());

      // stringList.removeFromFront();
      stringList.removeFromBack();

      System.out.println(stringList.toString());
      System.out.println(stringList.size());


// [Test Failure: removeFromFront] [-0.43] : NoSuchElementException not thrown when attempting to remove from the front an empty ArrayList. 

// [Test Failure: removeFromFront] [-0.43] : Unexpected content after removing once from the front of a full ArrayList.
// 	Expected : [1a, 2a, 3a, 4a, 5a, 6a, 7a, 8a, null]
// 	Actual : [1a, 2a, 3a, 4a, 5a, 6a, 7a, 8a, 8a] 

// [Test Failure: removeFromBack] [-0.43] : NoSuchElementException not thrown when attempting to remove from the back of an empty ArrayList. 

// [Test Failure: validSize] [-0.43] : Size variable could not be validated for the following method(s) due to early test failure(s): removeFromBack. 

      // System.out.println(stringList.size());
    }
}