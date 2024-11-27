package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ26169 {
    // 실버3 - 세 번 이내에 사과를 먹자
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static boolean dfs(int i, int j, int apple, int step) {
        // 범위 밖이거나 장애물인 경우 return false
        if (i < 0 || i >= 5 || j < 0 || j >= 5 || arr[i][j] == -1) {
            return false;
        }
        // 사과 있으면 먹기
        if (arr[i][j] == 1) apple++;

        // 사과 2개 이상 먹었으면 끝
        if (apple >= 2) return true;

        // 3번 이상 이동했으면 끝
        if (step >= 3) return false;

        // 방문한 칸 장애물 처리
        arr[i][j] = -1;

        for (int k = 0; k < 4; k++) {
            if (dfs(i + dx[k], j + dy[k], apple, step + 1)) {
                return true;
            }
        }

        // 칸 복구
        arr[i][j] = 0;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr = new int[5][5]; // 5x5 배열
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 시작점 입력받기
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()); // 세로
        int c = Integer.parseInt(st.nextToken()); // 가로

        if (dfs(r, c, 0, 0)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
