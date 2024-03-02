import java.util.NoSuchElementException;

/**
 * Your implementation of a Singly-Linked List.
 */
public class SinglyLinkedList<T> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private SinglyLinkedListNode<T> head;
    private SinglyLinkedListNode<T> tail;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the element to the front of the list.
     *
     * Method should run in O(1) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    if (data == null) {
        throw new IllegalArgumentException("Data cannot be null");
    } else if (head == null) {
        SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<>(data);
        head = newNode;
        tail = newNode;
        size++;  // Increment the size
    } else if (head != null) {
        SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<>(data);
        newNode.setNext(head);
        head = newNode;
        size++;  // Increment the size
    }
    }

    /**
     * Adds the element to the back of the list.
     *
     * Method should run in O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        } else if (head == null) {
            SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<>(data);
            head = newNode;
            tail = newNode;
            size++;  // Increment the size
        } else if (head != null) {
            SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<>(data);
            tail.setNext(newNode);
            tail = newNode;
            size++;  // Increment the size
        }
    }

    /**
     * Removes and returns the first data of the list.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    SinglyLinkedListNode<T> previous;
    if (head == null) {
        throw new NoSuchElementException("No such element");
    } else if (head != null){
        if (head.getNext() == null) {
            tail = null;
        }
        previous = head;
        head = head.getNext();
        size--;
        return previous.getData(); // Corrected line
    }
    return null;
    }

    /**
     * Removes and returns the last data of the list.
     *
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    SinglyLinkedListNode<T> previous;
    SinglyLinkedListNode<T> current = head;
    if (head == null) {
        throw new NoSuchElementException("No such element");
    } else if (head.getNext() == null) {
        previous = head;
        head = null;
        tail = null;
        size--;
        return previous.getData(); // Corrected line
    } else {
        while (current.getNext() != null && current.getNext().getNext() != null) {
            current = current.getNext();
        }
        previous = current.getNext();
        current.setNext(null);
        tail = current;
        size--;
        return previous.getData(); // Corrected line
    }
    }


    /**
     * Returns the head node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the head of the list
     */
    public SinglyLinkedListNode<T> getHead() {
        // DO NOT MODIFY THIS METHOD!
        return head;
    }

    /**
     * Returns the tail node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the tail of the list
     */
    public SinglyLinkedListNode<T> getTail() {
        // DO NOT MODIFY THIS METHOD!
        return tail;
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
        String answer = "";
        SinglyLinkedListNode<T> current = head;
        while (current != null) {
            answer += current + " ";
            current = current.getNext();
        }
        return answer;
      }


public class SinglyLinkedListNode<T> {

  public T data;
  public SinglyLinkedListNode<T> next;

  /**
   * Constructs a new SinglyLinkedListNode with the given data and next node
   * reference.
   *
   * @param data the data stored in the new node
   * @param next the next node in the list
   */
  SinglyLinkedListNode(T data, SinglyLinkedListNode<T> next) {
      this.data = data;
      this.next = next;
  }

  /**
   * Creates a new SinglyLinkedListNode with only the given data.
   *
   * @param data the data stored in the new node
   */
  SinglyLinkedListNode(T data) {
      this(data, null);
  }

  /**
   * Gets the data.
   *
   * @return the data
   */
  T getData() {
      return data;
  }

  /**
   * Gets the next node.
   *
   * @return the next node
   */
  SinglyLinkedListNode<T> getNext() {
      return next;
  }

  /**
   * Sets the next node.
   *
   * @param next the new next node
   */
  void setNext(SinglyLinkedListNode<T> next) {
      this.next = next;
  }

  public String toString() {
    return (String)data;
  }

}

public static void main(String[] args) {
    SinglyLinkedList<String> intList = new SinglyLinkedList<>();
    intList.addToFront("i'm the back!");
    intList.addToFront("i'm the front!");

    intList.addToBack("i'm even further back!");
    System.out.println(intList.toString());
    System.out.println(intList.size());



    intList.removeFromBack();
    System.out.println(intList.toString());
    System.out.println(intList.size());


    intList.removeFromBack();
    System.out.println(intList.toString());
    System.out.println(intList.size());


    intList.removeFromBack();
    System.out.println(intList.toString());
    System.out.println(intList.size());


 

  }

}