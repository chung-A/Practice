package com.chung;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(cards);

        StringBuilder stb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        split = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(split[i]);

            //이분탐색
            int left=0;
            int right = cards.length-1;
            boolean findYn = false;
            while (left <= right) {
                int mid = (left + right) / 2;
                int card = cards[mid];

                if (card == num) {
                    findYn = true;
                    break;
                }
                else if (card < num) {
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }

            if (findYn) {
                stb.append("1 ");
            }
            else{
                stb.append("0 ");
            }
        }

        System.out.println(stb);
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
