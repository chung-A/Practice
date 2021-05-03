package com.chung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        while (n > 0) {
            n--;
            String[] split = br.readLine().split(" ");

            switch (split[0]) {
                case "push":
                    stack.push(Integer.parseInt(split[1]));
                    break;
                case "pop":
                    if(!stack.empty()) {
                        Integer pop = stack.pop();
                        System.out.println(pop);
                    }else{
                        System.out.println(-1);
                    }
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    System.out.println((stack.isEmpty()) ? 1 : 0);
                    break;
                case "top":
                    if(!stack.empty()) {
                        System.out.println(stack.peek());
                    }else{
                        System.out.println(-1);
                    }
                    break;
            }
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
