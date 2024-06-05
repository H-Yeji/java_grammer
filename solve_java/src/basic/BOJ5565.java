package basic;

import java.util.Scanner;

public class BOJ5565 {

    // 영수증
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int result = sc.nextInt();
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int book = sc.nextInt();
            sum += book;
        }
        System.out.println(result - sum);
    }
}
