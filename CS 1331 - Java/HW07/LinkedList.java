package HW07;



public class LinkedList<E> implements List<E> {

    Node<E> head;
    Node<E> tail;
    int size = 0;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public Node<E> getHead(){
      return this.head;
    }

    public Node<E> getTail(){
      return this.tail;
    }

    public class Node<E> {
      E data;
      Node<E> next;
    
      public Node(E data) {
        this(data, null);
      }

      public Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
      }

      public E getData() {
        return this.data;
      }
      public void setData(E newData) {
        this.data = newData;
      }

      public Node<E> getNext() {
        return this.next;
      }
      public void setNext(Node<E> newNext) {
        this.next = newNext;
      }
    
    }


    @Override
    public void addAtIndex(E data, int index) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'addAtIndex'");
    }

    @Override
    public E getAtIndex(int index) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getAtIndex'");
    }

    @Override
    public E removeAtIndex(int index) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'removeAtIndex'");
    }

    @Override
    public E remove(E data) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public void clear() {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

    @Override
    public boolean isEmpty() {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    public int size() {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    public static void main(String[] args) {
      LinkedList<String> list1 = new LinkedList<>();
      System.out.println(list1);
      System.out.println(list1.head.data);
    }
}

