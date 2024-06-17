package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1940 {

    // 주몽
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        // 재료 입력받기
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 정렬
        Arrays.sort(arr);

        // 투 포인터
        int start = 0; int end = n - 1;
        int cnt = 0; int sum = 0;
        while (start < end) {
            if (arr[start] + arr[end] < m) {
                start++;
            } else {
                if (arr[start] + arr[end] == m) cnt++;
                end--;
            }
        }

        System.out.println(cnt);
        br.close();
    }
}
