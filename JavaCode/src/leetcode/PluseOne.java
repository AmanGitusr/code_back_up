package leetcode;

 /* https://leetcode.com/problems/plus-one */

import java.util.Arrays;

public class PluseOne {
    public static void main(String[] args) {
        int[] nums = {1, 9, 9};
        System.out.println("Result: " + Arrays.toString(pluseOne(nums)));
    }

    private static int[] pluseOne(int[] arr) {
        int n = arr.length;
        for (int i = n - 1; i >= 0 ; i--) {
            if (arr[i] < 9) {
                arr[i]++;
                return arr;
            }
            arr[i] = 0;
        }
        int[] new_number = new int[n + 1];
        new_number[0] = 1;
        return new_number;
    }
}
