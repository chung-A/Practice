package com.chung;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        split = br.readLine().split(" ");
        int[] trees = new int[n];
        int height = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(split[i]);
            if (trees[i] > height) {
                height = trees[i];
            }
        }

        Arrays.sort(trees);
        while (sum < m) {
            height--;

            for (int i = trees.length - 1; i >= 0; i--) {
                if (trees[i] > height) {
                    sum ++;
                    continue;
                }
                break;
            }
        }
        System.out.println(height);
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int startIdx = 0;

        for (int max = people.length - 1; startIdx <= max; max--) {
            if (people[startIdx] + people[max] <= limit) {
                startIdx++;
            }
            answer++;
        }

        return answer;
    }
}
