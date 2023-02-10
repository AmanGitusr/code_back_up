package StructureData;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] nums = {76, 34, 89, -7, 23, 21, 0};
        System.out.println("Unsorted array: " + Arrays.toString(nums));
        heapSort(nums);
        System.out.println("Sorted array: " + Arrays.toString(nums));
    }


    private static void heapSort(int[] arr) {
        int n = arr.length -1;
        int t = n/2;

        for (int i = t; i >= 0 ; i--) {
            heapify(arr, n, i);
        }

        for (int i = n; i >= 0; i--) {
            int swap = arr[0];
            arr[0] = arr[i];
            arr[i] = swap;
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int lang = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if (l < n && arr[l] > arr[lang])
            lang = l;

        if (r < n && arr[r] > arr[lang])
            lang = r;

        if (lang != i) {
            int swap = arr[lang];
            arr[lang] = arr[i];
            arr[i] = swap;
            heapify(arr, n, lang);
        }
    }
}
