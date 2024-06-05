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
        /*int money = sc.nextInt();
        if (money >= 10000) {
            System.out.println("택시타");
        } else if (money >= 3000) {
            System.out.println("버스타");
        } else {
            System.out.println("킥보드타");
        }*/

        // 삼항연산자 : 결과값 = 조건식 ? 반환값1 : 반환값2
        /*int answer = 1234;
        System.out.println("비밀번호 : ");
        int input = sc.nextInt();

        String result = (answer == input) ? "문이 열렸씁니다." : "비밀번호가 틀렸습니다";
        System.out.println(result);*/

        // switch문 : if else if 등의 조건문을 가독성있게 표현한 구문
        System.out.println("원하시는 서비스 번호를 입력하시오");
        int input = sc.nextInt();

        // 1번을 누르면 대출업무입니다, 2번을 누르면 예금업무 입니다, 3번을 누르면 적금업무입니다.
        // 0 번을 누르면 상담사 연결, 그 외를 누르면 잘못 입력 하셨습니다.
        switch (input) {
            case 0:
                System.out.println("상담사 연결");
                break;
            case 1:
                System.out.println("대출 업무");
                break;
            case 2:
                System.out.println("예금 업무");
                break;
            case 3:
                System.out.println("적금 업무");
                break;
            default:
                System.out.println("잘못 입력함요 ");
                break;
        }
    }
}
