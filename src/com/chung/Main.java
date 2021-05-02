package com.chung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        Programmers p = new Programmers();
        String abcd = p.solution("ab");
        System.out.println(abcd);

/*        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);
        int c = Integer.parseInt(split[2]);
        int n = Integer.parseInt(split[3]);

        boolean findAnswer = false;
        int length1 = 300;
        int length2 = 300;
        int length3 = 300;

        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                for (int k = 0; k < length3; k++) {
                    int total = a * i + b * j + c * k;

                    if (total == n) {
                        findAnswer = true;
                        break;
                    }
                }

                if(findAnswer) break;
            }
            if(findAnswer) break;
        }

        System.out.println((findAnswer) ? 1 : 0);*/
    }

    /***************************************************************
     * Programmers
     **************************************************************/
    public static class Programmers {

        public String solution(String s) {
            String answer = "";

            if (s.length() % 2 == 0) {
                answer += s.charAt(s.length() / 2 -1);
                answer += s.charAt(s.length() / 2);
            }else{
                answer += s.charAt(s.length() / 2);
            }
            return answer;
        }

        // 이 위부터
    }
}
