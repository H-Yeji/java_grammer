package two_pointer;

import java.util.Scanner;

public class BOJ2018 {

    // 수들의 합 5
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int start = 0;
        int end = 0;
        int sum = 0;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1; // 1 ~ n까지 초기화
        }

        // 투포인터
        int cnt = 0;
        while (end <= n) {
            if (sum >= n) {
                if (sum == n) cnt += 1;
                sum -= arr[start]++;
            } else {
                if (end < n)
                    sum += arr[end++];
                else
                    break;
            }
        }
        System.out.println(cnt);
        sc.close();
    }
}
