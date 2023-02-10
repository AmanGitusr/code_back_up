package practice;

import java.util.Arrays;
import java.util.Scanner;

public class ArrExample2d {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the size of 2d arrays row: ");
        int row = in.nextInt();
        System.out.print("Enter the size of 2d arrays col: ");
        int col = in.nextInt();
        int[][] nums = new int[row][col];
        for(int rows=0; rows<nums.length; rows++) {
            for(int cols=0; cols<nums[rows].length; cols++) {
                System.out.print("Enter the element " + (rows+1) + " row " + (cols+1) + " column: ");
                nums[rows][cols] = in.nextInt();
            }
        }
        for(int[] rows : nums) {
            System.out.println(Arrays.toString(rows));
        }

    }
}
