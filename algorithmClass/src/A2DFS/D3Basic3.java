package A2DFS;

import java.util.ArrayList;
import java.util.List;

// ⭐⭐⭐
// 1부터 시작 -> list, 배열 1개 넉넉히 잡기
// (2) 방문 경로를 모두 list에  [[1, 2, 4, 8], [1, 2, 4, 9], [1, 2, 5, 10]..]
public class D3Basic3 {

    static List<List<Integer>> adjList;
    static List<Integer> tmp;
    static List<List<Integer>> result;

    public static void dfs(int node) {

        // 종료 조건
        if (adjList.get(node).isEmpty()) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int target: adjList.get(node)) { // node와 인접한 애들
            tmp.add(target);
            dfs(target);
            tmp.remove(tmp.size()-1);
        }

    }
    public static void main(String[] args) {

        int[][] arr = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {3, 7}, {4, 8}, {4, 9}, {5, 10}};

        adjList = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < arr.length; i++) {
            adjList.get(arr[i][0]).add(arr[i][1]);
        }
        System.out.println(adjList);

        result = new ArrayList<>(); // 부분 리스트를 넣을 전체 리스트
        tmp = new ArrayList<>(); // 부분 리스트
        tmp.add(1); // 1번노드 먼저 담기

        dfs(1);
        System.out.print("방문 노드 순서 : ");
        System.out.println(result);

    }
}
