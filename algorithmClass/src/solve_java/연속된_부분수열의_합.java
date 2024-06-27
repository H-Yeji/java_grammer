package solve_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 연속된_부분수열의_합 {

    // 투포인터
    public static int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int start = 0; int end = 0;
        int sum = sequence[0];

        List<int[]> list = new ArrayList<>();
        int minLen = Integer.MAX_VALUE;
        while (start <= end) {
            if (sum == k) {
                list.add(new int[]{start, end});
                minLen = Math.min(minLen, end - start); // 최소 길이

                sum -= sequence[start];
                start++;
            } else if (sum < k && end < sequence.length - 1) {
                end++;
                sum += sequence[end];
            } else {
                sum -= sequence[start];
                start++;
            }
        }
        for (int[] l : list) {
            if (l[1] - l[0] == minLen) {
                answer = l;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        int[] sequence = {2, 2, 2, 2, 2};
        int k = 6;
        System.out.println(Arrays.toString(solution(sequence, k)));
    }
}
