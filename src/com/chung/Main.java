package com.chung;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        char[][] table = new char[size][size];
        for (int i = 0; i < size; i++) {
            String str = br.readLine();
            for(int j=0;j<str.length();j++){
                table[i][j] = str.charAt(j);
            }
        }

        int count=0;
        for(int i=0;i<size;i++){
            for (int j = 0; j < size; j++) {
                int temp = process(table, i, j);
                count = Math.max(count,temp);
            }
        }

        System.out.println(count);
    }

    //4 포인트 찍기
    static int process(char[][] table,int x,int y) {
        int count = 0;

        //left
        if(x-1>=0){
            char[][] swap = swap(table, x, y, x - 1, y);
            int result = tableCheck(swap);
            count=(count<result)?result:count;
        }

        //down
        if (y-1 >= 0) {
            char[][] swap = swap(table, x, y, x, y-1);
            int result = tableCheck(swap);
            count=(count<result)?result:count;
        }

        //right
        if(x+1<table.length){
            char[][] swap = swap(table, x, y, x + 1, y);
            int result = tableCheck(swap);
            count=(count<result)?result:count;
        }

        //up
        if (y+1 < table.length) {
            char[][] swap = swap(table, x, y, x, y+1);
            int result = tableCheck(swap);
            count=(count<result)?result:count;
        }
        return count;
    }

    static char[][] swap(char[][] table,int x,int y,int x2,int y2){
        char[][] clone = copy(table);
        char temp=clone[x][y];
        clone[x][y]=clone[x2][y2];
        clone[x2][y2]=temp;
        return clone;
    }

    static char[][] copy(char[][] table) {
        char[][] clone = new char[table.length][table.length];
        for (int i = 0; i < clone.length; i++) {
            for (int j = 0; j < clone.length; j++) {
                clone[i][j] = table[i][j];
            }
        }
        return clone;
    }

    static int tableCheck(char[][] table) {
        int count = 0;
        for (int i = 0; i < table.length; i++) {
            int temp = 1;
            for (int j = 1; j < table.length; j++) {
                if(table[i][j]==table[i][j-1]){
                    temp++;
                }
                else{
                    if(count<temp) count=temp;
                    temp = 1;
                }
            }

            if(count<temp) count=temp;
        }



        for (int i = 0; i < table.length; i++) {
            int temp = 1;
            for (int j = 1; j < table.length; j++) {
                if(table[j][i]==table[j-1][i]){
                    temp++;
                }else{
                    if(count<temp) count=temp;
                    temp = 1;

                }
            }

            if(count<temp) count=temp;
        }
        return count;
    }
}
