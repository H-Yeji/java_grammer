package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11501 {

    // 주식
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken()); // 3 5 9
            }

            long max_profit = arr[n - 1]; // 제일 오른쪽 값
            long sum_profit = 0;
            for (int j = n - 2; j >=0; j--) { // 배열 오른쪽부터 확인
                if (arr[j] > max_profit) {
                    max_profit = arr[j];
                } else {
                    sum_profit += (max_profit - arr[j]);
                }
            }

            System.out.println(sum_profit);
        }
        br.close();
    }
}
