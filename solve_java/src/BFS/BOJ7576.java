package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576 {
    static int[][] box;
    static int[][] days;
    static int n, m;
    static Queue<int[]> q;

    public static void bfs() {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int s = 0; s < 4; s++) {
                int x = now[0] + dx[s];
                int y = now[1] + dy[s];
                int nextDay = now[2] + 1;

                if (x < 0 || y < 0 || x >= n || y >= m || box[x][y] == -1 || days[x][y] != 0)
                    continue;

                days[x][y] = nextDay;
                q.add(new int[]{x, y, nextDay});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        box = new int[n][m];
        days = new int[n][m];
        q = new LinkedList<>();
        boolean allRipe = true;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    q.add(new int[]{i, j, 0});
                    days[i][j] = 1;
                } else if (box[i][j] == 0) {
                    allRipe = false;
                    days[i][j] = 0; // 아직 익지 않은 토마토
                } else {
                    days[i][j] = -1; // 빈 공간
                }
            }
        }

        if (allRipe) {
            System.out.println(0);
            return;
        }
        bfs();

        int maxDay = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (days[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                maxDay = Math.max(maxDay, days[i][j]);
            }
        }
        System.out.println(maxDay);
    }
}
