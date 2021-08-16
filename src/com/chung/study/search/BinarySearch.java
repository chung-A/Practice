package com.chung.study.search;

import java.util.List;

public class BinarySearch {

    public int find(int[] arr, int num) {
        int answer = -1;
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            int value = arr[mid];
            if (num < value) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}
