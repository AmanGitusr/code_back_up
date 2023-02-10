package practice;

import java.util.Arrays;
import java.util.Scanner;

public class ArrExample {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter size of an arr: ");
        int size = in.nextInt();
        int[] nums = new int[size];
        for(int i=0; i<nums.length; i++) {
            System.out.print("Enter the element in the array " + (i+1) + " : ");
            nums[i] = in.nextInt();
        }
//        for(int show : nums) {
//            System.out.print(show + " ");
//        }
        System.out.println(Arrays.toString(nums));
    }
}
