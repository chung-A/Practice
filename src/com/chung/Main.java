package com.chung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String[] lang = new String[]{"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int answer = 0;
        for (int i = 0; i < lang.length; i++) {
            String alpha = lang[i];
            if (str.contains(alpha)) {
                int fromIdx = 0;
                while (true) {
                    int startIdx = str.indexOf(alpha, fromIdx);

                    if(startIdx!=-1) {
                        fromIdx = startIdx + 1;
                        answer++;
                    }else{
                        break;
                    }
                }
                str = str.replace(alpha, "@");
            }
        }

        str = str.replace("@", "");
        answer += str.length();
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
