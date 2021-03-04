package com.chung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long[][] arr = new long[1000001][2];

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(dynamic(n));
    }

    static long dynamic(int idx) {
        arr[0][0] = 0;
        arr[1][0] = 2;
        arr[2][0] = 7;
        arr[2][1] = 1;

        for (int i = 3; i <= idx; i++) {
            arr[i][1] = (arr[i - 1][1] + arr[i - 3][0]) % 1000000007;
            arr[i][0] = (3 * arr[i - 2][0] + 2 * arr[i - 1][0] + 2 * arr[i][1]) % 1000000007;
        }
        return arr[idx][0];
    }
}