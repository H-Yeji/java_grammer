package A2DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D1Basic {

    // dfs 구현
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

        // 그래프 생성 표현식 1
        // 방문할 수 있는 정점이 여러개인 경우, 정점 번호가 작은 것을 먼저 방문하는
        // dfs 알고리즘 형식의 방문 순서를 출력
        int[][] arr = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 4}}; // 0->1, 0->2
        // 그래프 생성 표현식 2
        // int[][] arr2 = {{1, 1, 1, 0, 0}, {0, 1, 0, 1, 0}}; // 갈 수 있는 곳 1, 갈 수 없는 곳 0 (노드 5개일 경우)

        adjList = new ArrayList<>();
        // 방문 배열
        visited = new int[5]; // node 개수 + 1
        result = new int[5]; // 방문 노드 순서 저장
        for (int i = 0; i < 5; i++) {
            adjList.add(new ArrayList<>());
            visited[i] = 0;
        }
        for (int[] a: arr) {
            adjList.get(a[0]).add(a[1]); // [[1, 2], [3], [3, 4], [], []]
            // 양방향일 경우
            // adjList.get(a[1]).add(a[0]);
        }

        // 함수 호출
        dfs(0);

        // 출력
        System.out.println(Arrays.toString(result)); // [0, 1, 3, 2, 4]
    }
}
