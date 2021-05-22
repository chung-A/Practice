package com.chung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /**
     * 최대공약수 GCD(a,b)=GCD(b,r)
     *  -> r==0 일때 b가 최대공약수
     * 최소공배수 L(a,b)=g(a/g)*(b/g)
     */

    static String[] lang = new String[]{"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);

        int g = getGCD(a, b);
        int l = g * (a / g) * (b / g);

        System.out.println(g);
        System.out.println(l);
    }

    static int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        else{
            return getGCD(b, a % b);
        }
    }

    /***************************************************************
     * Programmers
     **************************************************************/
    public static class Programmers {

        public int solution(int[] nums) {
            int answer = -1;

            // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
            System.out.println("Hello Java");

            return answer;
        }
        // 이 위부터
    }
}
