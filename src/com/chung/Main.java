package com.chung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static long[] arr = new long[31];

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n % 2 == 1) {
            System.out.println(0);
            return;
        }

        Arrays.fill(arr, -1);

        System.out.println(dynamic(n));
    }

    static long dynamic(int idx) {
        if (idx == 2) return 3;
        else if(idx==0) return 1;
        else if (arr[idx] != -1) {
            return arr[idx];
        } else {
            long a = 3 * dynamic(idx - 2);

            long sum = 0;
            for (int i = idx - 4; i >= 0; i -= 2) {
                sum += 2 * dynamic(i);
            }

            return arr[idx] = (a + sum);
        }
    }
}