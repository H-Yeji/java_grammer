package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14494 {
    // 실버3 다이나믹이 뭐예요?
    static long[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new long[n][m];

        // 첫번째 행 1로 채우기
        for (int i = 0; i <  m; i++) {
            arr[0][i] = 1L;
        }
        // 첫번째 열 1로 채우기
        for (int i = 0; i < n; i++) {
            arr[i][0] = 1L;
        }
        // n,m까지 확인
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                arr[i][j] = (arr[i - 1][j - 1] + arr[i][j - 1] + arr[i - 1][j]) % 1000000007;
            }
        }
        System.out.println(arr[n - 1][m - 1]);
    }
}
