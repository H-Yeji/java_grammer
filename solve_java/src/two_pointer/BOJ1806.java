package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1806 {

    // 부분합
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int start = 0; int end = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while (end <= n) {
            if (sum >= m) {
                minLen = Math.min(minLen, end - start);
                sum -= arr[start++];
            } else { // sum이 m보다 작을 경우
                if (end < n)
                    sum += arr[end++];
                else
                    break;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            System.out.println('0');
        } else {
            System.out.println(minLen);
        }
    }
}
