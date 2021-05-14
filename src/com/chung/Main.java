package com.chung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(br.readLine());

        while (testCaseCount > 0) {
            testCaseCount--;
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int target = Integer.parseInt(tokenizer.nextToken());

            String[] split = br.readLine().split(" ");
            Queue<Document> queue = new LinkedList<>();

            int maxPriority = -1;
            for (int i = 0; i < n; i++) {
                int priority = Integer.parseInt(split[i]);
                maxPriority = Math.max(priority, maxPriority);

                queue.add(new Document(priority, target == i));
            }

            int printCount = 0;
            while (true) {
                Document doc = queue.remove();
                if (doc.getPriority() == maxPriority) {
                    //인쇄하는 경우
                    printCount++;
                    if (doc.isTarget()) {
                        System.out.println(printCount);
                        break;
                    }
                    maxPriority = getMaxPriority(new ArrayList<>(queue));
                }
                else{
                    //맨 뒤로 보내는 경우
                    queue.add(doc);
                }

            }
        }
    }

    public static int getMaxPriority(List<Document> documents) {
        return documents.stream().mapToInt(d -> d.getPriority()).max().getAsInt();
    }

    public static class Document{
        private Integer priority;
        private boolean target;

        public Document(Integer priority,boolean target) {
            this.priority = priority;
            this.target = target;
        }

        public Integer getPriority() {
            return priority;
        }


        public boolean isTarget() {
            return target;
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
                if(!isSosu[i]){
                    isSosu[i] = true;

                }
            }
        }

        // 이 위부터
    }
}
