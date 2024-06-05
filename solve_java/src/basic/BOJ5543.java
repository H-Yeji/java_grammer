package basic;

import java.util.Scanner;

public class BOJ5543 {

    // 상근날드
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int minBurger = 4000;
        int minCoke = 4000;
        for (int i = 0; i < 3; i++) { // 햄버거 가격 입력받기
            int burger = sc.nextInt();
            minBurger = Math.min(burger, minBurger);
        }
        for (int i = 0; i < 2; i++) {
            int coke = sc.nextInt();
            minCoke = Math.min(coke, minCoke);
        }

        System.out.println(minBurger + minCoke - 50);
    }
}
