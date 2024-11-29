package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11725 {
    // 실버2 - 트리의 부모 찾기
    static List<Integer>[] tree;
    static int[] parent;
    static boolean[] visited;
    static Queue<Integer> queue;

    public static void bfs(int i) {
        queue.add(i);
        visited[i] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
//            System.out.println(now);
            for (int next: tree[now]) { // now에 연결된 수를 모두 탐색
//                System.out.println("next: " + next);
                if (visited[next]) continue;

                visited[next] = true; // 방문 안했으면 방문처리하고
                parent[next] = now; // 탐색하는 애들의 부모를 now로 업데이트 시켜줌
                queue.add(next); // 그리고 탐색하는 애들을 queue에 넣어 반복 진행
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        // tree, queue, visited, parent 선언 및 초기화
        tree = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        queue = new LinkedList<>();
        visited = new boolean[n + 1];
        parent = new int[n + 1];

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b); // 그래프 생성
            tree[b].add(a);
        }
        bfs(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }
}
