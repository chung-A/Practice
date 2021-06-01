package com.chung;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);

        int answer = 1;
        if (k != 0) {
            for (int i = 0; i < k; i++) {
                answer = answer * (n - i);
            }

            int value = 1;
            for (int i = 1; i <= k; i++) {
                value = value * i;
            }

            answer = answer / value;
        }
        System.out.println(answer);
    }

}
