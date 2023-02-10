package leetcode;

//https://leetcode.com/problems/maximum-subarray/description/
public class MaxSubarray {
    public static void main(String[] args) {
        int[] nums = {-2, 1,-3, 4,-1, 2, 1,-5, 4};
        System.out.println(maxSubArray(nums));
    }


//    Kadane's Algorithm
    public static int maxSubArray(int[] array) {
        int sum = 0;
        int max = array[0];

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            max = Math.max(max, sum);

            if (sum < 0)
                sum = 0;
        }
        return max;
    }

}
