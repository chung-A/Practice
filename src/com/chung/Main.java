package com.chung;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int[][] data = new int[n + 1][n + 1];

        while (m > 0) {
            m--;
            StringTokenizer str = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(str.nextToken());
            int second = Integer.parseInt(str.nextToken());

            data[first][second] = 1;
            data[second][first] = 1;
        }

        //dfs 연산
        List<Integer> answer = new ArrayList<>();
        boolean[] visited = new boolean[n+1];
        answer.add(v);
        visited[v] = true;
        doDFS(answer, data, visited, v);

        String dfsAnswer = answer.stream().map(s -> s.toString()).collect(Collectors.joining(" "));
        System.out.println(dfsAnswer);

        //bfs 연산
        boolean[] visited2 = new boolean[n+1];
        doBFS(data, visited2, v);
    }

    static void doBFS(int[][] data, boolean[] visited,int start) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();

        answer.add(start);
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            Integer nowNode = queue.remove();
            int[] linkedNodes = data[nowNode];

            for (int i = 1; i < linkedNodes.length; i++) {
                //연결관계가 있고 방문을 아직 안했을 때
                if (linkedNodes[i] == 1 && !visited[i]) {
                    //처리
                    visited[i] = true;
                    queue.add(i);
                    answer.add(i);
                }
            }
        }

        String answerString = answer.stream().map(s -> s.toString()).collect(Collectors.joining(" "));
        System.out.println(answerString);
    }

    static void doDFS(List<Integer> answer, int[][] data, boolean[] visited, int nowNode) {
        visited[nowNode] = true;
        int[] linkedNodes = data[nowNode];

        for (int i = 1; i < linkedNodes.length; i++) {
            //관계가 있고 방문을 안했을 때
            if (linkedNodes[i] == 1 && !visited[i]) {
                visited[i] = true;
                answer.add(i);

                doDFS(answer, data, visited, i);
            }
        }
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
