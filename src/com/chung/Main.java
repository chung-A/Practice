package com.chung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int d = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        System.out.println(go(a, b, c, d, e));
    }

    static int go(int now, int target, int c, int d, int e) {
        if (now == target) {
            return 0;
        }
        else if (now < 0) {
            return go(now + 1, target, c, d, e) + c;
        }
        else if(now==0){
            return go(now + 1, target, c, d, e) + d + e;
        }
        else{
            return go(now + 1, target, c, d, e) + e;
        }
    }

    /***************************************************************
     * Programmers
     **************************************************************/
    public static class Programmers {

        public int solution(String dartResult) {
            return 0;
        }

        // 이 위부터
    }
}
