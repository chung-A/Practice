package com.chung;

import java.io.*;
import java.util.HashMap;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        boolean check = check("aabc", "bcab");
        System.out.println("check = " + check);
    }

    static HashMap<Character,Integer> map1;
    static HashMap<Character,Integer> map2;

    static boolean check(String s1, String s2) {
        if(s1.length()!=s2.length()) return false;

        map1 = new HashMap<>();
        map2 = new HashMap<>();

        addChars1(s1);
        addChars2(s2);

        for (Character c : map1.keySet()) {
            Integer i1 = map1.get(c);
            if(map2.containsKey(c)) {
                Integer i2 = map2.get(c);

                if (i1 != i2) {
                    return false;
                }
            }
            else{
                return false;
            }
        }
        return true;
    }


    static void addChars1(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map1.containsKey(c)){
                map1.replace(c, map1.get(c) + 1);
            }
            else{
                map1.put(c, 1);
            }
        }
    }

    static void addChars2(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map2.containsKey(c)){
                map2.replace(c, map2.get(c) + 1);
            }
            else{
                map2.put(c, 1);
            }
        }
    }
}
