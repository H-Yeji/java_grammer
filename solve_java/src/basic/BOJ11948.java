package basic;

import java.util.Scanner;

public class BOJ11948 {

    // 과목선택
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int minScoreA = 10000; int minScoreB = 10000;
        for (int i = 0; i < 4; i++) {
            int score = sc.nextInt();
            sum += score;
            // 물화생지 중 최저점수 찾기
            if (minScoreA > score)
                minScoreA = score;
        }
        sum -= minScoreA;

        for (int i = 0; i < 2; i++) {
            int score = sc.nextInt();
            sum += score;
            // 역사 지리 중 최저점수 찾기
            if (minScoreB > score)
                minScoreB = score;
        }
        sum -= minScoreB;

        System.out.println(sum);
    }
}
