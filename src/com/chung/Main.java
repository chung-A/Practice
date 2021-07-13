package com.chung;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
/*        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");*/
        int solution = solution(new int[]{2,2,3,3}, 10);
        System.out.println("solution = " + solution);
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
            else{
                right = mid - 1;
            }
        }
        return answer;
    }
}
