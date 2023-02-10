package StructureData;

import java.util.LinkedList;
import java.util.List;

public class MyLinkedList2 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        list.addFirst("This");
        list.add("is");
        list.add("a");
        list.addLast("list");
        System.out.println("Original linked list: " + list);

        // add any index of linkedlist

        list.add(3, "linked");
        System.out.println("after adding index 3: " + list);

        //remove any index in linkedlist

        list.remove(3);
        System.out.println("after removing index 3: " + list);

        // removing first or last node of the linkedlist

        list.removeFirst();
        list.removeLast();
        System.out.println("after removing first or last node: " + list);

        System.out.println("Get element of any specific index: " + list.get(0));
        System.out.println("Know the size of linkedlist: " + list.size());
    }
}
