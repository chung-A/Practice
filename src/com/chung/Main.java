package com.chung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int k = 0; k < n; k++) {
            List<Character> wordList = new ArrayList<>();

            String word = br.readLine();
            char prevChar = ' ';
            boolean isGroupWord = true;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                if (prevChar != c && wordList.contains(c)) {
                    isGroupWord = false;
                    break;
                }
                else if (prevChar != c) {
                    prevChar = c;
                    wordList.add(c);
                }
            }

            if (isGroupWord) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}

