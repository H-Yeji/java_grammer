package solve_java;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵_최단거리 {

    // bfs
    static Queue<int[]> q = new LinkedList<>();
    static int[][] path;
    static int[][] visited;

    public static void bfs(int[][] maps, int n, int m) {

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        q.add(new int[]{0, 0}); // 시작 인덱스
        visited[0][0] = 1;
        while (!q.isEmpty()) {
            int[] arr = q.poll();

            for (int i = 0; i < 4; i++) { // 상하좌우
                int x = arr[0] + dx[i];
                int y = arr[1] + dy[i];

                if (x >= 0 && y >= 0 && x < n && y < m) {
                    if (maps[x][y] == 1 && visited[x][y] == 0) {
                        visited[x][y] = 1; // 방문처리
                        q.add(new int[]{x, y});
                        path[x][y] = path[arr[0]][arr[1]] + 1;
                    }
                }
            }
        }
    }

    public static int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;

        // 초기화
        path = new int[n][m];
        visited = new int[n][m];

        bfs(maps, n, m);

        if (path[n - 1][m - 1] == 0) {
            answer = -1;
        } else {
            answer = path[n - 1][m - 1] + 1;
        }
        return answer;
    }

    public static void main(String[] args) {

        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        //int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
        System.out.println(solution(maps));
    }
}
