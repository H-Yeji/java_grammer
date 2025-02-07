package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14248 {
    // 실버2 점프점프
    static int n;
    static int[] bridge;
    static boolean[] visit;
    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        bridge = new int[n  + 1];
        visit = new boolean[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            bridge[i] = Integer.parseInt(st.nextToken());
        }
        int start = Integer.parseInt(br.readLine());
        bfs(start);
    }

    private static void bfs(int start) {
        q = new LinkedList<>();
        q.add(new int[]{start, bridge[start]});

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            visit[poll[0]] = true;

            int right = poll[0] + poll[1];
            int left = poll[0] - poll[1];
            if (right <= n && !visit[right]) { // 범위 내면서 방문하지 않았으면
                q.add(new int[]{right, bridge[right]});
            }
            if (left > 0 && !visit[left]) {
                q.add(new int[]{left, bridge[left]});
            }
        }

        int result = 0;
        for (boolean b: visit) {
            if (b) result++;
        }
        System.out.println(result);
    }
}
