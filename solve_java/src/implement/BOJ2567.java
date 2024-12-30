package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2567 {
    // 실버4 색종이2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] paper = new int[102][102];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    paper[j][k] = 1;
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int length = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (paper[i][j] == 1) {
                    // 네방향 다 확인
                    for (int s = 0; s < 4; s++) {
                        int nx = i + dx[s];
                        int ny = j + dy[s];

                        // 범위 내면서 상하좌우가 0이면
                        if ((nx >= 1 && ny >= 1 && nx <= 100 && ny <= 100) && paper[nx][ny] == 0) length++;
                        else if (!(nx >= 1 && ny >= 1 && nx <= 100 && ny <= 100)) length++;
                     }
                }
            }
        }
        System.out.println(length);
    }
}
