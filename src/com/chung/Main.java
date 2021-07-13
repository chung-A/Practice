package com.chung;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int c = Integer.parseInt(split[1]);

        int[] homes = new int[n];
        for (int i = 0; i < n; i++) {
            homes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(homes);

        long left = 0;
        long right = homes[homes.length - 1];
        long answer = right;
        while (left <= right) {
            //가장 인접한 공유기 사이의 최소 거리
            long mid = (left + right) / 2;

            //찾은경우 - 더 큰 값을 찾아본다.
            if (check(homes, c, mid)) {
                answer = mid;
                left = mid + 1;
            }
            //못찾은 경우-공유기사이의 거리를 더 줄여본다.
            else{
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }

    public static boolean check(int[] homes,int c, long dist) {
        int pos = homes[0];
        int idx = 1;
        c--;

        while (c>0) {
            c--;
            long nextPos =pos + dist;

            boolean findYn = false;
            for (;idx < homes.length; idx++) {
                if (homes[idx] >= nextPos) {
                    pos = homes[idx];
                    findYn = true;
                    break;
                }
            }

            if (!findYn) {
                return false;
            }
        }
        return true;
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
