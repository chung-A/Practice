package com.chung;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int m = 1;
        while (true) {

            String s = Integer.toString(m);

            int sum = m;
            for (int i = 0; i < s.length(); i++) {
                sum += Integer.parseInt(String.valueOf(s.charAt(i)));
            }

            if (sum == n) {
                break;
            }
            else if(m==1000000){
                m = 0;
                break;
            }

            m++;
        }

        System.out.println(m);
    }

}
