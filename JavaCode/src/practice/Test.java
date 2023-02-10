package practice;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 0, 1, 2, 3};
        int pivot = findPivot(arr);
        int k = 0;
        if (k >= arr[pivot] && k <= arr[arr.length - 1])
            System.out.println("result in second stick: " + binarySearch(arr, pivot, arr.length, k));
        else
            System.out.println("result in first stic: " + binarySearch(arr, 0, pivot - 1, k));
    }


    public static int findPivot(int[] array) {
        int s = 0;
        int e = array.length - 1;
        int mid = s + (e - s) / 2;

        while (s < e) {
            if (array[mid] >= array[0]) {
                s = mid + 1;
            }else {
                e = mid;
            }
            mid = s + (e - s) / 2;
        }
        return s;
    }

    public static int binarySearch(int[] array, int start, int end, int target) {

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == array[mid])
                return mid;
            if (array[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }

        public int search(int[] nums, int target) {
            int lo = 0, hi = nums.length - 1;

            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (nums[mid] == target) return mid;
                else if (nums[lo] <= nums[mid]) { // left side sorted
                    if (nums[lo] <= target && target <= nums[mid]) hi = mid - 1;
                    else lo = mid + 1;
                } else { // right side sorted
                    if (nums[mid] <= target && target <= nums[hi]) lo = mid + 1;
                    else hi = mid - 1;
                }
            }
            return -1;
        }

}

