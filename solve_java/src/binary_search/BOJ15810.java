package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15810 {

    // 풍선 공장 - 실버2
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 사람 수
        int b = Integer.parseInt(st.nextToken()); // 풍선 수

        long[] p = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(p); // 정렬

        long start = 0; long end = p[n - 1] * b; // 제일 오래 걸리는 시간 * 풍선 개수
        long result = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            long cnt = 0;

            for (int i = 0; i < n; i++) {
                cnt += (mid / p[i]);
            }

            if (cnt >= b) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(result);
    }
}
