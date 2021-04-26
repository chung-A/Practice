package com.chung;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] data = new int[m];
        boolean[] isUsed = new boolean[n + 1];
        Arrays.fill(isUsed, false);

        process(n, m, 0, data, isUsed);
    }

    static void process(int n, int m, int index, int[] data, boolean[] isUsed) {
        if (index == m) {
            //print
            StringBuilder stb = new StringBuilder();
            for (int i = 0; i < data.length; i++) {
                stb.append(data[i]);
                if (i < data.length - 1) {
                    stb.append(" ");
                }
            }
            System.out.println(stb);
        } else {
            for (int i = 1; i <= n; i++) {
                if (isUsed[i]) continue;
                isUsed[i] = true;
                data[index] = i;
                process(n, m, index + 1, data, isUsed);
                isUsed[i] = false;
            }
        }
    }
}
