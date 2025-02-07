package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ14496 {
    // 실버2 그대, 그머가 되어
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visit;
    static Queue<int[]> q = new LinkedList<>();

    public static  void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 이중 list 생성
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            list.get(p).add(q);
            list.get(q).add(p);
        }
//        System.out.println(list.toString());

        // 치환 작업
        q.add(new int[]{a, 0});
        visit = new boolean[n + 1]; // visit 배열 초기화
        visit[a] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();

            if (poll[0] == b) { // 맨 처음에 a와 b가 같은 경우도 처리해야하기 때문에 for문 내가 아니라 밖에서 조건문 걸기
                System.out.println(poll[1]);
                return;
            }
            for (int now :list.get(poll[0])) {
                if (!visit[now]) {
                    visit[now] = true; // 다음 노드를 방문했다고 표시
                    q.add(new int[]{now, poll[1] + 1});
                }
            }
        }
        System.out.println(-1);
        br.close();
    }
}
