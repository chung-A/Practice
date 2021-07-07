package com.chung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int[][] data = new int[k + 1][n + 1];
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[0].length; j++) {
                    if (i == 0) {
                        data[i][j] = j;
                    }else{
                        if (j == 0) {
                            data[i][j] = data[i - 1][j];
                        }else{
                            data[i][j] = data[i - 1][j] + data[i][j - 1];
                        }
                    }
                }
            }
            System.out.println(data[k][n]);
            t--;
        }
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
