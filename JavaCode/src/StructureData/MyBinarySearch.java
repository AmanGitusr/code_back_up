package StructureData;

public class MyBinarySearch {
    public static void main(String[] args) {
        MyBinarySearch ob = new MyBinarySearch();
        int arr[]= {12,18,23,27,49,73,82};
        int result = ob.bs(arr,0,arr.length-1,18);
        if(result==-1)
            System.out.println("Element is not present in array");
        else
            System.out.println("your element is at index: "+result);

    }
    public  int bs(int arr[], int start, int end, int x) {
        while (end > start) {
            int mid =  ( start + end )/ 2;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] > x)
                end = mid - 1;
            if (arr[mid] < x)
                start = mid + 1;
        }
        return -1;
    }
    public static int binarySearch(int arr[], int l, int r, int x) {
            if (r >= l) {
                int mid = l + (r - l) / 2;


                if (arr[mid] == x)
                    return mid;

                if (arr[mid] > x)
                    return binarySearch(arr, l, mid - 1, x);


                return binarySearch(arr, mid + 1, r, x);
            }
            return -1;
        }



}
