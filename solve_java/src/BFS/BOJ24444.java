package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ24444 {

    // 알고리즘 수업 (너비우선탐색1) - 실버2
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점 수
        int m = Integer.parseInt(st.nextToken()); // 간선 수
        int r = Integer.parseInt(st.nextToken()); // 시작 정점

        List<TreeSet<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) { // 노드 수만큼 초기화
            graph.add(new TreeSet<>());
        }

        for (int i = 0; i < m; i++) { // 노드 수만큼 입력받고 그래프 생성
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from); // 양방향
        }

        // 방문용 배열
        Boolean[] visited = new Boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            visited[i] = false;
        }
        // 큐 선언
        Queue<Integer> q = new LinkedList<>();
        int[] visited_order = new int[n + 1];

        q.add(r); // 시작 노드
        int cnt = 1;
        while(!q.isEmpty()) {
            int num = q.poll();

            if (!visited[num]) {
                visited[num] = true;
                visited_order[num] = cnt;
                cnt++;
                for (int neighbor: graph.get(num)) {
                    q.offer(neighbor);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(visited_order[i]);
        }
    }
}
