package oopsProgram;

import java.util.Arrays;

public class DynamicArrays {
    private int[] data;
    private int size;

    public DynamicArrays() {
        data = new int[5];
        size = 0;
    }

    public int size() {
        return size;
    }

    public void add(int item) {
        if (size == data.length) {
            reconstruct();
        }

        data[size] = item;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int removeLast() {
        if (size() == 0)
            return -1;

        int item = data[size - 1];
        data[size - 1] = 0;
        size--;
        return item;
    }

    public void set(int index, int item) {
        if (index > size())
            reconstruct();

        data[index] = item;
        size++;
    }

    private void reconstruct() {
        int[] temp = data;
        data = new int[data.length * 2];
        for (int i = 0; i < temp.length; i++) {
            data[i] = temp[i];
        }
    }

    public int get(int index) {
        if (index >= size)
            return -1;

        return data[index];
    }

    public void print() {
        System.out.println(Arrays.toString(data));
    }

    public void sorted() {
        Arrays.sort(data);
    }
}
