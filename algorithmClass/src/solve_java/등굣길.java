package solve_java;

import java.util.Arrays;

public class 등굣길 {

    public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;

        int[][] dp = new int[n][m]; // dp 모두 0
        // 웅덩이 표시
        for (int i = 0; i < puddles.length; i++) {
            int x = puddles[i][0] - 1;
            int y = puddles[i][1] - 1;

            dp[y][x] = -1; // 웅덩이 표시
        }
        System.out.println(Arrays.deepToString(dp));
        // 첫번째 열과 행 세팅
        for (int i = 1; i < m; i++) {
            // 첫번째 행 초기화
            if (dp[0][i] != -1) { // 웅덩이 없으면 행 모두 경로 1개 처리
                dp[0][i] = 1;
            } else { // 웅덩이야
                break;
            }
            //dp[0][i] = 0; // 웅덩이가 있으면 그 다음부턴 모두 0
        }
        for (int i = 1; i < n; i++) {
            // 첫번째 열 초기화
            if (dp[i][0] != -1) { // 웅덩이 없으면 열 모두 경로 1개 처리
                dp[i][0] = 1;
            } else {
                break;
            }
            //dp[i][0] = 0; // 웅동이 있으면 그 다음부터 모두 0
        }
        System.out.println(Arrays.deepToString(dp));
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (dp[i][j] != -1) { // 웅덩이 아니야
                    // 첫번째 -> 위 왼쪽 모두 웅덩이 x
                    if (dp[i - 1][j] != -1 && dp[i][j - 1] != -1)
                        dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
                    // 두번째 -> 위 웅덩이, 왼쪽 웅덩이 x
                    else if (dp[i - 1][j] == -1 && dp[i][j - 1] != -1)
                        dp[i][j] = dp[i][j - 1] % 1000000007;
                    // 세번째 -> 위 웅덩이 x, 왼쪽 웅덩이
                    else if (dp[i - 1][j] != -1 && dp[i][j - 1] == -1) {
                        dp[i][j] = dp[i - 1][j] % 1000000007;
                    }
                    // 네번째 -> 모두 웅덩이면 갈 곳 없음
                    else
                        dp[i][j] = 0;
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        answer = dp[n - 1][m - 1];
        return answer;
    }

    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 1}};
        System.out.println(solution(m, n, puddles));
    }
}
