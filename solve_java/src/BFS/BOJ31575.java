package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ31575 {

    // 실버3 - 도시와 비트코인
    static int n;
    static int m;
    static int[][] arr;
    static int[][] visited;
    static Queue<int[]> q;

    public static void bfs(int i, int j) {

        // 현재 위치에서 상하좌우 확인
        int[] dx = {0, 1};
        int[] dy = {1, 0};

        q.add(new int[]{i, j});
        visited[i][j] = 1; // 방문처리
        while (!q.isEmpty()) {
            int[] now = q.poll();
            // arr[세로][가로] => now[i][j] => now[세로][가로] => now[0]: 세로 = y, now[1]: 가로 = x임
            // x,y로 표시하려면 arr[y][x], visited[y][x]로 표시 ⭐⭐
            for (int k = 0; k < 2; k++) {
                int x = now[1] + dx[k]; // 가로
                int y = now[0] + dy[k]; // 세로

                // 범위 밖
                if (x < 0 || y < 0 || x >= n || y >= m) continue;
                if (arr[y][x] == 1 && visited[y][x] == 0) {
                    visited[y][x] = 1; // 방문처리
                    q.add(new int[]{y, x});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 5
        m = Integer.parseInt(st.nextToken()); // 4

        arr = new int[m][n]; // arr[i][j] = arr[세로][가로]
        visited = new int[m][n];
        q = new LinkedList<>();

        // 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 연산
        bfs(0, 0);

        if (visited[m-1][n-1] == 1) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}

