package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2503 {
    // 실버3 숫자야구
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<int[]> inputNumber = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int guessNumber = Integer.parseInt(st.nextToken());
            int expectedStrike = Integer.parseInt(st.nextToken());
            int expectedBall = Integer.parseInt(st.nextToken());

            inputNumber.add(new int[]{guessNumber, expectedStrike, expectedBall});
        }

        int result = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (i == j) continue;;
                for (int k = 1; k <= 9; k++) {
                    if (k == i || k == j) continue;

                    int[] candidate = {i, j, k}; // 가능한 모든 숫자 조합이 candidate가 됨
                    if (isValidCandidate(candidate, inputNumber)) {
                        result++;
                    }
                }
            }
        }
        System.out.println(result);
    }

    // 해당 inputNumber[0]이 후보가 될 수 있는지 검증하는 메서드
    private static boolean isValidCandidate(int[] candidate, List<int[]> inputNumber) {
        // inputNumber을 형식에 맞춰 쪼개주기
        for (int[] i : inputNumber) {
            int[] guessNumber = {i[0] / 100, (i[0] / 10) % 10, i[0] % 10};
            int expectedStrike = i[1];
            int expectedBall = i[2];

            int[] resultNum = check(candidate, guessNumber);
            if (resultNum[0] != expectedStrike || resultNum[1] != expectedBall)
                return false; // 하나라도 틀리면 패스 (inputNumber 모두에 대한 strike, ball 개수가 맞는 것만 정답후보)
        }
        return true; // 모두 통과했으면 정답 후보 가능
    }

    // strike랑 ball 체크하는 메서드
    private static int[] check(int[] candidate, int[] guessNumber) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (candidate[i] == guessNumber[i]) {
                strike++; // 자릿수와 숫자가 같으면 strike
            } else if (candidate[0] == guessNumber[i] || candidate[1] == guessNumber[i] || candidate[2] == guessNumber[i]) {
                ball++; // 자리는 다른데 숫자만 같으면 ball
            }
        }
        return new int[]{strike, ball}; // strike와 ball을 담은 배열로 반환
    }
}
