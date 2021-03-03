package com.chung;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        //input
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        int avg = scanner.nextInt();

        int i = (avg - 1) * cnt + 1;
        System.out.println(i);
    }
}