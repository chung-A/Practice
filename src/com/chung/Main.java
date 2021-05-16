package com.chung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        while (testcase > 0) {
            testcase--;

            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= w; i++) {
                for (int j = 1; j <= h; j++) {
                    int roomNumber = j * 100 + i;

                    queue.add(roomNumber);
                }
            }

            for (int i = 1; i <= n; i++) {
                Integer room = queue.remove();
                if (i == n) {
                    System.out.println(room);
                }
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
