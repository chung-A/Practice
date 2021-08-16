package com.chung.study.sort;

import com.chung.study.sort.utils.Sort;

import static com.chung.study.sort.utils.SortUtils.*;

public class BubbleSort implements Sort {

    @Override
    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length-i; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                }
            }
        }

        return arr;
    }
}
