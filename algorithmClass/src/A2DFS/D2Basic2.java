package A2DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D2Basic2 {

    // 양방향 dfs 구현
    static List<List<Integer>> adjList;
    static int[] visited;
    static int[] result;
    static int cnt = 0;
    public static void dfs(int node) {

        if (visited[node] != 0) return; // 방문한 노드면 반환

        visited[node] = 1; // 방문하지 않은 노드는 방문처리
        result[cnt++] = node; // 방문한 노드 저장
        for (int n : adjList.get(node)) {
            dfs(n);
        }
    }

    public static void main(String[] args) {

        int[][] arr = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {3, 5}, {2, 4}};

        adjList = new ArrayList<>();
        // 방문 배열
        visited = new int[6]; // node 개수 + 1
        result = new int[6]; // 방문 노드 순서 저장
        for (int i = 0; i < 6; i++) {
            adjList.add(new ArrayList<>());
            visited[i] = 0;
        }
        for (int[] a: arr) {
            adjList.get(a[0]).add(a[1]); // [[1, 2], [3], [3, 4], [], []]
            adjList.get(a[1]).add(a[0]); // 양방향 추가
        }
        System.out.println("graph : " + adjList); // [[1, 2], [0, 3], [0, 3, 4], [1, 2, 5], [2], [3]]

        // 함수 호출
        dfs(0);

        // 출력
        System.out.print("방문 순서 : ");
        System.out.println(Arrays.toString(result)); // [0, 1, 3, 2, 4, 5]
    }
}
