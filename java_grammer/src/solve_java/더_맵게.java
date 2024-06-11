package solve_java;

import java.util.PriorityQueue;
import java.util.Queue;

public class 더_맵게 {

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        Queue<Integer> que = new PriorityQueue<>();
        for (int j : scoville) {
            que.add(j);
        }

        int cnt = 0;
        while (que.peek() < K) {
            if (cnt >= scoville.length - 1) {
                answer = -1;
                return answer;
            }
            int newNum = que.poll() + (que.poll() * 2);
            que.add(newNum);
            cnt++;
        }
        answer = cnt;
        return answer;
    }

    public static void main(String[] args) {

        int[] scoville = {1, 2, 3, 9, 10, 12};
        //int[] scoville = {1, 2, 3};
        int k = 45;
        System.out.println(solution(scoville, k));
    }
}
