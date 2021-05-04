package com.chung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static boolean[] visited = new boolean[501];
    static int[] dist = new int[501];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] data = new int[n + 1][n + 1];

        while (m > 0) {
            m--;
            String[] split = br.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);

            data[a][b] = 1;
            data[b][a] = 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        dist[1] = 0;
        visited[1] = true;
        while (!queue.isEmpty()) {
            int nowNode = queue.remove();
//            System.out.println("nowNode = " + nowNode);

            if(dist[nowNode]<2) {
                int[] nextNodes = data[nowNode];
                for (int i = 0; i < nextNodes.length; i++) {
                    if (nextNodes[i] == 1 && !visited[i]) {
                        visited[i] = true;
                        dist[i] = dist[nowNode] + 1;
                        answer++;

                        queue.add(i);
                    }
                }
            }
        }

        System.out.println(answer);
    }

    /***************************************************************
     * Programmers
     **************************************************************/
    public static class Programmers {

        public String solution(String s) {
            String answer = "";

            if (s.length() % 2 == 0) {
                answer += s.charAt(s.length() / 2 - 1);
                answer += s.charAt(s.length() / 2);
            } else {
                answer += s.charAt(s.length() / 2);
            }
            return answer;
        }

        // 이 위부터
    }
}
