package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10025 {

    // 게으른 백곰 - 슬라이딩 윈도우
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()) * 2 + 1;

        // 배열 생성 (양동이 배치)
        int[] arr = new int[1000001];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken()); // 양동이의 얼음양
            int x = Integer.parseInt(st.nextToken()); // 양동이 좌표

            arr[x] = g;
        }

        // 최대합 구하기
        int max = 0; int sum = 0;
        for (int i = 0; i <= 1000000; i++) { // 제일 끝 좌표까지만 확인

            if (i - k >= 0) {
                sum -= arr[i - k];
            }
            sum += arr[i];
            max = Math.max(sum, max);
        }
        System.out.println(max);
        br.close();
    }
}
