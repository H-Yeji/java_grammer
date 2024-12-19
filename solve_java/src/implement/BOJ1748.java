package implement;

import java.util.Scanner;

public class BOJ1748 {
    // 실버4 수 이어쓰기1
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int result = 0;
        int start = 1;
        int len = 1;
        while (start <= n) {
            int end = Math.min(n, start * 10 - 1);
            result += (end - start + 1) * len;

            start *= 10;
            len++;
        }
        System.out.println(result);
    }
}
