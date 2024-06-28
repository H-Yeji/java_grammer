package solve_java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ17086 {

    // 아기상어2
    static int[][] arr;
    static int max = 0;
    public static void bfs(int i, int j, int n, int m) {

        // 계속 갱신
        int[][] distance = new int[n][m];
        int[][] visited = new int[n][m];
        Queue<int[]> q = new LinkedList<>();

        // 8방향
        int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

        q.add(new int[]{i, j}); // 시작 위치 큐에 넣기
        visited[i][j] = 1; // 방문처리
        while (!q.isEmpty()) {
            int[] tmp = q.poll();

            for (int s = 0; s < 8; s++) { //상하좌우 대각선 8방향 탐색
                int x = tmp[0] + dx[s];
                int y = tmp[1] + dy[s];

                // 범위 밖 패스
                if (x < 0 || y < 0 || x >= n || y >= m) continue;
                if (arr[x][y] == 0 && visited[x][y] == 0) { // 상어가 없으면서 방문하지 않은 경우 => 방문처리 해주고 큐에 넣어주기
                    visited[x][y] = 1;
                    q.add(new int[]{x, y});
                    distance[x][y] = distance[tmp[0]][tmp[1]] + 1; // 해당 위치 +1로 거리 더해주기
                } else if (arr[x][y] == 1) { // 상어를 만나면
                    distance[x][y] = distance[tmp[0]][tmp[1]] + 1; // 해당 위치 +1로 거리 더해주기
                    max = Math.max(distance[x][y], max); // 그 때 값과 max값 비교해서 갱신
                    return; // 1을 만났으니 종료
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[n][m];

        // 입력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    bfs(i, j, n, m);
                }
            }
        }
        System.out.println(max);
    }
}
