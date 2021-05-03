package com.chung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean[] isNotPrime = new boolean[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int m = Integer.parseInt(split[0]);
        int n = Integer.parseInt(split[1]);

        for (int i = 2; i <= n; i++) {
            if (!isNotPrime[i]) {
                erase(i, n);
            }
        }

        for (int i = m; i <= n; i++) {
            if (!isNotPrime[i] && i > 1) {
                System.out.println(i);
            }
        }
    }

    //number 를 제외한 수들을 지운다.
    static void erase(int number, int max) {
        int length = max / number;
        for (int i = 2; i <= length; i++) {
            isNotPrime[number * i] = true;
        }
    }


    /***************************************************************
     * Programmers
     **************************************************************/
    public static class Programmers {

        public String solution(String s) {
            String answer = "";

            if (s.length() % 2 == 0) {
                answer += s.charAt(s.length() / 2 - 1);
                answer += s.charAt(s.length() / 2);
            } else {
                answer += s.charAt(s.length() / 2);
            }
            return answer;
        }

        // 이 위부터
    }
}
