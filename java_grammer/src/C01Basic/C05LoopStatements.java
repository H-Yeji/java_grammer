package C01Basic;

import java.util.Arrays;
import java.util.Scanner;

public class C05LoopStatements {

    public static void main(String[] args) {

        // while
        Scanner sc = new Scanner(System.in);
        /*int a = 2;
        while (a <= 10) {
            System.out.println(a);
            a += 1;
        }*/

        // 입력한 숫자의 구구단
        /*int i = 1;
        int n = sc.nextInt();
        while (i < 10) {
            System.out.printf("%d x %d = %d\n", n, i, n*i);
            i += 1;
        }*/

        // 도어락 예제 while로 풀기
        // int를 string으로 변경
        // 비밀번호 맞추면 변경
        // 조건 추가 ) 비밀번호가 5회 이상 틀리면 종료
        /*int result = 1234;
        int cnt = 0;
        while (true) {
            String pwd = sc.next();
            int pwdNum = Integer.parseInt(pwd); // string to int

            if (result == pwdNum) {
                System.out.println("정 답 ! ");
                break;
            }
            System.out.println("비밀번호가 틀렸습니다.");
            cnt += 1;
            if (cnt == 5) {
                System.out.println("비밀번호를 5회 틀렸습니다 !!!! 멍청아 !! ");
                break;
            }
        }*/

        // string끼리 비교 => answer.equals(input)

        // 1234 뒤집기
        /*int num = 1234;
        while(num > 0) {
            System.out.print(num % 10);
            num /= 10;
        }*/

        // do-while
        /*int a = 0;
        do {
            a++;
            System.out.println(a);
        }while (a < 11);*/


        // for문
        /*for (int i = 2; i <= 10; i++) {
            System.out.println(i);
        }*/

        // 1 ~ 10중에 홀수만 출력
        /*for (int i = 1; i <= 10; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }*/

        // 1~20까지의 수 중 짝수를 모두 더한 값
        /*int sum = 0;
        for (int i =1; i <= 20; i++) {
            if (i % 2 == 0)
                sum += i;
        }
        System.out.println(sum);*/

        // 최대 공약수 구하기
        /*int maxNum = 0;
        int a = 24; int b = 36;
        int maxAB = Math.min(a, b);

        for (int i = 1; i <= maxAB; i++) {
            if (a % i == 0 &&  b % i == 0) {
                maxNum = Math.max(maxNum, i);
            }
        }
        System.out.println(maxNum);*/

        // 소수 구하기 : 1과 자기자신을 제외한 숫자로 나누어지지 않는 수
        // 1~24까지 수 중 소수를 출력
        /*System.out.println(2);
        int flag = 0;
        for (int i = 3; i <= 24; i++) {
            flag = 0;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                System.out.println(i);
            }
        }

        // for문 하나 사용한 소수찾기
        for (int input=2; input<=24; input++) {
            boolean trueOrNot=false;
            for(int i =2; i <input; i++) {
                if(input%i == 0) {
                    trueOrNot = true;
                    break;
                }
            }
            if (trueOrNot == false) {
                System.out.printf("%d는 소수임", input);
            }
        }*/

        // 홀수만 출력하기 (1~10) => continue 활용하기
        /*for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue;
            }
            System.out.println(i);
        }*/

        // enhanced for문 (향상된 for문 - for each문)
        int[] arr = {1, 3, 5, 7, 9};
        /*
        for (int i = 0; i < 5; i++) {
            System.out.println(arr[i]);
        }
        for (int i : arr) {
            System.out.println(i);
        }*/

        // 일반 for문을 통한 arr값 변경 후 출력
        /*for (int i = 0; i < 5; i++) {
            arr[i] += 10;
        }
        System.out.println(Arrays.toString(arr)); // 메모리 주소 출력이 아닌 내용 출력

        // 향상된 for문을 통한 arr 값 변경 후 출력
        for (int i : arr) {
            i += 10; // 이 방법은 값이 변경이 안됨 (향상된 for문은 값을 바꿀 수 없음)
        }
        System.out.println(Arrays.toString(arr));*/


        // 자바 변수의 유효범위 : {}
        // if문 밖에서는 abc의 존재를 모름
        /*int num = 10;
        if (num > 1) {
            int abc = 20;
            num = 20;
        }*/

        // 다중 반복문
        /*for (int i = 2; i <= 9; i++) {
            System.out.printf("-----%d단 입니다.----\n", i);
            for (int j = 1; j <= 9; j++) {
                System.out.printf("%d x %d = %d\n", i, j, i*j);
            }
            System.out.println();
        }*/

        // 프로그래머스 - 직사각형 별찍기
        /*int a = sc.nextInt();
        int b = sc.nextInt();

        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                System.out.print("*");
            }
            System.out.println();
        }*/

        // 라벨문
        /*loop1:
        for(int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println("hh");
                if (j == 2)
                    break loop1; // 2중for문 전체를 한번에 중단시킬 수 있음
            }
        }*/

        // 라벨문 예제
        int[][] arr2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        //System.out.println(Arrays.toString(arr2[0])); // {1, 2, 3}
        //System.out.println(arr2[2][0]);
        //System.out.println(arr2.length);

        int target = 11;
        loop2:
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                if (arr2[i][j] == target) {
                    System.out.printf("%d, %d 위치에 11이 있음", i, j);
                    break loop2;
                }
            }
        }

    }

}
