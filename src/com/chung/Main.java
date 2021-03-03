package com.chung;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        //input
        Scanner scanner = new Scanner(System.in);
        StringBuilder stb = new StringBuilder();
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int r = scanner.nextInt();
            String s = scanner.next();

            for (int j = 0; j < s.length(); j++) {
                for (int k = 0; k < r; k++) {
                    stb.append(s.charAt(j));
                }
            }
            System.out.println(stb.toString());
            stb.setLength(0);
        }
    }
}