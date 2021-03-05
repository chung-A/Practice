package com.chung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
        int n = 1000000;
        Random random = new Random();


        int[] data = new int[n];
        int[] data2 = new int[n];
        for (int i = 0; i < n; i++) {
//            data[i] = Integer.parseInt(br.readLine());
            int ran = random.nextInt(10000);
            data[i] = ran;
            data2[i] = ran;
        }
        br.close();

        long startTime = System.currentTimeMillis();
        quickSort(data, 0, data.length - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("퀵정렬 걸린시간: " + (endTime - startTime) * 0.001);

        startTime = System.currentTimeMillis();
        normalSort(data2);
        endTime = System.currentTimeMillis();
        System.out.println("선택정렬 걸린시간: " + (endTime - startTime) * 0.001);

//        System.out.println(Arrays.toString(data));
    }

    static void quickSort(int[] data, int l, int r) {
        int left = l, right = r, pivot, temp;
        pivot = data[(l + r) / 2];

        do {
            while (data[left] > pivot) left++;
            while (data[right] < pivot) right--;
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

    static void normalSort(int[] data) {
        int idx, temp;

        for (int i = 0; i < data.length; i++) {
            idx = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[idx] > data[j]) {
                    idx = j;
                }
            }

            if (idx != i) {
                temp = data[idx];
                data[idx] = data[i];
                data[i] = temp;
            }
        }
    }
}