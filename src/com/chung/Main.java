package com.chung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] lens = new int[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            lens[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lens);

        long left = 1;
        long right = lens[lens.length - 1];
        while (left <= right) {
            long middle = (left + right) / 2;
            long sum = 0;
            for (int i = 0; i < k; i++) {
                sum += lens[i] / middle;
            }

            if (sum >= n) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        System.out.println(right);
    }
}