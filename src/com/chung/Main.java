package com.chung;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        random();
        long end = System.currentTimeMillis();
        System.out.println("걸린 시간: " + (end - start)+"ms");

/*        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        long x = Integer.parseInt(split[0]);
        long y = Integer.parseInt(split[1]);

        long defaultZ = (long) ((double) y * 100 / (double) x);
        if (defaultZ >= 99) {
            System.out.println(-1);
            return;
        }

        //mid = 게임 횟수
        long left = 0;
        long right = 1000000000;
        long answer = -1;
        while (left <= right) {
            long mid = (left + right) / 2;

            long newZ = (long) ((double) (y + mid) * 100 / (double) (x + mid));
            if (newZ > defaultZ) {
                right = mid - 1;
                answer = mid;
            }
            else{
                left = mid + 1;
            }
        }
        System.out.println(answer);*/
    }

    /**
     * 1. 재귀를 이용한 피보나치(fibo 함수)
     * <p>
     * 2. 메모이제이션을 이용한 피보나치(memoFibo 함수)
     * <p>
     * 3. 재귀를 이용한 팩토리얼 문제(fact 함수)
     * <p>
     * 4. 10번 동안 1~10까지 랜덤한 숫자를 출력하여 중복된 숫자가 있을 경우 true, false를 리턴하라(randomQuiz)
     */

    static int fibo1(int num) {
        if(num>0){
            return fibo1(num-1) + fibo1(num-2);
        }
        else{
            return 0;
        }
    }

    static long fibo2(int num) {
        long[] memo = new long[num + 1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= num; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        return memo[num];
    }

    static long fact(int n) {
        if (n <= 1) {
            return 1;
        }
        else{
            return n * fact(n - 1);
        }
    }

    static void random() {
        for (int i = 0; i < 50; i++) {
            int ran = (int) (Math.random() * 10) + 1;
            System.out.println(ran);
        }
    }

    static void binarySearch(List<Integer> list,int num) {
        if (list.get(list.size() - 1) < num) {
            list.add(num);
        }
        else if (list.get(list.size() - 1) > num) {
            //이진탐색
            int left = 0;
            int right = list.size() - 1;
            int answer = 0;

            while (left <= right) {
                int mid = (left + right) / 2;

                Integer midNum = list.get(mid);
                if (midNum >= num) {
                    right = mid - 1;
                    answer = mid;
                } else {
                    left = mid + 1;
                }
            }

            list.set(answer, num);
        }
    }

    public static int solution(int[] d, int budget) {

        return 0;
    }
}
