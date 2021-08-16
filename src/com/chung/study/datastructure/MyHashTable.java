package com.chung.study.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MyHashTable {

    static class Node{
        String key;
        String value;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    LinkedList[] data;

    public MyHashTable(int size) {
        data = new LinkedList[size];
    }

    public int getHashKey(String key) {
        int code = 0;
        for (int i = 0; i < key.length(); i++) {
            code += key.charAt(i);
        }
        return code;
    }

    public void put(String key,String value){
        int index = getHashKey(key) % data.length;

        if(data[index]==null) data[index] = new LinkedList<Node>();

        data[index].add(new Node(key, value));
    }

    public String findValue(List<Node> nodes, String key) {
        if(nodes==null||nodes.size()<=0) return "not found";

        for (Node node : nodes) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return "not found";
    }

    public String get(String key) {
        int index = getHashKey(key) % data.length;
        return findValue(data[index], key);
    }
}
