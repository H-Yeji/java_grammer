package 에라토스테네스의_체;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2960 {

    // 실버4 에라토스테네스의 체
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        // 배열 초기화
        for (int i = 2; i <= n; i++) {
            arr[i] = i;
        }

        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) continue;

            for (int j = i; j <= n; j += i) {
                if (arr[j] == 0) continue;
                arr[j] = 0;
                cnt++;

                if (cnt == k) {
                    System.out.println(j);
                    return;
                }
            }
        }
    }
}
