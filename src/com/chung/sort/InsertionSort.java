package com.chung.sort;

import com.chung.sort.utils.Sort;

//삽입정렬
public class InsertionSort implements Sort {

    @Override
    public int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int std = arr[i];
            int compareIdx = i - 1;

            while (compareIdx >= 0 && std < arr[compareIdx]) {
                arr[compareIdx + 1] = arr[compareIdx];
                compareIdx--;
            }

            arr[compareIdx + 1] = std;
        }

        return arr;
    }

    public int[] sort2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int std = arr[i];
            int compareIdx = i - 1;
            while (compareIdx >= 0 && std > arr[compareIdx]) {
                arr[compareIdx + 1] = arr[compareIdx];
                compareIdx--;
            }

            arr[compareIdx + 1] = std;
        }

        return arr;
    }
}
