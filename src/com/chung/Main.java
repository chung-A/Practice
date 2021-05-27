package com.chung;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static boolean[] isNotSosu = new boolean[4000001];
    static List<Integer> sosuList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        getSosuList();

        int startIdx = 0;
        int endIdx = 0;
        int answer = 0;
        while (endIdx <= sosuList.size()) {

            long sum = 0;
            for (int i = startIdx; i < endIdx; i++) {
                sum += sosuList.get(i);
            }

            if (sum == n) {
                answer++;
                startIdx++;
            }
            else if (sum < n) {
                endIdx++;
            }
            else{
                startIdx++;
            }
        }

        System.out.println(answer);
    }

    static void getSosuList() {
        isNotSosu[0] = true;
        isNotSosu[1] = true;

        for (int i = 2; i <= 4000000; i++) {
            if (isNotSosu[i]) continue;

            sosuList.add(i);

            int multiply = 2;
            while (i * multiply <= 4000000) {
                int value = i * multiply;
                isNotSosu[value] = true;
                multiply++;
            }
        }
    }

}

