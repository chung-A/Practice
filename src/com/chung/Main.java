package com.chung;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        //input
        Scanner scanner = new Scanner(System.in);
        HashMap<Character, Integer> map = new HashMap<>();
        String word = scanner.next();

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i);
            if (index > 91) {
                index -= 32;
            }

            char character = (char) index;
            if (!map.containsKey(character)) {
                map.put(character, 1);
            }
            else{
                map.replace(character, map.get(character) + 1);
            }
        }

        char targetKey=' ';
        int max = 0;
        List<Integer> collect = map.values().stream().sorted((c1, c2) -> c2 - c1).collect(Collectors.toList());
        if (collect.size() > 1 && collect.get(0).equals(collect.get(1))) {
            System.out.println("?");
            return;
        }

        for (Character character : map.keySet()) {
            if (map.get(character) > max) {
                targetKey = character;
                max = map.get(character);
            }
        }
        System.out.println(targetKey);
    }
}