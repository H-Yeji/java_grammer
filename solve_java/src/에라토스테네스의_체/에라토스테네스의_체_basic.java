package 에라토스테네스의_체;

import java.util.ArrayList;
import java.util.Scanner;

public class 에라토스테네스의_체_basic {

    static ArrayList<Integer> results = new ArrayList<>();
    public static void primeNumberSieve(int n) {
        int[] arr = new int[n + 1];

        // 자기 자신으로 초기화
        for (int i = 2; i <= n; i++) {
            arr[i] = i;
        }
        // 에라토스테네스의 체
        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) // 이미 방문한 숫자면 패스
                continue;
            for (int j = i + i; j <= n; j += i) { // i의 배수로 지워주기
                arr[j] = 0;
            }
        }
        // result에 소수 넣기
        for (int i = 2; i <= n; i++) {
            if (arr[i] != 0)
                results.add(arr[i]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        primeNumberSieve(n);

        for (Integer result:results) {
            System.out.println(result);
        }
    }
}
