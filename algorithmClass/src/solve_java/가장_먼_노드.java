package solve_java;

import java.util.*;

public class 가장_먼_노드 {

    static List<List<Integer>> adjList;
    static Queue<Integer> q;
    static int[] visited;
    static int[] depth;
    static int cnt = 0;

    public static void bfs() {

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int n : adjList.get(node)) {
                if (visited[n] == 0) {
                    q.add(n);
                    depth[n] = depth[node] + 1;
                    visited[n] = 1;
                }
            }
        }
    }

    public static int solution(int n, int[][] edge) {

        // 인접리스트 초기화
        adjList = new ArrayList<>();
        visited = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
            visited[i] = 0;
        }
        for (int[] e : edge) {
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]); // [[], [3, 2], [3, 1, 4, 5], [6, 4, 2, 1], [3, 2], [2], [3]]
        }

        q = new LinkedList<>();
        // 1번째 초기화
        q.add(1);
        visited[1] = 1; // 1번 노드 방문처리
        depth = new int[n + 1];
        depth[1] = cnt++;

        bfs();

        // maxDepth 찾기
        int maxDepth = 0;
        for (int i = 0; i < depth.length; i++) {
            maxDepth = Math.max(maxDepth, depth[i]);
        }
        // 번외) stream으로 max 구하기
        //int max = Arrays.stream(depth).max().getAsInt();

        // maxDepth 개수 찾기
        int countNode = 0;
        for (int i = 0; i < depth.length; i++) {
            if (depth[i] == maxDepth) {
                countNode++;
            }
        }
        // 번외) strea으로 count 구하기
        /*int count = (int)Arrays.stream(depth)
                .filter(a->a==max)
                .count();*/
        return countNode;
    }

    public static void main(String[] args) {

        int n = 6;
        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(solution(n, vertex));
    }
}
