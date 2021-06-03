package com.chung;

import java.io.*;
import java.util.*;

public class Main {

    //동서남북위아래
    static final int[] dx = new int[]{0, 0, 1, -1, 0, 0};
    static final int[] dy = new int[]{1, -1, 0, 0, 0, 0};
    static final int[] dz = new int[]{0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int m = Integer.parseInt(split[0]);
        int n = Integer.parseInt(split[1]);
        int h = Integer.parseInt(split[2]);

        Queue<Location> q = new LinkedList<>();
        boolean allFinish = true;
        int[][][] box = new int[n][m][h];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                split = br.readLine().split(" ");
                for (int k = 0; k < m; k++) {
                    int value = Integer.parseInt(split[k]);
                    box[j][k][i] = value;

                    if (value == 1) {
                        q.add(new Location(j, k, i));
                    }

                    if (allFinish && value == 0) {
                        allFinish = false;
                    }
                }
            }
        }

        if (allFinish) {
            System.out.println(0);
            return;
        }

        int[][][] dist = new int[box.length][box[0].length][box[0][0].length];
        bfs(q, dist, box);

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < h; k++) {
                    if (box[i][j][k] == 0 && dist[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }

                    if (box[i][j][k] == 0 && dist[i][j][k] > 0) {
                        answer = Math.max(dist[i][j][k], answer);
                    }

                }
            }
        }

        System.out.println(answer);
    }

    static void bfs(Queue<Location> queue, int[][][] dist, int[][][] box) {
        while (!queue.isEmpty()) {
            Location node = queue.remove();

            for (int k = 0; k < 6; k++) {
                int nx = node.x + dx[k];
                int ny = node.y + dy[k];
                int nz = node.z + dz[k];

                //범위내에 있고
                if (nx >= 0 && nx < box.length &&
                        ny >= 0 && ny < box[0].length &&
                        nz >= 0 && nz < box[0][0].length) {
                    int nextPointValue = box[nx][ny][nz];

                    if (nextPointValue == 0&&dist[nx][ny][nz]==0) {
                        if (dist[nx][ny][nz] == 0) {
                            dist[nx][ny][nz] = dist[node.x][node.y][node.z] + 1;
                        }
                        else{
                            dist[nx][ny][nz] = Math.min(dist[node.x][node.y][node.z] + 1, dist[nx][ny][nz]);
                        }

                        queue.add(new Location(nx, ny, nz));
                    }
                }
            }
        }
    }

    static class Location {
        int x;
        int y;
        int z;

        public Location(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
