package com.chung;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static int[] arr = new int[9];

    public static void main(String[] args) throws IOException {

        //input
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        boolean isFinish=false;
        int sum = Arrays.stream(arr).sum();
        for (int i = 0; i < arr.length; i++) {
            for(int j=1;j<arr.length;j++){
                int temp = sum - arr[i] - arr[j];
                if (temp == 100) {
                    arr[i] = 1000;
                    arr[j] = 1000;
                    isFinish = true;
                    break;
                }
            }

            if(isFinish) break;
        }

        Arrays.sort(arr);
        Arrays.stream(arr).filter(s->s<1000).forEach(s->System.out.println(s));
    }
}
