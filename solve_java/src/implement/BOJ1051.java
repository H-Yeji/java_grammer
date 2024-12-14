package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1051 {
    // 실버3 숫자 정사각형
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 입력
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            char[] numbers = tmp.toCharArray();
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(numbers[j]));
            }
        }
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                int now = arr[i][j];

                for (int k = j + 1; k < m; k++) {
                    if (arr[i][k] == now) {
                        int diff = k - j; // 차이 계산
                        // 세로도 확인 => 둘 중 하나라도 now와 같지 않다면 pass
                        if (i + diff >= n || arr[i + diff][j] != now || arr[i + diff][k] != now) continue;
                        // 둘다 같으면 그 개수 저장 (= 꼭짓점 숫자 모두 같다는 뜻)
                        int size = (diff + 1) * (diff + 1);

                        // max 비교
                        if (size > max) {
                            max = size;
                        }
                    }
                }
            }
        }
        if (max == 0) {
            System.out.println(1);
        } else {
            System.out.println(max);
        }
    }
}
