package com.chung.sort;

import com.chung.sort.utils.Sort;
import com.chung.sort.utils.SortUtils;

import static com.chung.sort.utils.SortUtils.*;

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
