package solve_java;

import java.util.Arrays;

public class 멀리뛰기 {

    // dp
    public static long solution(int n) {
        long answer = 0;

        // 점화식으로 풀기
        long[] dp = new long[n + 1];

        dp[0] = 0;
        dp[1] = 1;
        if (n == 1) { // n이 1일 땐 dp[2] 인덱스가 존재하면 안됨
            answer = n % 1234567;
            return answer;
        } else {
            dp[2] = 2;
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }
        //System.out.println(Arrays.toString(dp));

        answer = dp[n];
        return answer;
    }


    public static void main(String[] args) {
        int n = 1;
        System.out.println(solution(n));
    }
}
