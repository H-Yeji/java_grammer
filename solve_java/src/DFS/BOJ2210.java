package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ2210 {
    // 실버2 숫자판 점프
    static int[][] graph;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        graph = new int[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, new StringBuilder().append(graph[i][j]));
            }
        }
//        System.out.println(set.toString());
        System.out.println(set.size());
    }

    private static void dfs(int a, int b, StringBuilder sb) {
        if (sb.length() == 6) {
            set.add(sb.toString());
            return;
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + a;
            int ny = dy[i] + b;

            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) { // 범위 내일 때만 탐색
                sb.append(graph[nx][ny]);
                dfs(nx, ny, sb);
                sb.deleteCharAt(sb.length() - 1); // 백트래킹
            }
        }
    }
}
