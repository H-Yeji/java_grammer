package solve_java;

import java.util.*;

public class 야근지수 {

    // 프로그래머스 - lv3
    public static long solution(int n, int[] works) {
        long answer = 0;

        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            q.add(work);
        }
        while (true) {
            if (n == 0) break;

            int m = q.poll();
            int newNum = m - 1;
            if (newNum < 0) break;
            q.add(newNum);
            n -= 1;
        }

        while (!q.isEmpty()) {
            int peekNum = q.poll();
            answer += ((long) peekNum * peekNum);
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] works = {4, 3, 3};
        int n = 4;

        System.out.println(solution(n, works));
    }
}
