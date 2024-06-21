package 다이나믹프로그래밍;

import java.util.Scanner;

public class BOJ9461 {

    // 파도반 수열
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        long[] dp = new long[101];
        dp[0] = dp[1] = dp[2] = 1;

        for (int i = 0; i < t; i++) {
            int m = sc.nextInt();

            // dp
            for (int j = 3; j < m; j++) {
                dp[j] = dp[j - 2] + dp[j - 3];
            }
            /*for (int j = 0; j < m; j++) {
                System.out.printf("%d ", dp[j]);
            }*/
            System.out.println(dp[m - 1]);
        }

        sc.close();
    }
}
