package com.chung.sort;

import com.chung.sort.utils.Sort;
import com.chung.sort.utils.SortUtils;

import static com.chung.sort.utils.SortUtils.*;

public class QuickSort implements Sort {

    @Override
    public int[] sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int pivot = partition(arr, lo, hi);
        quickSort(arr, lo, pivot - 1);
        quickSort(arr, pivot + 1, hi);
    }

    int partition(int[] arr, int left, int right) {
        int lo = left;
        int hi = right;
        int pivot = arr[left];

        while (lo < hi) {
            while (arr[hi] > pivot && lo < hi) {
                hi--;
            }

            while (arr[lo] <= pivot && lo < hi) {
                lo++;
            }

            swap(arr, lo, hi);
        }
        swap(arr, left, lo);
        return lo;
    }
}
