package com.chung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static boolean[] contains = new boolean[100000 * 20 + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");

        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(split[i]);
        }

        //시작
        for (int i = 1; i < 1 << n; i++) {

            int sum = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    sum += data[j];
                }
            }

            contains[sum] = true;
        }//끝

        //출력
        for (int i = 1; i < contains.length; i++) {
            if (!contains[i]) {
                System.out.println(i);
                break;
            }
        }

    }
}

