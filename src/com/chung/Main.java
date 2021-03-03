package com.chung;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        //input
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();

        BigInteger bigIntegerA = new BigInteger(a);
        BigInteger bigIntegerB = new BigInteger(b);

        System.out.println(bigIntegerA.add(bigIntegerB));
        System.out.println(bigIntegerA.subtract(bigIntegerB));
        System.out.println(bigIntegerA.multiply(bigIntegerB));
    }
}