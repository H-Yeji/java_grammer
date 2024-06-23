package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2805 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] tree = new int[n];
        int Max = 0;
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            Max = Math.max(Max, tree[i]);
        }

        int start = 0; int end = Max; int mid = 0;
        int result = 0;
        while (start <= end) {
            mid = (start + end) / 2;

            long sum = 0;
            for (int t : tree) {
                if (t > mid) {
                    sum += t - mid;
                }
            }
            if (sum < m) {
                end = mid - 1;
            } else {
                result = mid;
                start = mid + 1;
            }

        }
        System.out.println(result);
        br.close();
    }
}

