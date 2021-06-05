package com.chung.six;

public class S4 {
    /**
     * 한 번에 최대 N 잔까지 동시에 커피를 추출할 수 있는 커피 추출기가 있습니다. 이 커피 추출기를 이용해 커피를 만들 때, 커피가 만들어지는 순서를 구하려 합니다.
     * 만들어야 하는 커피가 M잔이면, 커피에 1부터 M까지 순서대로 주문번호가 붙어있습니다. 또, 주문번호 순으로 빈 커피 추출구에서 커피를 만들기 시작합니다. 만약 빈 추출구가 없다면, 빈 추출구가 생길 때까지 다음 주문은 잠시 기다리며, 빈 추출구가 생기면 대기 중인 다음 커피를 즉시 만들기 시작합니다.
     * 모든 커피는 만드는데 일정 시간이 소요되는데, 소요 시간은 커피 종류별로 다를 수 있습니다. 따라서 커피 제조 시간에 따라 각 주문이 완료되는 순서는 다를 수 있습니다.
     * 커피 추출구 개수 N, 각 커피를 만드는데 걸리는 시간이 주문번호 순서대로 담긴 배열 coffee_times가 매개변수로 주어질 때, 커피가 완성되는 순서대로 주문번호를 배열에 담아 return 하도록 solution 함수를 완성해주세요.
     * 단, 커피 주문이 추출구에 배정되는데 걸리는 시간은 없다고 가정하며, 커피 추출이 동시에 완료됐을 경우 작은 주문번호가 앞에 오도록 하면 됩니다.
     * 제한사항
     * N은 1 이상 10,000 이하인 자연수입니다.
     * coffee_times의 길이는 1 이상 300,000 이하입니다.
     * coffee_times의 원소는 1 이상 100,000,000 이하인 자연수입니다.
     * 입출력 예
     * N	coffee_times	result
     * 3	[4, 2, 2, 5, 3]	[2, 3, 1, 5, 4]
     * 1	[100, 1, 50, 1, 1]	[1, 2, 3, 4, 5]
     * 입출력 예 설명
     * 입출력 예 #1
     * 커피 추출구 개수 N = 3이고, 커피별 제조시간은 주문 번호 순서대로 [ 4초, 2초, 2초, 5초, 3초]입니다.
     * 시간(초)	제작중 커피(주문 번호)	완료 순서
     * 0	[1번, 2번, 3번]	[]
     * 1	[1번, 2번, 3번]	[]
     * 2	[1번, 4번, 5번]	[2번, 3번]
     * 3	[1번, 4번, 5번]	[2번, 3번]
     * 4	[4번, 5번]	[2번, 3번, 1번]
     * 5	[4번]	[2번, 3번, 1번, 5번]
     * 6	[4번]	[2번, 3번, 1번, 5번]
     * 7	[]	[2번, 3번, 1번, 5번, 4번]
     * 빈 추출구 3곳에 1, 2, 3번 주문이 동시에 배정됩니다.
     * 2초가 지나면 2, 3번 커피가 다 만들어지고, 빈 추출구에 4, 5번 주문이 배정됩니다.
     * 4초가 지나면 1번 커피가 완료되며, 5번 주문이 배정됩니다.
     * 배정 후 3초가 지난 5초에 5번 주문이 완료됩니다.
     * 배정 후 5초가 지난 7초에 4번 주문이 완료됩니다.
     * 따라서 [2, 3, 1, 5, 4]를 return 하면 됩니다.
     * 입출력 예 #2
     * 커피 추출구 개수 N = 1이므로, 한 번에 한 잔씩 커피를 만들 수 있습니다. 따라서 커피는 주문번호 순서대로 완성됩니다.
     *
     * import java.io.*;
     * import java.util.*;
     *
     * class Solution {
     *
     *     public int[] solution(int N, int[] coffee_times) {
     *         List<Machine> machines = new ArrayList<>();
     *         for (int i = 0; i < N; i++) {
     *             machines.add(new Machine(i, -1, false));
     *         }
     *
     *         Queue<Order> orders = new LinkedList<>();
     *         List<Order> finishOrders = new ArrayList<>();
     *         for (int i = 0; i < coffee_times.length; i++) {
     *             orders.add(new Order(i, coffee_times[i]));
     *         }
     *
     *         int nowSecond = -1;
     *         while (true) {
     *             nowSecond++;
     *
     *             //machine 세팅
     *             boolean allWork = true;
     *             int near = 999999999;
     *             for (int i = 0; i < machines.size(); i++) {
     *                 Machine machine = machines.get(i);
     *                 if(machine.workYn&&machine.finishTime==nowSecond){
     *                     //완료처리
     *                     machine.workYn = false;
     *                     machine.finishTime = -1;
     *
     *                     //주문 완료
     *                     finishOrders.add(machine.order);
     *                     machine.order = null;
     *                 }
     *
     *                 if(!machine.workYn){
     *                     allWork = false;
     *                 }
     *                 near = Math.min(machine.finishTime, near);
     *             }
     *
     *             if (allWork) {
     *                 nowSecond = near - 1;
     *                 continue;
     *             }
     *
     *             if(!orders.isEmpty()) {
     *                 for (int k = 0; k < orders.size(); k++) {
     *                     Order order = orders.peek();
     *
     *                     boolean isFull = true;
     *                     for (int i = 0; i < machines.size(); i++) {
     *                         Machine machine = machines.get(i);
     *                         if (!machine.workYn) {
     *                             //주문 배정
     *                             orders.remove();
     *
     *                             machine.order = order;
     *                             machine.finishTime = (nowSecond + order.needTimes);
     *                             machine.workYn = true;
     *
     *                             isFull = false;
     *                             break;
     *                         }
     *                     }
     *
     *                     if (isFull) {
     *                         break;
     *                     }
     *
     *                 }
     *             }
     *
     *             if (finishOrders.size() == coffee_times.length) {
     *                 break;
     *             }
     *         }
     *
     *         int[] answer = new int[coffee_times.length];
     *         for (int i = 0; i < finishOrders.size(); i++) {
     *             answer[i] = finishOrders.get(i).index;
     *         }
     *         return answer;
     *     }
     *
     *     static class Order{
     *         int index;
     *         int needTimes;
     *         int status; //-1 대기중, 0 제작중, 1 완
     *
     *         public Order(int index, int needTimes) {
     *             this.index = index + 1;
     *             this.needTimes = needTimes;
     *             this.status = -1;
     *         }
     *     }
     *
     *     static class Machine{
     *         int machineId;
     *         Order order;
     *         int finishTime;
     *         boolean workYn;
     *
     *
     *         public Machine(int machineId, int finishTime, boolean workYn) {
     *             this.machineId = machineId;
     *             this.finishTime = finishTime;
     *             this.workYn = workYn;
     *         }
     *     }
     *
     *
     * }
     */
}
