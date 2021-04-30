package com.chung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Programmers programmers = new Programmers();
        int solution = programmers.solution("10D10S#10S*");
        System.out.println("solution = " + solution);
    }

    // sum 은 지금까지의 합
    static long go(int start, int end, int n, long target, long[] data, long sum, long answer) {
        if (end <= n) {
            if (sum < target) {
                answer = go(start, end + 1, n, target, data, sum + data[end], answer);
            } else {
                if (sum == target) {
                    answer += 1;
                }
                answer = go(start + 1, end, n, target, data, sum - data[start], answer);
            }
        }
        return answer;
    }

    /***************************************************************
     * Programmers
     **************************************************************/
    public static class Programmers {

        public int solution(String dartResult) {
            String[] data = new String[3];
            int index=0;

            //parsing
            StringBuilder stb = new StringBuilder();

            //10점 검사
            int start = 1;
            if(dartResult.charAt(0)=='1'){
                if(dartResult.charAt(1)=='0'){
                    stb.append("10");
                    start = 2;
                }
            }

            if (start == 1) {
                stb.append(dartResult.charAt(0));
            }

            for (int i = start; i < dartResult.length(); i++) {
                char c = dartResult.charAt(i);

                //10점 검사
                if(c=='1'){
                    if(dartResult.charAt(i+1)=='0'){
                        data[index] = stb.toString();
                        stb.setLength(0);
                        index++;

                        stb.append("10");
                        i++;
                        continue;
                    }
                }

                if (c >= '0' && c <= '9') {
                    data[index] = stb.toString();
                    stb.setLength(0);
                    index++;
                }

                stb.append(c);

                if (i <= dartResult.length() - 1) {
                    data[index] = stb.toString();
                }
            }

            //cal
            int[] points = new int[3];
            for (int i = 0; i < data.length; i++) {
                cal(data[i], points, i);
            }

            int sum = 0;
            for (int point : points) {
                sum += point;
            }

            return sum;
        }


        //return sum
        void cal(String data,int[] points,int index) {
            //10점 검사
            int areaIndex = 1;
            int p = Integer.parseInt(data.charAt(0)+"");
            if(data.charAt(0)=='1'){
                if(data.charAt(1)=='0'){
                    p = 10;
                    areaIndex = 2;
                }
            }

            char bonus = data.charAt(areaIndex);
            switch (bonus) {
                case 'S':
                    break;
                case 'D':
                    p = p * p;
                    break;
                case 'T':
                    p = p * p * p;
                    break;
            }

            //option
            if (areaIndex==1&&data.length() > 2) {
                if (data.charAt(2) == '#') {
                    p = p * -1;
                }
                else if (data.charAt(2) == '*') {
                    p = p * 2;
                    if(index>0){
                        points[index - 1] = points[index - 1] * 2;
                    }
                }
            } else if (areaIndex == 2 && data.length() > 3) {
                if (data.charAt(3) == '#') {
                    p = p * -1;
                } else if (data.charAt(3) == '*') {
                    p = p * 2;
                    if (index > 0) {
                        points[index - 1] = points[index - 1] * 2;
                    }
                }
            }

            points[index] = p;
        }

        // 이 위부터
    }
}
