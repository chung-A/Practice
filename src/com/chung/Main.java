package com.chung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println(60*24);

//        //input
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//
//        int[] data = new int[n];
//        for (int i = 0; i < n; i++) {
//            data[i] = Integer.parseInt(br.readLine());
//        }
//        br.close();
//
//        quickSort(data, 0, data.length - 1);
//
//        for (int num : data) {
//            System.out.println(num);
//        }
    }

    static void quickSort(int[] data, int l, int r) {
        int left = l, right = r, pivot, temp;
        pivot = data[(l + r) / 2];

        do {
            while (data[left] < pivot) left++;
            while (data[right] > pivot) right--;
            if (left <= right) {
                temp = data[left];
                data[left] = data[right];
                data[right] = temp;
                left++;
                right--;
            }
        } while (left <= right);

        if (l < right) quickSort(data, l, right);
        if (r > left) quickSort(data, left, r);
    }
}