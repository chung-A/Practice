package com.chung.toy.study;

import com.chung.toy.study.sort.utils.Sort;

import java.util.List;

import static com.chung.toy.study.sort.utils.SortUtils.generateArray;
import static com.chung.toy.study.sort.utils.SortUtils.printArray;

public class Toy {


    /*        Sort selectionSort = new SelectionSort();
        doSort(selectionSort);

        Sort insertionSort = new InsertionSort();
        doSort(insertionSort);

        Sort bubbleSort = new BubbleSort();
        doSort(bubbleSort);

        Sort mergeSort = new MergeSort();
        doSort(mergeSort);

        Sort quickSort = new QuickSort();
        doSort(quickSort);

        System.out.println();
        int[] array = generateArray(1000);
        quickSort.sort(array);
        printArray(array);
        BinarySearch search = new BinarySearch();
        int i = search.find(array, 1);
        System.out.println(i);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        long x = Integer.parseInt(split[0]);
        long y = Integer.parseInt(split[1]);

        long defaultZ = (long) ((double) y * 100 / (double) x);
        if (defaultZ >= 99) {
            System.out.println(-1);
            return;
        }

        //mid = 게임 횟수
        long left = 0;
        long right = 1000000000;
        long answer = -1;
        while (left <= right) {
            long mid = (left + right) / 2;

            long newZ = (long) ((double) (y + mid) * 100 / (double) (x + mid));
            if (newZ > defaultZ) {
                right = mid - 1;
                answer = mid;
            }
            else{
                left = mid + 1;
            }
        }
        System.out.println(answer);*/

    private static void doSort(Sort sort) {
        System.out.println("[" + sort.getClass().getSimpleName() + "]");
        int[] array = generateArray(100);
        printArray(array);

        long start = System.currentTimeMillis();
        sort.sort(array);
        long end = System.currentTimeMillis();

        printArray(array);

        System.out.println("걸린 시간: " + (end - start)+"ms");
        System.out.println();
    }

    static int fibo1(int num) {
        if(num>0){
            return fibo1(num-1) + fibo1(num-2);
        }
        else{
            return 0;
        }
    }

    static long fibo2(int num) {
        long[] memo = new long[num + 1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= num; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        return memo[num];
    }

    static long fact(int n) {
        if (n <= 1) {
            return 1;
        }
        else{
            return n * fact(n - 1);
        }
    }

    static void random() {
        for (int i = 0; i < 50; i++) {
            int ran = (int) (Math.random() * 10) + 1;
            System.out.println(ran);
        }
    }

    static void binarySearch(List<Integer> list, int num) {
        if (list.get(list.size() - 1) < num) {
            list.add(num);
        }
        else if (list.get(list.size() - 1) > num) {
            //이진탐색
            int left = 0;
            int right = list.size() - 1;
            int answer = 0;

            while (left <= right) {
                int mid = (left + right) / 2;

                Integer midNum = list.get(mid);
                if (midNum >= num) {
                    right = mid - 1;
                    answer = mid;
                } else {
                    left = mid + 1;
                }
            }

            list.set(answer, num);
        }
    }

    public static int solution(int[] d, int budget) {

        return 0;
    }
}
