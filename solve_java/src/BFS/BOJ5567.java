package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ5567 {
    // 실버2 결혼식
    static List<List<Integer>> friends = new ArrayList<>();
    static boolean[] visit;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        visit = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            friends.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friends.get(a).add(b);
            friends.get(b).add(a);
        }
        bfs();

        // 출력
        int result = 0;
        for (boolean b : visit) {
            if (b) result++;
        }
        System.out.println(result - 1); // 상근이 빼기
        br.close();
    }

    private static void bfs() {
        q.add(new int[]{1, 0});
        visit[1] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();

            for (int friend : friends.get(poll[0])) {
                if (!visit[friend]) {
                    if (poll[1] + 1 >= 3) return; // 친구의 친구 사이를 넘어가면 종료

                    q.add(new int[]{friend, poll[1] + 1});
                    visit[friend] = true;
                }
            }
        }
    }
}
