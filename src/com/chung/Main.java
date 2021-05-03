package com.chung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean[] isNotPrime = new boolean[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] data = new int[n];

        String[] split = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(split[i]);
        }

        isNotPrime[0] = true;
        isNotPrime[1] = true;
        for (int i = 2; i <= 1000; i++) {
            if (!isNotPrime[i]) {
                erase(i);
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int number = data[i];
            if(!isNotPrime[number]){
                answer++;
            }
        }
        System.out.println(answer);
    }

    //number 를 제외한 수들을 지운다.
    static void erase(int number) {
        int length = 1000 / number;
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
