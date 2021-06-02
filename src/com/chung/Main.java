package com.chung;

import java.io.*;
import java.util.*;

public class Main {

    //상하좌우
    static final int[] dx = new int[]{0, 0, -1, 1};
    static final int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        int count = 0;
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] > 0) {
                    //해당 점 탐색시작
                    count++;
                    answer.add(dfs(i, j, map));
                }
            }
        }

        System.out.println(count);
        Collections.sort(answer);
        for (Integer integer : answer) {
            System.out.println(integer);
        }
    }

    static int dfs(int x, int y,int[][] map) {
        map[x][y] = 0;
        int count = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length) {
                if(map[nx][ny]>0){
                    count += dfs(nx, ny, map);
                }
            }
        }
        return count;
    }
}
