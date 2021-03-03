package com.chung;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        //input
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] cols = new int[n + 1];

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            cols[1] = i;
            answer += queens(n, cols, 1);
        }

        System.out.println(answer);
    }

    public static int queens(int n, int[] cols, int level) {
        if (!isPromised(cols, level)) {
            return 0;
        } else if (level == n) {
            return 1;
        } else {
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                cols[level + 1] = i;
                sum += queens(n, cols, level + 1);
            }
            return sum;
        }
    }

    public static boolean isPromised(int[] cols, int level) {
        for (int i = 1; i < level; i++) {
            if (cols[i] == cols[level]) {
                return false;
            }
            else if (level - i == Math.abs(cols[level] - cols[i])) {
                return false;
            }
        }
        return true;
    }
}
