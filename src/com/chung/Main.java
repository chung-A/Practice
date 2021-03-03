package com.chung;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        //input
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int ra = (a / 100) + ((a % 100) / 10) * 10 + (a % 10) * 100;
        int rb = (b / 100) + ((b % 100) / 10) * 10 + (b % 10) * 100;

        System.out.println(Math.max(ra, rb));
    }
}