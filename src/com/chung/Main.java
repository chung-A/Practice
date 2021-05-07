package com.chung;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static char[] vowel = new char[]{'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[] data = new char[c];
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < c; i++) {
            data[i] = split[i].charAt(0);
        }

        Arrays.sort(data);

        List<Character> list = new ArrayList<>();
        go(0, data, length, list);
    }

    static void go(int index, char[] data, int maxLength, List<Character> list) {
        if (list.size() == maxLength) {
            //종료조건 확인
            if (check(list)) {
                String answer = list.stream().map(s -> s.toString()).collect(Collectors.joining());
                System.out.println(answer);
            }
        }
        else if (index < data.length) {
            char nowChar = data[index];

            //현재 문자를 선택한 경우
            list.add(nowChar);
            go(index + 1, data, maxLength, list);
            list.remove(list.size() - 1);    //끝나면 해당 문자 빼기

            //선택하지 않은 경우
            go(index + 1, data, maxLength, list);
        }
    }

    static boolean check(List<Character> list) {
        int vowelCount = 0;
        int jaumCount = 0;

        for (int i = 0; i < list.size(); i++) {
            char nowChar = list.get(i);
            boolean isVowel = false;
            for (int j = 0; j < vowel.length; j++) {
                if (vowel[j] == nowChar) {
                    isVowel = true;
                    break;
                }
            }

            if(isVowel) vowelCount++;
            else jaumCount++;
        }

        return vowelCount >= 1 && jaumCount >= 2;
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
