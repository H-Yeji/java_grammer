package A3BFS;

import java.util.*;

public class B2Basic2 {

    // 배열을 하나 만들어서, 이 배열이 start node에서 얼마나 떨어져 있는지 숫자값 담기
    static List<List<Integer>> adjList;
    static Queue<Integer> q;
    static int[] visited;
    static int[] depth;
    static int cnt = 0;
    public static void bfs() {

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int n : adjList.get(node)) { // 인접한 노드 큐에 넣기
                // start node부터의 depth 구하기
                depth[n] = depth[node] + 1; // ⭐
                // target을 queue에 add하기 전에 true(1)로 세팅
                if (visited[n] == 0) {
                    q.add(n);
                    visited[n] = 1;
                }
            }
            System.out.println(node);
        }

        System.out.println("start node부터 depth : " + Arrays.toString(depth));
    }

    public static void main(String[] args) {

        int[][] arr = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 4}};

        adjList = new ArrayList<>();
        q = new LinkedList<>();
        visited = new int[6];
        for (int i = 0; i < 5; i++) {
            adjList.add(new ArrayList<>());
            visited[i] = 0;
        }
        for (int[] a: arr) {
            adjList.get(a[0]).add(a[1]); // [[1, 2], [3], [3, 4], [], []]
        }
        System.out.println(adjList); // [[1, 2], [3], [3, 4], [], []]

        // 0번째 초기화
        q.add(0);
        visited[0] = 1;
        // 0번째 (start node)의 depth 구하기
        depth = new int[5];
        depth[0] = cnt++;
        bfs();
    }
}
