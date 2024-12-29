package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16967 {
    // 실버3 배열 복원하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[][] arr = new int[h + x][w + y];
        for (int i = 0; i < h + x; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w + y; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] arrA = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (i >= x && j >= y) { // 이 좌표부터 겹치는 부분
                    if (i + x < h && j + y < w) {
                        arrA[i][j] = arr[i][j] - arrA[i - x][j - y];
                    } else {
                        arrA[i][j] = arr[i + x][j + y];
                    }
                } else { // 안겹치면
                    arrA[i][j] = arr[i][j];
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (j == w - 1) {
                    System.out.print(arrA[i][j]);
                } else {
                    System.out.printf("%d ", arrA[i][j]);
                }
            }
            System.out.println();
        }
    }
}
