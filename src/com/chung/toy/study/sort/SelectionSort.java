package com.chung.toy.study.sort;

import com.chung.toy.study.sort.utils.Sort;

//선택정렬
public class SelectionSort implements Sort {

    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int std = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[std] > arr[j]) {
                    std = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[std];
            arr[std] = temp;
        }
        return arr;
    }

}
