package com.chung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int Y = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        //init
        char[][] map = new char[Y][X];
        for (int i = 0; i < map.length; i++) {
            String word = br.readLine();
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = word.charAt(j);
            }
        }

        //do
        int count = 64;
        for (int i = 0; i < Y - 7; i++) {
            for (int j = 0; j < X - 7; j++) {
                int compare = recursive(map, j, i, X, Y);

                count = Math.min(count, compare);
            }
        }

        System.out.println(count);
    }

    public static int recursive(char[][] map, int x, int y, int X, int Y) {
        int count = 0;

        //count
        char next = map[y][x];
        count = getDrawCount(map, x, y, next, count);

        int compare = 64 - count;
        count = Math.min(count, compare);

        return count;
    }

    private static int getDrawCount(char[][] map, int x, int y, char next, int count) {
        for (int i = y; i < y + 8; i++) {
            for (int j = x; j < x + 8; j++) {
                if (next != map[i][j]) {
                    count++;
                }
                next = reverse(next);
            }
            next = reverse(next);
        }
        return count;
    }

    public static char reverse(char c) {
        return (c == 'B') ? 'W' : 'B';
    }
}