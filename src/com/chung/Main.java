package com.chung;

import com.chung.study.MyHashTable;

import java.io.*;
import java.util.*;

public class Main {

    static final long MOD = 1000000009;

    public static void main(String[] args) throws IOException {
/*        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        long[][] d = new long[limit + 1][3];*/
        int[] d = new int[]{70,50,  80, 50};
//        System.out.println(solution(d,100));
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int startIdx = 0;

        for (int max = people.length-1; startIdx <= max; max--) {
            if (people[startIdx] + people[max] <= limit) {
                startIdx++;
            }
            answer++;
        }

        return answer;
    }

}
