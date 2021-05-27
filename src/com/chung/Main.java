package com.chung;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        int[] data = new int[n];
        split = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(split[i]);
        }

        int answer = go(0, 0, 0, 0, m, 0, data);
        System.out.println(answer);
    }

    static int go(int prevStart, int prevEnd, int startIdx, int endIdx, int m, long prevSum,int[] data) {
        if (endIdx <= data.length) {
            long sum = 0;
            //이전에 start++ 로 들어온 경우
            if (prevStart < startIdx) {
                sum = prevSum - data[prevStart];
            }
            //이전에 end++ 로 들어온 경우
            else if (prevEnd < endIdx) {
                sum = prevSum + data[endIdx - 1];
            }

            int answer = 0;
            if (sum >= m) {
                answer = go(startIdx, endIdx, startIdx + 1, endIdx, m, sum, data);

                //길이 갱신
                if (answer != 0) {
                    answer = Math.min(answer, endIdx - startIdx);
                } else {
                    answer = endIdx - startIdx;
                }

            } else {
                answer = go(startIdx, endIdx, startIdx, endIdx + 1, m, sum, data);
            }

            return answer;
        }
        else{
            return 0;
        }
    }
}

