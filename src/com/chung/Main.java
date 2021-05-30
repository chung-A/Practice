package com.chung;

import java.io.*;

public class Main {

    static int[] answer = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        answer[0] = 0;
        answer[1] = 0;
        answer[2] = 1;
        answer[3] = 1;
        int min = go(n);

        System.out.println(min);
    }

    static int go(int n) {
        if (answer[n] != 0 || n == 1) {
            return answer[n];
        }

        int min1 = 999999999;
        int min2 = 999999999;
        int min3 = 999999999;

        if (n % 3 == 0) {
            min1 = go(n / 3) + 1;
        }

        if (n % 2 == 0) {
            min2 = go(n / 2) + 1;
        }

        min3 = go(n - 1) + 1;

        //memoization
        int temp = Math.min(min1, min2);
        int min = Math.min(temp, min3);
        answer[n] = min;

        return min;
    }
}


