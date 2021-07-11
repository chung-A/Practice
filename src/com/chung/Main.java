package com.chung;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        List<Location> list = new ArrayList<>();
        while (t > 0) {
            t--;
            String[] split = br.readLine().split(" ");

            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);

            list.add(new Location(x, y));
        }

        list.sort((l1,l2)->{
            if(l1.getY()==l2.getY()){
                if (l1.getX() > l2.getX()) {
                    return 1;
                }
                else{
                    return -1;
                }
            }
            else{
                if (l1.getY() > l2.getY()) {
                    return 1;
                }
                else{
                    return -1;
                }
            }
        });

        for (Location location : list) {
            System.out.println(location.getX()+" "+location.getY());
        }
    }

    public static class Location{
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
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
