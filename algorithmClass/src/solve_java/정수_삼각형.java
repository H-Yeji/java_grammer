package solve_java;

public class 정수_삼각형 {

    public static int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle.length];

        dp[0][0] = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) { // 첫번째 열일 땐 왼쪽 숫자가 없으니 분기처리
                    int sumN = dp[i - 1][j] + triangle[i][j];
                    dp[i][j] = Math.max(sumN, dp[i][j]);
                } else {
                    // 바로 아래 경로
                    int sumN1 = dp[i - 1][j - 1] + triangle[i][j];
                    dp[i][j] = Math.max(sumN1, dp[i][j]);
                    // 대각선 아래의 경로
                    int sumN2 = dp[i - 1][j] + triangle[i][j];
                    dp[i][j] = Math.max(sumN2, dp[i][j]);

                }
            }
        }

        for (int i = 0; i < dp[triangle.length - 1].length; i++) {
            answer = Math.max(answer, dp[triangle.length - 1][i]);
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {

        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        solution(triangle);
    }
}
