package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ21736 {
    // 실버2 헌내기는 친구가 필요해 (bfs)
    static char[][] campus;
    static boolean[][] visit;
    static Queue<int[]> q;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        campus = new char[n][m];

        int doyeonI = 0; int doyeonJ = 0;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                campus[i][j] = line.charAt(j);
                if (campus[i][j] == 'I') {
                    doyeonI = i;
                    doyeonJ = j; // 도연이의 현 위치
                }
            }
        }
        bfs(doyeonI, doyeonJ);
    }

    private static void bfs(int i, int j) {

        int result = 0;
        // 상하좌우
        int[] x = {0, 0, -1, 1};
        int[] y = {-1, 1, 0, 0};
        visit = new boolean[n][m];

        q = new LinkedList<>();
        q.add(new int[]{i, j}); // 좌표 넣기

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            visit[poll[0]][poll[1]] = true;

            for (int d = 0; d < 4; d++) {
                int dx = x[d] + poll[0];
                int dy = y[d] + poll[1];

                if (dx >= 0 && dx < n && dy >= 0 && dy < m && !visit[dx][dy]) { // 그래프 범위면서 방문안했으면
                    if (campus[dx][dy] == 'O' || campus[dx][dy] == 'P') {
                        q.add(new int[]{dx,dy});
                        visit[dx][dy] = true;
                        if (campus[dx][dy] == 'P') result++;
                    }
                }
            }
        }
        if (result == 0) {
            System.out.println("TT");
        } else {
            System.out.println(result);
        }
    }
}
