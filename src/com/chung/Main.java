package com.chung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(tokenizer.nextToken());
            int h = Integer.parseInt(tokenizer.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            boolean[][] visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                tokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    int value = Integer.parseInt(tokenizer.nextToken());
                    if (value == 1) {
                        visited[i][j] = true;
                    }
                }
            }

            int answer = go(0, 0, visited);
            System.out.println(answer);
        }

    }

    static int go(int col, int row, boolean[][] visited) {
        if (col >= visited.length || row >= visited[0].length) {
            return 0;
        } else {
            int answer = 0;
            if (visited[col][row]) {
                //인근 섬 탐색 후 연결된 섬들은 모두 비활성화
                answer++;
                checkVisited(col, row, visited);
            }

            //현재 지점이 마지막 row 인 경우
            if (col + 1 >= visited.length) {
                answer += go(0, row + 1, visited);
            } else {
                answer += go(col + 1, row, visited);
            }
            return answer;
        }
    }

    static void checkVisited(int col, int row, boolean[][] visited) {
        if (col < visited.length && col >= 0 && row < visited[0].length && row >= 0) {
            if (visited[col][row]) {
                visited[col][row] = false;

                //8방향 탐색
                checkVisited(col - 1, row - 1, visited);
                checkVisited(col-1, row, visited);
                checkVisited(col-1, row+1, visited);
                checkVisited(col, row-1, visited);
                checkVisited(col+1, row-1, visited);
                checkVisited(col+1, row, visited);
                checkVisited(col+1, row+1, visited);
                checkVisited(col, row+1, visited);
            }
        }
    }

    /***************************************************************
     * Programmers
     **************************************************************/
    public static class Programmers {

        boolean[] isSosu = new boolean[50001];

        public int solution(int[] nums) {
            int answer = -1;

            // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
            System.out.println("Hello Java");

            return answer;
        }

        void init() {
            for (int i = 2; i < isSosu.length; i++) {
                if (!isSosu[i]) {
                    isSosu[i] = true;

                }
            }
        }

        // 이 위부터
    }
}
