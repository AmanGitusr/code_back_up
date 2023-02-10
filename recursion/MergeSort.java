package recursion;

import java.util.Arrays;

class MergeSort {

    public static void sort(int[] input) {
        if (input.length <= 1)
            return;

        int mid = (input.length) / 2;
        int[] left = Arrays.copyOfRange(input, 0, mid);
        int[] right = Arrays.copyOfRange(input,  mid, input.length);

        sort(left);
        sort(right);

        merge(left, right, input);
    }
    private static void merge(int[] left, int[] right, int[] result) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[k++] = left[i++];
            }else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }
    }

    /*  Write by Kissu
    public static void MergeSort(int[] input){
        // Write your code here
        MergeSort(input,0,input.length-1);
    }
    public static void MergeSort(int[] input, int si , int ei ){
        if(si >= ei){
            return;
        }
        int mid = (si+ei)/2;
        MergeSort(input , si, mid);
        MergeSort(input, mid+1 , ei);
        merge(input, si, ei);
    }
    public static void merge( int[] input ,  int si , int ei){
        int [] arr = new int[(ei-si)+1];
        int mid = (si+ei)/2;
        int s1 = si;
        int s2 = mid+1;
        int i =0;
        while( s1<mid+1 && s2<ei+1){
            if(input[s1] < input[s2]){
                arr[i++] = input[s1++];
            }
            else{
                arr[i++] = input[s2++];
            }
        }
        while(s1 < mid+1){
            arr[i++] = input[s1++];
        }
        while(s2 < ei+1){
            arr[i++] = input[s2++];
        }
        for(int j = 0 ; j<arr.length ; j++){
            input[si++] = arr[j];
        }

    }
*/
    public static void main(String[] args) {
        int [] arr ={6, 5, 4, 7, 3, 2};
        sort(arr);
        System.out.println("Result: " + Arrays.toString(arr));
    }
}
