package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1654 {

    // 랜선 자르기
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] len = new long[n];
        long maxLen = 0;
        for (int i = 0; i < n; i++) {
            len[i] = Integer.parseInt(br.readLine());
            maxLen = Math.max(maxLen, len[i]);
        }

        long start = 1; long end = maxLen; // divide by zero -> start=1로 해결
        long result = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += (int) (len[i] / mid); // 몫을 cnt에 더하기 => 개수
            }

            if (cnt >= k) { // 최소한 케이블을 k개 이상 생산할 수 는 경우에 결과 업데이트
                result = mid;
                start = mid + 1;
            } else { // 랜선이 부족한 경우는 result에 업데이트 ㄴㄴ
                end = mid - 1;
            }
        }
        System.out.println(result);
    }
}
