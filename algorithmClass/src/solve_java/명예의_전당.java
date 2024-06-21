package solve_java;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class 명예의_전당 {

    public static int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        Queue<Integer> pq = new PriorityQueue<>();
        int cnt = 0;
        for (int s : score) {
            if (pq.size() < k) {
                pq.add(s);
            } else if (s > pq.peek()) {
                pq.add(s);
                pq.poll();
            }
            answer[cnt] = pq.peek();
            cnt++;
        }
        return answer;
    }

    public static void main(String[] args) {

        int k = 4;
        int[] score = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};
        System.out.println(Arrays.toString(solution(k, score)));
    }
}
