package com.chung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long[] arr = new long[1001];

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(dynamic(N));
    }

    static long dynamic(int idx) {
        if (idx == 1) {
            return 1;
        } else if (idx == 2) {
            return 2;
        } else if (arr[idx] != 0) {
            return arr[idx];
        } else {
            long a = dynamic(idx - 1);
            long b = dynamic(idx - 2);
            arr[idx - 1] = a;
            arr[idx - 2] = b;
            return arr[idx] = (a + b) % 10007;
        }
    }
}