package leetcode;

public class SearchInsert {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println("Result: " + searchInsert(nums, 2));
    }

    private static int searchInsert(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(target < arr[mid]) high = mid - 1;
            else if (target > arr[mid]) low = mid + 1;
            else return mid;
        }
        return low;
    }

}
