package C01Basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class C11QueStackDeque {

    public static void main(String[] args) {

        // Queue
        /*Queue<Integer> myQueue = new LinkedList<Integer>();
        myQueue.add(10);
        myQueue.add(20);
        myQueue.add(30);
        System.out.println(myQueue.peek()); // 꺼내서 보기만 (삭제x)
        System.out.println(myQueue); // [10, 20, 30]
        System.out.println(myQueue.poll()); // 10 빠져나옴 (선입선출)
        System.out.println(myQueue); // [20, 30]*/

        // 큐를 array가 아니라 linkedlist로 사용하는 이유
        // 선입선출인데 array면 제일 앞에 원소 remove하면 그 뒤의 모든 원소를 index 앞으로 하나씩 땡겨와야함 => array remove : O(n)
        // 선입선출로 구현하기 성능이 안좋음
        // 반면에 linkedlist로 하면 요소값 확인해서 그 사이에 넣으면 되니까 ㄱㅊ
        // 근데 '조회'에선 array는 index가 있으면 바로 조회가능 O(1), linkedList는 조회할 때 값 하나씩 비교해야하므로 O(n)

        // LinkedList와 ArrayList 비교(성능 비교)
        /*LinkedList<Integer> list1 = new LinkedList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        // (1) linkedList의 add
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            list1.add(0, 10); // index=0에 value=10
        }

        long endTime = System.currentTimeMillis();
        System.out.println("linkedList의 중간삽입: " + (endTime - startTime)); // linkedList의 중간삽입: 161

        // (2) ArrayList의 add
        long startTime2 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            list2.add(0, 10); // index=0에 value=10
        }

        long endTime2 = System.currentTimeMillis();
        System.out.println("ArrayList의 중간삽입: " + (endTime2 - startTime2)); // ArrayList의 중간삽입: 84943


        // (3) LinkedList의 조회
        long startTime3 = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            list1.get(i);
        }
        long endTime3 = System.currentTimeMillis();
        System.out.println("LinkedList 조회 : " + (endTime3 - startTime3)); // LinkedList 조회 : 3283

        // (4) ArrayList의 조히
        long startTime4 = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            list2.get(i);
        }
        long endTime4 = System.currentTimeMillis();
        System.out.println("ArrayList 조회 : " + (endTime4 - startTime4)); //ArrayList 조회 : 0 */



        Queue<String> myQueue = new LinkedList<>();
        myQueue.add("문서1");
        myQueue.add("문서2");
        myQueue.add("문서3");
        myQueue.add("문서4");
        while (!myQueue.isEmpty()) {
            System.out.println(myQueue.poll()); // 다 비위질 때까지 poll (선입선출이랴 1234 순으로 출력)
        }

        // ArrayBlockingQueue : 길이 제한 큐
        Queue<String> queue = new ArrayBlockingQueue<>(3); // 길이 = 3으로 제한
        // add를 사용하면 길이제한 초과시 예외 발생
        /*queue.add("강낭콩");
        queue.add("강낭콩친구");
        queue.add("강낭콩아빠");
        // queue.add("강낭콩동생"); // queue full 에러발생
        System.out.println(queue); // [강낭콩, 강낭콩친구, 강낭콩아빠] -> 하나 주석처리하면 */

        // offer
        /*queue.offer("강낭콩");
        queue.offer("강낭콩친구");
        queue.offer("강낭콩아빠");
        queue.offer("강낭콩동생");
        System.out.println(queue); // error 안나고 그냥 세개만 들어감 */



        // 우선순위 큐 : 데이터를 꺼낼 때 정렬된 데이터 pop
        // 시간 복잡도 O(nlogn) -> 하나 꺼낼 때마다 logn, 다 꺼내면 * n
        Queue<Integer> pq = new PriorityQueue<>();
        pq.add(30);
        pq.add(20);
        pq.add(10);
        pq.add(50);
        pq.add(40);
        while (!pq.isEmpty()) {
            System.out.println(pq.poll()); // poll될 때 알아서 정렬되어서 출력됨
        }


    }

}
