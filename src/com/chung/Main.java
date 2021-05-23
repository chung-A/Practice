package com.chung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    /**
     * 최대공약수 GCD(a,b)=GCD(b,r)
     * -> r==0 일때 b가 최대공약수
     * 최소공배수 L(a,b)=g(a/g)*(b/g)
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] data = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                data[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        int answer = -1;
        for (int i = 0; i < (1 << n); i++) {
            // 팀을 절반씩 나눈다고 했으므로 1의 갯수와 0의 갯수가 같은지 검증
            int count = 0;
            for (int k = 0; k < n; k++) {
                if ((i & (1 << k)) != 0) {
                    count++;
                }
            }

            if (count != n / 2) continue;

            //팀 배정
            List<Integer> firstTeam = new ArrayList<>();
            List<Integer> secondTeam = new ArrayList<>();
            for (int k = 0; k < (1 << k); k++) {
                // 1 일때
                if ((i & (1 << k)) != 0) {
                    firstTeam.add(k);
                }
                // 0일때
                else {
                    secondTeam.add(k);
                }
            }

            int t1 = 0;
            int t2 = 0;
            for (int k1 = 0; k1 < n / 2; k1++) {
                for (int k2 = 0; k2 < n / 2; k2++) {
                    t1 += data[firstTeam.get(k1)][firstTeam.get(k2)];
                    t2 += data[secondTeam.get(k1)][secondTeam.get(k2)];
                }
            }
            int dif = Math.abs(t1 - t2);
            if (answer == -1) answer = dif;

            answer = Math.min(answer, dif);
        }
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
