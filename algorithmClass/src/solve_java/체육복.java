package solve_java;

import java.util.Arrays;

public class 체육복 {

    // 그리디
    static int[] cnt;
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        cnt = new int[n + 2]; // 0 ~ n
        // 모두 1로 초기화
        for (int i = 1; i <= n; i++) {
            cnt[i] = 1;
        }
        // lost학생 돌면서 -1 해주기
        for (int l : lost) {
            cnt[l] -= 1;
        }
        // reserve 돌면서 체육복 여유가 있는 학생 개수 +1 해주기
        for (int r : reserve) {
            cnt[r] += 1;
        }
        for (int i = 1; i <= n; i++) {
            if (cnt[i] == 2) { // 체육복의 여유가 있어
                if (cnt[i - 1] == 0 && i - 1 != 0) { // 앞번호가 체육복이 없으면
                    cnt[i - 1] += 1;
                    cnt[i] -= 1; // 체육복 빌려줌
                    continue;
                }
                if (cnt[i + 1] == 0 && i + 1 != n + 1) { // 뒷번호가 체육복이 없으면
                    cnt[i + 1] += 1;
                    cnt[i] -= 1; // 체육복 빌려줌
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (cnt[i] >= 1) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {

        int n = 4;
        /*int[] lost = {2, 4};
        int[] reverse = {3};*/
        /*int[] lost = {2, 4};
        int[] reverse = {1, 3, 5};*/
        /*int[] lost = {3};
        int[] reverse = {3};*/
        int[] lost = {1, 3};
        int[] reverse = {2, 4}; //마지막 반례
        System.out.println(solution(n, lost, reverse));
    }
}
