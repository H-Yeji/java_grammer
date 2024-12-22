package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10157 {
    // 실버3 자리배정
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken()); // 가로 c개 (7)
        int r = Integer.parseInt(st.nextToken()); // 세로 r개 (6)
        int k = Integer.parseInt(br.readLine());

        if (k > r * c) {
            System.out.println(0);
            return;
        }

        int[][] seat = new int[r][c];
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 상하좌우
        int directionIndex = 0;

        int x = r - 1, y = 0;
        int step = 1;
        while (step < k) {
            seat[x][y] = step++;

            int nx = x + directions[directionIndex][0];
            int ny = y + directions[directionIndex][1];

            // 경계 확인 및 방향 전환
            if (nx < 0 || ny < 0 || nx >= r || ny >= c || seat[nx][ny] != 0) {
                directionIndex = (directionIndex + 1) % 4;
                nx = x + directions[directionIndex][0];
                ny = y + directions[directionIndex][1];
            }
            x = nx;
            y = ny;
        }
        System.out.printf("%d %d", y + 1, r - x);
    }
}
