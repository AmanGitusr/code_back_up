package StructureData;

import java.util.Arrays;
import java.util.NoSuchElementException;
public class MyLinkedList {
    public static void main(String[] args) {
        var list = new MyLinkedList();
        list.addLast(12); //1
        list.addLast(23); //2
        list.addLast(34); //3
        list.addLast(44); //4
        list.addFirst(33); //0
        list.reverse();
        System.out.println(Arrays.toString(list.toArray()));
    }

   private class Node {
       private int value;
       private Node next;

       public Node (int value) {
           this.value = value;
       }
   }
   private Node first;
   private Node last;
   public int size;

   public void addLast (int item) {
       var node = new Node(item);
       if (isEmpty())
           first = last = node;
       else {
           last.next = node;
           last = node;
       }
       size++;
   }

   public void addFirst (int item) {
       var node = new Node(item);

       if (isEmpty())
           first = last = node;
       else {
           node.next = first;
           first = node;
       }
       size++;
   }

   private boolean isEmpty() {
       return first == null;
   }

   public int indexOf (int item) {
       int index = 0;
       var current = first;

       while (current != null) {
           if (current.value == item) return index;
           current = current.next;
           index++;
       }
       return -1;
   }

   public boolean contains (int item) {
       return indexOf(item) != -1;
   }

   public void removeFirst() {
       if (isEmpty())
           throw new NoSuchElementException();

       if (first == last)
           first = last = null;
       else {
           var second = first.next;
           first.next = null;
           first = second;
       }
       size--;
   }

   public void removeLast() {
       if (isEmpty())
           throw new NoSuchElementException();

       if (first == last)
           first = last = null;
       else {
            var previous = getPrevious(last);
            last = previous;
            last.next = null;
       }
       size--;
   }

   private Node getPrevious (Node node) {
       var current = first;
       while (current != null) {
           if (current.next == node) return current;
           current = current.next;
       }
       return null;
   }

   public int size() {
       return size;
   }

   public int[] toArray() {
       int[] arr = new int[size];
       var current = first;
       int index = 0;
       while (current != null) {
           arr[index++] = current.value;
           current = current.next;
       }
       return arr;
   }

   public void reverse() {
       var previous = first;
       var current = first.next;
       while (current != null) {
           var next = current.next;
           previous = current;
           current = next;
       }
       last = first;
       last.next = null;
       first = previous;
   }

}
