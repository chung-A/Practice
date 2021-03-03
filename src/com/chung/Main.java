package com.chung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        List<String> collect = list.stream().sorted((s1, s2) -> {
            if (s1.length() > s2.length()) {
                return 1;
            } else if (s1.length() < s2.length()) {
                return -1;
            } else {
                for (int i = 0; i < s1.length(); i++) {
                    if (s1.charAt(i) < s2.charAt(i)) {
                        return -1;
                    } else if (s1.charAt(i) > s2.charAt(i)) {
                        return 1;
                    }
                }
                return 0;
            }
        }).collect(Collectors.toList());

        StringBuilder stb = new StringBuilder();

        stb.append(collect.get(0)).append('\n');
        for (int i = 1; i < n; i++) {
            if (!collect.get(i).equals(collect.get(i - 1))) {
                stb.append(collect.get(i)).append('\n');
            }
        }
        System.out.println(stb);
    }
}