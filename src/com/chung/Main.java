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
        String solution = programmers.solution("...!@BaT#*..y.abc-_.defghijklm.");
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

        public String solution(String new_id) {
            String recommend = step1(new_id);
            recommend = step2(recommend);
            recommend = step3(recommend);
            recommend = step4(recommend);
            recommend = step5(recommend);
            recommend = step6(recommend);
            recommend = step7(recommend);

            return recommend;
        }


         String step1(String id) {
            return id.toLowerCase();
        }

         String step2(String id) {
             return id.replaceAll("[^0-9a-zA-Z\\.\\-\\_]", "");
//             StringBuilder stb = new StringBuilder();
//             for (int i = 0; i < id.length(); i++) {
//                 char c = id.charAt(i);
//
//                 if (c == '.' || c == '_' || c == '-' || (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
//                     stb.append(c);
//                 }
//             }
//             return stb.toString();
        }

         String step3(String id) {
            id.matches(".[0-9]*");
            return id.replaceAll("[.]+", ".");
        }

         String step4(String id) {
             id = id.replaceAll("^.", "");
             id = id.replaceAll(".$", "");
             return id;

//            if (id.length() > 0 && id.charAt(0) == '.') {
//                id = id.substring(1);
//            }
//
//            if (id.length() > 0 && id.charAt(id.length()-1) == '.') {
//                id = id.substring(0, id.length() - 1);
//            }
//            return id;
        }

         String step5(String id) {
            if (id == null || "".equals(id)) {
                id = "a";
            }
            return id;
        }

         String step6(String id) {
            if (id.length() >= 16) {
                StringBuilder stb = new StringBuilder();
                for (int i = 0; i < 15; i++) {
                    if(i==14&&id.charAt(14)=='.') continue;
                    stb.append(id.charAt(i));
                }
                id = stb.toString();
            }
            return id;
        }

         String step7(String id) {
            if (id.length() <= 2) {
                char lastChar = id.charAt(id.length() - 1);
                StringBuilder idBuilder = new StringBuilder(id);

                for (int i = 0; i < 3 - id.length(); i++) {
                    idBuilder.append(lastChar);
                }
                id = idBuilder.toString();
            }
            return id;
        }
    }
}
