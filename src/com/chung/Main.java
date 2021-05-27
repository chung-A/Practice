package com.chung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        int[] data = new int[n];
        split = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(split[i]);
        }

        int answer = 0;
        int startIdx = 0;
        int endIdx = 0;
        while (endIdx<=n) {

            long sum = 0;
            for (int i = startIdx; i < endIdx; i++) {
                sum += data[i];
            }

            if (sum == m) {
                answer++;
                startIdx++;
            }
            else if (sum < m) {
                endIdx++;
            }
            else{
                startIdx++;
            }
        }

        System.out.println(answer);
    }
}

