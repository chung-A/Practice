package com.chung;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] heights = new int[n];

        int i = 0;
        while (n > i) {
            heights[i] = Integer.parseInt(br.readLine());
            i++;
        }

        int leftAnswer = go(0, 0, heights, 0);

        int[] reversed = new int[n];
        i = 0;
        for (int j = heights.length - 1; j >= 0; j--) {
            reversed[i] = heights[j];
            i++;
        }

        int rightAnswer = go(0, 0, reversed, 0);

        System.out.println(leftAnswer);
        System.out.println(rightAnswer);
    }

    static int go(int index, int prevMaxHeights, int[] heights, int answer) {
        if (index >= heights.length) {
            return answer;
        }
        else{
            int nowHeight = heights[index];

            if (prevMaxHeights < nowHeight) {
                answer++;
                prevMaxHeights = nowHeight;
            }

            return go(index + 1, prevMaxHeights, heights, answer);
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
                if(!isSosu[i]){
                    isSosu[i] = true;

                }
            }
        }

        // 이 위부터
    }
}
