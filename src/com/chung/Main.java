package com.chung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (n > 0) {
            String data = br.readLine();
            Stack<Character> stack = new Stack<>();

            boolean finish = false;
            for (int i = 0; i < data.length(); i++) {
                char c = data.charAt(i);

                if (c == '(') {
                    stack.push(c);
                } else {
                    if (stack.empty()) {
                        finish = true;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if (!stack.empty() || finish) {
                System.out.println("NO");
            }
            else{
                System.out.println("YES");
            }

            n--;
        }
    }


    /***************************************************************
     * Programmers
     **************************************************************/
    public static class Programmers {

        public String solution(String s) {
            String answer = "";

            if (s.length() % 2 == 0) {
                answer += s.charAt(s.length() / 2 - 1);
                answer += s.charAt(s.length() / 2);
            } else {
                answer += s.charAt(s.length() / 2);
            }
            return answer;
        }

        // 이 위부터
    }
}
