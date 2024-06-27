package solve_java;

import java.util.Arrays;

public class 입국심사 {

    public static long solution(int n, int[] times) {
        long answer = 0;

        // times 정렬
        Arrays.sort(times);

        long start = 0; long end = (long) times[times.length - 1] * n; // 최대 걸리는 시간 * 인원수
        while(start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;

            for (int t : times) {
                sum += (mid / t); // 이 시간 (mid)동안 검사할 수 있는 모든 사람의 수
            }

            if (sum >= n) {
                end = mid - 1;
                answer = mid;
            } else {
                start = mid + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int n = 6;
        int[] times = {3, 4, 7, 10};
        solution(n, times);
    }
}
