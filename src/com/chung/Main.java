package com.chung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<String> list = new ArrayList<>();
        while (true) {
            st = new StringTokenizer(br.readLine());
            String k = st.nextToken();

            if (k.equals("0")) break;

            list.add(k);
        }

        for (String s : list) {
            String rst = "yes";
            int length = s.length() / 2;
            for (int i = 0; i < length; i++) {
                if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                    rst = "no";
                    break;
                }
            }

            System.out.println(rst);
        }
    }
}