package com.chung.toy.study.sort.utils;

import java.util.Arrays;
import java.util.stream.Collectors;

public interface SortUtils {

    static int[] generateArray(int length){
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100) + 1;
        }
        return arr;
    }

    static void printArray(int[] arr) {
        System.out.println(Arrays.stream(arr).mapToObj(v-> String.valueOf(v)).collect(Collectors.joining(" ")));
    }

    static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

}
