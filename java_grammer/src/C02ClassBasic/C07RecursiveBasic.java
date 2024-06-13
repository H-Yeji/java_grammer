package C02ClassBasic;

import java.util.Scanner;

public class C07RecursiveBasic {

    public static void main(String[] args) {

        /*int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        System.out.println(sum);*/

        /*System.out.println("재귀 시작");
        System.out.println(addAcc(10));
        System.out.println("재귀 끝");*/


        // 피보나치 for문
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 1 1 2 3 5 8 13 ..
        /*int[] arr = new int[n + 1]; // n번째
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        System.out.println(arr[n - 1]);*/

        // 재귀로 풀기
        System.out.println(fibo(n));
    }

    static int addAcc(int a) {

        if (a == 1) return 1;

        return a + addAcc(a - 1);
    }

    static int fibo(int n) {

        if (n <= 2) return 1;
        return fibo(n - 1) + fibo(n - 2);
    }
}
