// Operations :
//
// 1. Declare an ArrayList of different Types
// 2. Add Element
// 3. Get Element
// 4. Add Element at a specific Index
// 5. Set Element at a specific Index
// 6. Delete Element from an Index
// 7. Size of the List
// 8. Loop/Iterate on the List
// 9. Sort the List

import java.util.ArrayList;
import java.util.Collections;

public class ArrayLists {
    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        // ArrayList<String> list2 = new ArrayList<String>();
        // ArrayList<Boolean> list3 = new ArrayList<Boolean>();

        // 1. Add elements
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println("After adding elements: " + list);

        // 2. Get an element
        int element = list.get(0); // 0 is the index
        System.out.println("Element at index 0: " + element);

        // 3. Add element in between
        list.add(1, 2); // 1 is the index, 2 is the element to be added
        System.out.println("After adding 2 at index 1: " + list);

        // 4. Set element
        list.set(0, 0);
        System.out.println("After setting index 0 to 0: " + list);

        // 5. Delete element
        list.remove(0); // 0 is the index
        System.out.println("After removing element at index 0: " + list);

        // 6. Size of list
        int size = list.size();
        System.out.println("Current size of the list: " + size);

        // 7. Loop on list
        System.out.print("Iterating through list: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        // 8. Sorting the list
        list.add(0);
        Collections.sort(list);
        System.out.println("After sorting: " + list);
    }
}