package com.chung;

import java.io.*;
import java.util.*;

public class Main {

    //동서남북
    static final int[] dx = new int[]{0, 0, 1, -1};
    static final int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int m = Integer.parseInt(split[0]);
        int n = Integer.parseInt(split[1]);

        boolean allFinish = true;
        int[][] dist = new int[n][m];
        Queue<Location> q = new LinkedList<>();
        int[][] box = new int[n][m];
        for (int i = 0; i < n; i++) {
            split = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                int value = Integer.parseInt(split[j]);
                box[i][j] = value;

                if (value == 1) {
                    q.add(new Location(i, j));
                } else if (value == 0) {
                    dist[i][j] = -1;
                    allFinish = false;
                }
            }
        }
        if (allFinish) {
            System.out.println(0);
            return;
        }

        while (!q.isEmpty()) {
            Location node = q.remove();

            for (int k = 0; k < 4; k++) {
                int nx = node.x + dx[k];
                int ny = node.y + dy[k];

                if (nx >= 0 && nx < box.length && ny >= 0 && ny < box[0].length) {
                    if (box[nx][ny] == 0 && dist[nx][ny] == -1) {
                        q.add(new Location(nx, ny));
                        dist[nx][ny] = dist[node.x][node.y] + 1;
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dist[i][j] != 0) {
                    answer = Math.max(answer, dist[i][j]);
                }

                if (dist[i][j] == -1) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(answer);
    }

    static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
