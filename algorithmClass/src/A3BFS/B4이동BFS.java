package A3BFS;

import java.util.*;

public class B4이동BFS {

    /**
     * 이동 경로 => +1, -1, *2
     * start 에서 시작해 target이 되는데 몇step 걸리나 (가장 빠른 횟수)
     */
    public static void main(String[] args) {

        int start = 5;
        int target = 17;

        Queue<int[]> q = new LinkedList<>();
        int[] visited = new int[100];

        q.add(new int[]{start, 0});
        int[] pollArr = q.poll();

        while (true) {
            if (visited[pollArr[0]] == 0) {
                q.add(new int[]{pollArr[0] + 1, pollArr[1] + 1});
                q.add(new int[]{pollArr[0] - 1, pollArr[1] + 1});
                q.add(new int[]{pollArr[0] * 2, pollArr[1] + 1});
            }

            visited[pollArr[0]] = 1;
            pollArr = q.poll();

            if (pollArr[0] == target) {
                System.out.println(pollArr[1]);
                break;
            }
        }
    }
}
