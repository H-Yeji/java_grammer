package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1012 {
    // 실버2 - 유기농 배추 (bfs로 풀기)
    static int t;
    static int m;
    static int n;
    static int k;
    static int[][] arr;
    static int[][] visited;
    static Queue<int[]> q;

    public static void bfs(int a, int b) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        q = new LinkedList<>();
        q.add(new int[]{a, b});
        visited[a][b] = 1; // 현재 위치 방문처리
        while(!q.isEmpty()) {
            int[] now = q.poll();

            for (int s = 0; s < 4; s++) {
                int x = now[1] + dx[s];
                int y = now[0] + dy[s];

                if (x < 0 || y < 0 || x >= m || y >= n) continue;
                if (arr[y][x] == 1 && visited[y][x] == 0) {
                    q.add(new int[]{y, x});
                    visited[y][x] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt(); // 반복 개수

        for (int i = 0; i < t; i++) { // t번 반복
            m = sc.nextInt(); // 가로 10
            n = sc.nextInt(); // 세로 8
            k = sc.nextInt(); // 배추 위치 수

            arr = new int[n][m];
            visited = new int[n][m];

            for (int j = 0; j < k; j++) {
                int x = sc.nextInt(); // 가로
                int y = sc.nextInt(); // 세로
                arr[y][x] = 1;
            }
            int cnt = 0;
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < m; b++) {
                    if (arr[a][b] == 1 && visited[a][b] == 0) {
                        // 배추가 있으면서 + 방문 안했으면
                        bfs(a, b);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
        sc.close();
    }
}
