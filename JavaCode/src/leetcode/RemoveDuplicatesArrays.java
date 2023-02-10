package leetcode;

    /* https://leetcode.com/problems/remove-duplicates-from-sorted-array */

import java.util.*;

public class RemoveDuplicatesArrays {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 3, 4, 5, 5};
        System.out.println("Array: " + Arrays.toString(arr));
        int count = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != arr[count]) {
                count++;
                arr[count] = arr[j];
            }
        }

        System.out.println("removeDuplicates arrays: " + Arrays.toString(arr));
        System.out.println("Count: " + (count + 1));

        System.out.println("Count of single element in arrays: " + removeDuplicate(arr));
    }

    private static int removeDuplicate(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        Arrays.fill(arr, 0);
        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        System.out.println("Sorted array: " + Arrays.toString(arr));

        return (set.size());
    }
}
