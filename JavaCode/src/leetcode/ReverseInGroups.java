package leetcode;
/* https://practice.geeksforgeeks.org/problems/reverse-array-in-groups0255/1?page=1&difficulty[]=-1&category[]=Arrays&sortBy=submissions */

import java.util.ArrayList;

public class ReverseInGroups {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            nums.add(i + 1);
        }
        System.out.println("Original arrays: " + nums);
        reverseInGroups(nums, nums.size(), 3);
        System.out.println("Result of reverse in group method: " + nums);
    }

    private static void reverseInGroups(ArrayList<Integer> arr, int size, int k) {
        for (int i = 0; i < size; i += k) {
            Integer left = i;
            Integer right = Math.min(i + k - 1, size - 1);
            Integer temp;

            while (left < right) {
                temp = arr.get(left);
                arr.set(left, arr.get(right));
                arr.set(right, temp);
                left++;
                right--;
            }
        }
    }

    private static void reverseInGroups(int[] arr, int n, int k) {
        for (int i = 0; i < n; i += k) {
            int left = i;
            int right = Math.min(i + k - 1, n - 1);
            int temp;

            while (left < right) {
                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left += 1;
                right -= 1;
            }
        }
    }
}
