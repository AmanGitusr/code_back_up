package recursion;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = {10, 18, 19, 9, 2, 6, 19, 19, 11};
        quickSort(array,0 , array.length - 1);
        System.out.println(Arrays.toString(array));
    }
    public static void quickSort(int [] array, int startIndex, int endIndex){
        if(startIndex >= endIndex){
            return;
        }

        int pivotPos = partition(array, startIndex , endIndex);
        quickSort(array , startIndex , pivotPos - 1 );
        quickSort(array , pivotPos + 1 , endIndex);
    }

    private static int partition(int[] array, int startIndex, int endIndex){
        int pivot = array[startIndex];
        int count = 0;
        for(int i = startIndex; i <= endIndex; i++){
            if(array[i] < pivot)
                count++;
        }

        int pivotPos = startIndex + count;
        int tem = array[startIndex];
        array[startIndex] = array[pivotPos];
        array[pivotPos] = tem;

        int i = startIndex;
        int j = endIndex;

        while(i < pivotPos && j > pivotPos){
            while(array[i] < array[pivotPos])
                i++;
            while(array[j] > array[pivotPos])
                j--;

            int temp = array[i];
            array[i] = array[j] ;
            array[j] = temp;
        }

        return pivotPos;
    }
}
