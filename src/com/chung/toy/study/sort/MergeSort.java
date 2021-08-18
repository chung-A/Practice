package com.chung.toy.study.sort;

import com.chung.toy.study.sort.utils.Sort;

public class MergeSort implements Sort {

    int[] temp;

    /**
     * https://yunmap.tistory.com/entry/알고리즘-Java로-구현하는-쉬운-Merge-Sort-병합-정렬-합병-정렬
     */
    @Override
    public int[] sort(int[] arr) {
        temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }

    void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);

            int p = start;
            int q = mid + 1;
            int idx = p;

            while (p <= mid || q <= end) {
                if (q > end || (p <= mid && arr[p] <= arr[q])) {
                    temp[idx++] = arr[p++];
                } else {
                    temp[idx++] = arr[q++];
                }
            }

            for (int i = start; i <= end; i++) {
                arr[i] = temp[i];
            }
        }
    }

}
