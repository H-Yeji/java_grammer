package C01Basic;

import java.util.Scanner;

public class C04IfStatements {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 도어락 키 if문
        /*int answer = 1234;
        int num = sc.nextInt();

        if(num == answer) {
            System.out.println("문이 열림요");
        } else {
            System.out.println("문 안열림요");
        }*/

        // 실습1) 알파벳이 소문자인지 대문자인지 판별하는 프로그램
        /*String s = sc.nextLine();
        char a = s.charAt(0); // char ch1 = sc.nextLine().charAt(0) 한 줄로도 가능

        if (a >= 'a' && a <= 'z') {
            System.out.println("소문자");
        } else if (a >= 'A' && a <= 'Z'){
            System.out.println("대문자");
        }*/

        // 실습2 ) 택시 요금 10000원. 버스 요금 3000원. 킥보드 요금 2000원
        // 사용자에게 얼마나 있는지 물어보고, 구간별로 교통수단 추천
        int money = sc.nextInt();
        if (money >= 10000) {
            System.out.println("택시타");
        } else if (money >= 3000) {
            System.out.println("버스타");
        } else {
            System.out.println("킥보드타");
        }
    }
}
