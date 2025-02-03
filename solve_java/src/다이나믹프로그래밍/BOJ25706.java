package 다이나믹프로그래밍;

import java.util.Scanner;

public class BOJ25706 {
    // 실버3 자전거 묘기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] jump = new int[n + 2]; // 점프대 높이 배열 (1-indexed)
        int[] result = new int[n + 2]; // 각 칸에서 밟게 되는 칸 수 (1-indexed)

        for (int i = 1; i <= n; i++) {
            jump[i] = sc.nextInt();
        }

        // 역순으로 계산 (오른쪽에서 왼쪽으로)
        for (int i = n; i >= 1; i--) {
            if (i + jump[i] + 1 > n) { // 도로 끝을 넘어가니까 1칸
                result[i] = 1;
            } else {
                // 도로 끝을 넘어가지 않으면 => i+jump[i]인 현재 위치에서 +1한 즉, 다음 위치 result에 +1해서 넣기
                result[i] = 1 + result[i + jump[i] + 1];
            }

            // 점프대가 없는 경우는 바로 다음 칸의 결과에 1을 더함
            if (jump[i] == 0 && i + 1 <= n) {
                result[i] = 1 + result[i + 1];
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
