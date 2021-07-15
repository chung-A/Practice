package com.chung;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        list.add(0);

        String[] split = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(split[i]);

            binarySearch(list, num);
        }

        System.out.println(list.size() - 1);
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
