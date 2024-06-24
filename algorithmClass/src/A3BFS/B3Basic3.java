package A3BFS;

import java.util.*;

public class B3Basic3 {

    // start 노드에서 end 노드로 가는데 '최소 거리'가 얼만가
    static List<List<Integer>> adjList;
    static Queue<Integer> q;
    static int[] visited;
    static int[] depth;
    static int cnt = 0;

    public static int bfs(int start, int end) {

        int minDepth = 0; int flag = 0;

        // start node의 초기화 설정
        q.add(start);
        visited[start] = 1; // 방문처리
        depth = new int[5];
        depth[start] = cnt++; // depth=0으로 초기화

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int n : adjList.get(node)) { // 인접한 노드 큐에 넣기
                // start node부터의 depth 구하기
                depth[n] = depth[node] + 1; // ⭐

                if (n == end) { // n이 end노드에 도달하면
                    minDepth = depth[n]; // 값 저장하고 break;
                    flag = 1;
                    break;
                }

                // target을 queue에 add하기 전에 true(1)로 세팅
                if (visited[n] == 0) {
                    q.add(n);
                    visited[n] = 1;
                }
            }
            if (flag == 1) break;
        }
        return minDepth;
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


        // 0번 노드에서 3번 노드로 가는데 depth가 얼마인가 (distance가 얼마인가)
        int start = 0;
        int end = 3;
        System.out.println("0부터 3의 depth : " + bfs(start, end)); // 0부터 3의 depth : 2
    }
}
