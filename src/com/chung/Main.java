package com.chung;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        StringBuilder stb = new StringBuilder();
        stb.append("<");
        int count = 0;
        while (!q.isEmpty()) {
            Integer num = q.remove();
            count++;

            if (count == k) {
                count = 0;
                stb.append(num);
                if (!q.isEmpty()) {
                    stb.append(", ");
                }
            }
            else{
                q.add(num);
            }
        }
        stb.append(">");

        System.out.println(stb);
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
