package com.chung;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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
        System.out.println(answer);
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
        int answer = 0;
        Arrays.sort(d);

        //Mid: 물품지원한 부서 갯수
        int left = 0;
        int right = d.length;

        while (left <= right) {
            int mid = (left + right) / 2;

            long sum = 0;
            for (int i = 0; i < mid; i++) {
                sum += d[i];
            }

            //늘려보기
            if (sum <= budget) {
                left = mid + 1;
                answer = mid;
            }
            //줄여보기
            else {
                right = mid - 1;
            }
        }
        return answer;
    }
}
