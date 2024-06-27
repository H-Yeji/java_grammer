package solve_java;

public class 숫자의_표현 {

    // 투포인터
    public static int solution(int n) {
        int answer = 0;

        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++) { // 0 ~ 15
            arr[i] = i;
        }

        int start = 1; int end = 1;
        int sum = arr[1];
        while (start <= end) {
            if (sum == n) {
                sum -= arr[start];
                start++; answer++;
            } else if (sum < n && end < arr.length - 1) {
                end++;
                sum += arr[end];
            } else {
                sum -= arr[start];
                start++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 15;
        solution(n);
    }
}
