package com.chung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);

            if (map.containsKey(x)) {
                List<Integer> list = map.get(x);
                list.add(y);
            }
            else {
                List<Integer> list = new ArrayList<>();
                list.add(y);
                map.put(x, list);
            }
        }

        map.keySet().stream().sorted().forEach(x-> {
            List<Integer> list = map.get(x);
            list.stream().sorted().forEach(y ->
                    System.out.println(x + " " + y)
            );
        });
    }
}

