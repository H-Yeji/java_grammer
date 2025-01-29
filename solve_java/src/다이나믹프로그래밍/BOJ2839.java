package 다이나믹프로그래밍;

import java.util.Scanner;

public class BOJ2839 {
    // 실버4 설탕 배달 -> dp 사용
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int inf = Integer.MAX_VALUE;

        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = inf;
        }
        dp[0] = 0; // 0kg는 봉지가 필요 없음

        // dp 점화식
        for (int i = 3; i <= n; i++) {
            if (dp[i - 3] != inf) {
                dp[i] = Math.min(dp[i], dp[i - 3] + 1);
            }
            if (i >= 5 && dp[i - 5] != inf) {
                dp[i] = Math.min(dp[i], dp[i - 5] + 1);
            }
        }
        if (dp[n] == inf) {
            System.out.println(-1);
        } else {
            System.out.println(dp[n]);
        }
        sc.close();
    }
}
