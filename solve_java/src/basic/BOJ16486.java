package basic;

import java.util.Scanner;

public class BOJ16486 {

    // 운동장 한 바퀴
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int d1 = sc.nextInt();
        int d2 = sc.nextInt();
        double result;

        result = (2 * d1) + (2 * d2 * 3.141592);
        System.out.println(result);

    }
}
