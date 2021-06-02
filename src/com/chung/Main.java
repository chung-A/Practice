package com.chung;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] data = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            data[i][0] = Integer.parseInt(split[0]);
            data[i][1] = Integer.parseInt(split[1]);
        }

        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int rank = 1;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                if (data[i][0] < data[j][0] && data[i][1] < data[j][1]) {
                    rank++;
                }
            }

            stb.append(rank).append(" ");
        }
        System.out.println(stb);
    }
}
