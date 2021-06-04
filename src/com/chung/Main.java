package com.chung;

import java.io.*;
import java.util.*;

public class Main {

    static final int[] dx = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
    static final int[] dy = new int[]{1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            t--;

            int l = Integer.parseInt(br.readLine());
            int[][] dist = new int[l][l];

            String[] split = br.readLine().split(" ");
            int n = Integer.parseInt(split[0]);
            int m = Integer.parseInt(split[1]);
            Location start = new Location(n, m);

            split = br.readLine().split(" ");
            n = Integer.parseInt(split[0]);
            m = Integer.parseInt(split[1]);
            Location end = new Location(n, m);

            Queue<Location> q = new LinkedList<>();
            q.add(start);

            int answer = 0;
            while (!q.isEmpty()) {
                Location node = q.remove();

                int x = node.x;
                int y = node.y;

                //목적지인지 검사
                if (x == end.x && y == end.y) {
                    answer = dist[x][y];
                    break;
                }

                for (int k = 0; k < 8; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if (nx >= 0 && nx < l && ny >= 0 && ny < l) {
                        if (dist[nx][ny] == 0) {
                            q.add(new Location(nx, ny));
                            dist[nx][ny] = dist[x][y] + 1;
                        }
                    }
                }
            }

            System.out.println(answer);
        }
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
