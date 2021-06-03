package com.chung;

import java.io.*;
import java.util.*;

public class Main {

    public static class Location{
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    //상하좌우
    static final int[] dx = new int[]{0, 0, -1, 1};
    static final int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        boolean[][] visited = new boolean[n][m];
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(0, 0));
        visited[0][0] = true;

        int depth = 1;
        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int k = 0; k < length; k++) {
                Location node = queue.remove();

                //도착시 중지
                if (node.x == map.length - 1 && node.y == map[0].length - 1) {
                    System.out.println(depth);
                    return;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = node.x + dx[i];
                    int ny = node.y + dy[i];

                    //멥 안에 있고
                    if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length) {
                        //길이 있으면
                        if (map[nx][ny] == 1 && !visited[nx][ny]) {
                            queue.add(new Location(nx, ny));
                            visited[nx][ny] = true;
                        }
                    }
                }

            }
            depth++;
        }
    }
}
