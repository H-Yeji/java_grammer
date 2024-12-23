package implement;

import java.io.*;

public class BOJ1913 {
    // 실버3 닫팽이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n]; // n^2 크기의 2차원 배열
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // down > right > up > left
        int directionIndex = 0;

        int step = n * n;
        int x = 0, y = 0;
        while (step >= 1) {
            arr[x][y] = step--;

            int nx = x + directions[directionIndex][0];
            int ny = y + directions[directionIndex][1];

            // 경계 확인 및 방향 전환
            if (nx < 0 || ny < 0 || nx >= n || ny >= n || arr[nx][ny] != 0) {
                directionIndex = (directionIndex + 1) % 4; // 4방향
                nx = x + directions[directionIndex][0];
                ny = y + directions[directionIndex][1];
            }
            x = nx;
            y = ny;
        }

        int findX = 0, findY = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                bw.write(String.valueOf(arr[i][j]) + " ");
//                if (arr[i][j] == m) {
//                    findX = i + 1;
//                    findY = j + 1;
//                }
//            }
//            bw.newLine();
//        }
//        bw.write(String.valueOf(findX) + " " + String.valueOf(findY));
//
//        bw.flush();
//        bw.close();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]).append(" ");
                if (arr[i][j] == m) {
                    findX = i + 1;
                    findY = j + 1;
                }
            }
            sb.append("\n");
        }
        sb.append(findX).append(" ").append(findY);
        System.out.println(sb);

        br.close();
    }
}
