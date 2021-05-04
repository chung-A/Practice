package com.chung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean[][] visited = new boolean[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int row = Integer.parseInt(split[0]);
        int col = Integer.parseInt(split[1]);

        int[][] map = new int[row][col];
        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                map[i][j] = (c == '#') ? 1 : 0;
            }
        }

        int answer = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    answer++;
                    drawWith(i, j, map);
                }
            }
        }

        System.out.println(answer);
    }

    static void drawWith(int x, int y, int[][] map) {
        if (map[x][y] == 1 && !visited[x][y]) {
            visited[x][y] = true;

            //상
            if (x + 1 < map.length && check(x + 1, y, map)) {
                drawWith(x + 1, y, map);
            }

            //하
            if (x - 1 > 0 && check(x - 1, y, map)) {
                drawWith(x - 1, y, map);
            }

            //좌
            if (y - 1 > 0 && check(x, y - 1, map)) {
                drawWith(x, y - 1, map);
            }

            //우
            if (y + 1 < map[0].length && check(x, y + 1, map)) {
                drawWith(x, y + 1, map);
            }
        }
    }

    static boolean check(int x, int y, int[][] map) {
        return map[x][y] == 1;
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
