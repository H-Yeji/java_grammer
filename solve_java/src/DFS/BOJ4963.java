package DFS;
import java.util.Scanner;

public class BOJ4963 {
    static int w, h; // 재귀가 발생하기 때문에 전역변수 활용해서 인스턴스 공유
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            w = sc.nextInt();
            h = sc.nextInt();
            if (w == 0 && h == 0) break;

            arr = new int[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int result = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (arr[i][j] == 1) {
                        if (dfs(i, j)) {
                            result++;
                        }
                    }
                }
            }
            System.out.println(result);
        }
        sc.close();
    }

    public static boolean dfs(int i, int j) {
        if (i < 0 || i >= h || j < 0 || j >= w) {
            return false;
        }

        if (arr[i][j] == 1) {
            arr[i][j] = 0; // 방문 처리
            // 모든 방향 탐색
            for (int k = 0; k < 8; k++) {
                dfs(i + dx[k], j + dy[k]);
            }
            return true;
        }
        return false;
    }
}