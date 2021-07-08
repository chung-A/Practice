package com.chung;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        while (t > 0) {
            t--;
            String[] split = br.readLine().split(" ");

            switch (split[0]) {
                case "push":
                    int x = Integer.parseInt(split[1]);
                    q.add(x);
                    break;
                case "pop":
                    if(!q.isEmpty()){
                        System.out.println(q.remove());
                    }
                    else{
                        System.out.println(-1);
                    }
                    break;
                case "size":
                    System.out.println(q.size());
                    break;
                case "empty":
                    System.out.println(q.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    if(!q.isEmpty()){
                        System.out.println(q.peek());
                    }
                    else{
                        System.out.println(-1);
                    }
                    break;
                case "back":
                    if(!q.isEmpty()){
                        System.out.println(q.toArray()[q.size()-1]);
                    }
                    else{
                        System.out.println(-1);
                    }
                    break;
            }
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
