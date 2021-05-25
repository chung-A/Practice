package com.chung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int s = Integer.parseInt(split[1]);

        int[] data = new int[n];
        split = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(split[i]);
        }

        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        int left = n / 2;
        int right = n - left;

        //left
        for (int i = 0; i < (1 << left); i++) {

            int sum = 0;
            for (int j = 0; j < left; j++) {
                if ((i & (1 << j)) != 0) {
                    sum += data[j];
                }
            }

            leftList.add(sum);
        }

        //right
        for (int i = 0; i < (1 << right); i++) {

            int sum = 0;
            for (int j = 0; j < right; j++) {
                if ((i & (1 << j)) != 0) {
                    sum += data[j+left];
                }
            }

            rightList.add(sum);
        }

        Collections.sort(leftList);
        Collections.sort(rightList);

        int leftIndex = 0;
        int rightIndex = rightList.size() - 1;
        int lSize = leftList.size() - 1;

        long answer = 0;
        while (leftIndex <= lSize && rightIndex >= 0) {
            int leftValue = leftList.get(leftIndex);
            int rightValue = rightList.get(rightIndex);
            long sum = leftValue + rightValue;

            if (sum > s) {
                rightIndex--;
            }
            else if(sum<s){
                leftIndex++;
            }
            else{
                long leftCheck = 0;
                long rightCheck = 0;

                while (leftIndex <= lSize && leftValue == leftList.get(leftIndex)) {
                    leftIndex++;
                    leftCheck++;
                }

                while (rightIndex >= 0 && rightValue == rightList.get(rightIndex)) {
                    rightIndex--;
                    rightCheck++;
                }

                answer += leftCheck * rightCheck;
            }
        }
        if(s==0) answer--;
        System.out.println(answer);
    }

    /***************************************************************
     * Programmers
     **************************************************************/
    public static class Programmers {

        public int solution(int[] nums) {
            int answer = -1;

            // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
            System.out.println("Hello Java");

            return answer;
        }
        // 이 위부터
    }
}
