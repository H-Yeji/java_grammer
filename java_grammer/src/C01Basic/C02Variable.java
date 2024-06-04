package C01Basic;

import java.math.BigDecimal;
import java.util.Scanner;

public class C02Variable {

    // 정수 int, long
    // 실수 float, double
    // 문자 char
    // 불린 boolean-true/false
    // null
    public static void main(String[] args) {

        byte a = 127;
        byte b = -128;

        a++; // -128이 나옴 (byte 타입이기 때문에 128이 없음 => overflow)
        b--;  // 127이 나옴 (byte 타입이라 -129는 없음 => underflow)

        System.out.println(a);
        System.out.println(b);

        int int_a = 10;
        long long_a = 20L;

        // 실수는 float, double
        float f1 = 1.123f; // f붙이는거 생략 x
        double d1 = 1.123;

        // 부동 소수점 오차 테스트
        double d2 = 0.1;
        System.out.println(d2);

        double total = 0;
        for (int i = 0; i < 1000; i++) {
            total += 0.1;
        }
        System.out.println(total);

        // 소수점 오차의 대안으로 bigdecimal 클래스 사용
        double d3 = 1.03;
        double d4 = 0.42;

        System.out.println(d3 - d4); // 결과 0.6100000000000001 (이상)

        // bigdecimal의 원리 : 저장할 때 문자열로 저장해서,
        // 연산할 때 정수로 변환, 최종결과는 실수로 반환
        BigDecimal b1 = new BigDecimal("1.03"); // 문자열
        BigDecimal b2 = new BigDecimal("0.42");
        // bigdecimal 타입의 b1에서 b2를 subtract으로 빼고 그걸 double 형태로 바꿔줌
        double result = b1.subtract(b2).doubleValue();
        System.out.println();
        // bigdecimal의 단점 => 계속 타입 변형을 해야해서 연산의 속도가 느림 (코테보단 실무같은 곳에 쓰임)

        // 문자형 : char [char와 string은 초기값이 null임]
        char m1 = '가'; // "" 쓰면 에러남 char에서
        System.out.println(m1);

        // boolean : true or false
        boolean bool1 = true;
        boolean bool2 = false; // boolean값은 초기값이 false임 (아무것도 지정하지 않으면)

        Scanner sc = new Scanner(System.in);
        /*int input1 = sc.nextInt();
        boolean bool3 = input1 > 0;
        // if 조건절 안에 boolean 타입값이 들어옴에 유의
        if (bool3) {
            System.out.println("조건식이 참입니다.");
        }*/

        // 타입변환
        // 묵시적 타입 변환 -> 코딩으로 굳이 표현안해도 알아서 변환
        char ch1 = 'a';
        int ch1_num = ch1;
        System.out.println(ch1_num); // 97이 나옴 (내가 지정하지 않아도 알아서 묵시적으로 처리됨)

        // 알파벳 비교를 위한 묵시적 타입변환 발생
        System.out.println('a'>'b');

        // int -> double 형변환은 문제 없음
        int i1 = 10;
        double d5 = i1;
        System.out.println(d5);

        // doubl -> int는 묵시적 형변환은 불가능 (명시적은 가능. 단, 소수점 잘림)
        double d6 = 10.5;
        int i2 = (int) d6;
        System.out.println(i2);


        // 명시적 타입 변환
        char ch2 = 'a';
        int ch2_num = (int) ch2; // 명시적 타입 변환 (위와 비교)

        System.out.println((int) 'a'); // 97이 나옴
        System.out.println((int) 'b'); // 98이 나옴

        // 형변환 관련 나눗셈 문제
        int aaa = 1;
        int bbb = 4;
        int c = 1/4;
        double d = (double) 1/4; // int / int이므로 결과값을 int로 판단해서 소수점을 잘라냄 (자동으로)
        double dd = 1/4; // 두 값중 한값만이라도 double로 명시적 형변환 시켜주면 결과값 double됨
        // 위 두 경우 다른 값이 나옴

        System.out.println(c);
        System.out.println(d);

        // 변수와 상수
        int aaa1 = 10;
        // 변수값 재할당
        aaa1 = 20;
        System.out.println(aaa1);

        // 상수는 초기화 이후에 값이 재할당되는 것이 불가능⭐
        // 상수는 final로 키워드를 통해 표현
        final int ages = 20;
        // ages = 30;




    }
}
