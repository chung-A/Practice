package com.chung.onulJib;

public class S2 {
    /**
     * public class Main {
     *
     *     static int time = 0;
     *     static int left = 0;
     *
     *     public static void main(String[] args) throws IOException {
     *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     *         int n = Integer.parseInt(br.readLine());
     *
     *         int[] peoples=new int[n];
     *         left = n;
     *         for (int i = 0; i < n; i++) {
     *             peoples[i] = Integer.parseInt(br.readLine());
     *         }
     *         Arrays.sort(peoples);
     *         goBridge(peoples, 0, peoples.length - 1);
     *
     *         System.out.println("answer --------");
     *         System.out.println(time);
     *     }
     *
     *     static void goBridge(int[] peoples, int start, int end) {
     *         if (left == 3) {
     *             System.out.println();
     *             System.out.println("=====3명 남음!====");
     *
     *             //가장 빠른 사람 두명 이동
     *             System.out.println(peoples[start]+" "+peoples[start+1]);
     *             left -= 2;
     *             start++;
     *             time += peoples[start];
     *
     *             //가장 빠른 1명 돌아옴
     *             start--;
     *             System.out.println(peoples[start]);
     *             left += 1;
     *             time+=peoples[start];
     *
     *             //가장 느린 사람과 빠른 사람이 함께 이동
     *             System.out.println(peoples[start] + " " + peoples[end]);
     *             left -= 2;
     *             start++;
     *             time += peoples[end];
     *             return;
     *         }
     *         else if (left == 2) {
     *             System.out.println("=====2명 남음!====");
     *             System.out.println(peoples[start] + " " + peoples[end]);
     *             left -= 2;
     *             time += peoples[end];
     *             return;
     *         }
     *         else{
     *             System.out.println("=====일반 싸이클!====");
     *             //가장 빠른 사람 두명 가기
     *             System.out.println(peoples[start] + " " + peoples[start + 1]);
     *             left -= 2;
     *             start++;
     *             time += peoples[start++];
     *
     *             //가장 빠른 사람 한명 돌아오기
     *             System.out.println(peoples[start-1]);
     *             left += 1;
     *             time+=peoples[--start];
     *
     *             //가장 느린 사람 두명 보내기
     *             System.out.println(peoples[end] + " " + peoples[end - 1]);
     *             left -= 2;
     *             time += peoples[end--];
     *             end--;
     *
     *             //가장 빠른 사람 한명 돌아오기
     *             System.out.println(peoples[start - 1]);
     *             left += 1;
     *             time += peoples[--start];
     *
     *             goBridge(peoples, start, end);
     *         }
     *
     *
     *     }
     *
     *
     * }
     */
}
