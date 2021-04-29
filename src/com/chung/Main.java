package com.chung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        int MAX = 200000;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");

        boolean[] isVisited = new boolean[MAX];
        int[] count = new int[MAX];
        int n = Integer.parseInt(strings[0]);
        int k = Integer.parseInt(strings[1]);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        isVisited[n] = true;
        count[n] = 0;

        while (!queue.isEmpty()) {
            int now = queue.remove();

            //x+1
            if (now + 1 < MAX) {
                if (!isVisited[now + 1]) {
                    queue.add(now + 1);
                    isVisited[now + 1] = true;
                    count[now + 1] = count[now] + 1;
                }
            }

            //x-1
            if (now - 1 >= 0) {
                if (!isVisited[now - 1]) {
                    queue.add(now - 1);
                    isVisited[now - 1] = true;
                    count[now - 1] = count[now] + 1;
                }
            }

            // x*2
            if (now * 2 < MAX) {
                if (!isVisited[now * 2]) {
                    queue.add(2 * now);
                    isVisited[now * 2] = true;
                    count[2 * now] = count[now] + 1;
                }
            }
        }

        System.out.println(count[k]);
    }

    /***************************************************************
     * Programmers
     **************************************************************/
    public static class Programmers {
        int[] answer = new int[2];
        public int[] solution(int brown, int yellow) {

            for (int i = 3; i <= 5000; i++) {
                for (int j = 1; j <= i; j++) {
                    if (check(brown, yellow, i, j)) {
                        answer[0] = i;
                        answer[1] = j;
                    }
                }
            }

            return answer;
        }

        boolean check(int brown, int yellow, int row, int col) {
            return row >= col && (row * col) - ((row - 2) * (col - 2)) == brown
                    && (row - 2) * (col - 2) == yellow;
        }
    }
}
