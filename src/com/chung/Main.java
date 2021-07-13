package com.chung;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
/*        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");*/

        long solution = solution(6, new int[]{7, 10});
        System.out.println(solution);
    }

    public static long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);
        long left = 0;
        long right = (long) times[times.length - 1] * n;

        while (left <= right) {
            long mid = (left + right) / 2;   //추정 시간
            long sum = 0;   //추정시간 시 심사볼 수 있는 사람 합계

            for (int i = 0; i < times.length; i++) {
                sum += mid / times[i];
            }

            if (sum < n) {
                left = mid + 1;
            }
            else{
                answer = mid;
                right = mid - 1;
            }
        }
        return answer;
    }
}
