package com.chung;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            int k = -1;

            switch (split[0]) {
                case "push_front":
                    k = Integer.parseInt(split[1]);
                    deque.addFirst(k);
                    break;
                case "push_back":
                    k = Integer.parseInt(split[1]);
                    deque.addLast(k);
                    break;
                case "pop_front":
                    Integer integer = deque.pollFirst();
                    if (integer == null) {
                        System.out.println(-1);
                    }
                    else{
                        System.out.println(integer);
                    }
                    break;
                case "pop_back":
                    Integer integer2 = deque.pollLast();
                    if (integer2 == null) {
                        System.out.println(-1);
                    }
                    else{
                        System.out.println(integer2);
                    }
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    System.out.println(deque.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    Integer integer3 = deque.peekFirst();
                    if (integer3 == null) {
                        System.out.println(-1);
                    }
                    else{
                        System.out.println(integer3);
                    }
                    break;
                case "back":
                    Integer integer4 = deque.peekLast();
                    if (integer4 == null) {
                        System.out.println(-1);
                    }
                    else{
                        System.out.println(integer4);
                    }
                    break;
            }
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
