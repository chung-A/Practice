package com.chung;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] requiredDate = new int[n + 1];
        int[] inquiredMoney = new int[n + 1];

        int i = 0;
        while (n > i) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            requiredDate[i] = Integer.parseInt(tokenizer.nextToken());
            inquiredMoney[i] = Integer.parseInt(tokenizer.nextToken());

            i++;
        }

        int answer = go(0, 0, n, requiredDate, inquiredMoney);
        System.out.println(answer);
    }

    // now: 현재 일자, money: 어제까지 번 금액
    static int go(int now, int money, int finishDate, int[] requiredDate, int[] inquiredMoney) {
        if (now == finishDate) {
            return money;
        }
        else if (now > finishDate) {
            return 0;
        }
        else {
            int answer = 0;

            int t = requiredDate[now];
            int m = inquiredMoney[now];

            if (now + t <= finishDate) {
                answer = go(now + t, money + m, finishDate, requiredDate, inquiredMoney);
            }

            answer = Math.max(go(now + 1, money, finishDate, requiredDate, inquiredMoney), answer);

            return answer;
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
