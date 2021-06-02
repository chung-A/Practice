package com.chung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sp = br.readLine().split(" ");
        int n = Integer.parseInt(sp[0]);
        int m = Integer.parseInt(sp[1]);

        List<List<Integer>> data = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            List<Integer> list = new ArrayList<>();
            data.add(list);
        }

        for (int i = 0; i < m; i++) {
            sp = br.readLine().split(" ");
            int from = Integer.parseInt(sp[0]);
            int to = Integer.parseInt(sp[1]);

            data.get(from).add(to);
            data.get(to).add(from);
        }

        int answer = 0;
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }

            //방문하지 않았으면 탐색 시작
            answer++;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            while (!queue.isEmpty()) {
                Integer node = queue.remove();
                List<Integer> linkedNodes = data.get(node);
                for (int j = 0; j < linkedNodes.size(); j++) {
                    Integer linkedNode = linkedNodes.get(j);
                    if (!visited[linkedNode]) {
                        visited[linkedNode] = true;
                        queue.add(linkedNode);
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
