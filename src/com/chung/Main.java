package com.chung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int max = -5000;
        int min = 5000;
        long sum = 0;
        int middle = 0;
        int targetIdx = n / 2;

        int index = 0;
        while (n > index) {
            int value = Integer.parseInt(br.readLine());

            //최빈값 계산
            if (countMap.containsKey(value)) {
                countMap.replace(value, countMap.get(value)+1);
            }
            else{
                countMap.put(value, 1);
            }

            //최소, 최대값 계산
            max = Math.max(max, value);
            min = Math.min(min, value);

            //산술평균 용
            sum += value;

            list.add(value);
            index++;
        }

        int count = list.size();

        //산술
        double average= (double) sum / (double) count;
        System.out.println(Math.round(average));

        //중앙값
        Collections.sort(list);
        System.out.println(list.get(targetIdx));

        //최빈값
        System.out.println(getChoiBeanGab(countMap));

        //범위
        System.out.println(Math.abs(max - min));
    }

    public static int getChoiBeanGab(Map<Integer, Integer> countMap) {
        List<Integer> list = new ArrayList<>();
        int max = countMap.values().stream().mapToInt(c -> c).max().getAsInt();
        for (Integer key : countMap.keySet()) {
            if (countMap.get(key) == max) {
                list.add(key);
            }
        }

        if (list.size() > 1) {
            Collections.sort(list);
            return list.get(1);
        }else{
            return list.get(0);
        }
    }

    /***************************************************************
     * Programmers
     **************************************************************/
    public static class Programmers {

        boolean[] isSosu = new boolean[50001];

        public int solution(int[] nums) {
            int answer = -1;

            // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
            System.out.println("Hello Java");

            return answer;
        }

        void init() {
            for (int i = 2; i < isSosu.length; i++) {
                if (!isSosu[i]) {
                    isSosu[i] = true;

                }
            }
        }

        // 이 위부터
    }
}
