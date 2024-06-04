package C01Basic;

public class C03Operator {

    public static void main(String[] args) {

        /*// 산술 연산자 : 사칙 연산
        int n1 = 8, n2 = 3;

        // * : 곱셈, / : 나눗셈, % : 나머지
        System.out.println(n1 + n2);
        System.out.println(n1 - n2);
        System.out.println(n1 * n2);
        System.out.println(n1 / n2);
        System.out.println(n1 % n2);*/

        // 대입 연산자
        int n1 = 7;
        int n2 = 7;
        int n3 = 7;
        n1 = n1-3;
        System.out.println(n1);

        int n4 = 10;
        int n5 = 10;
        n4 /= 3;
        System.out.println(n4);
        n5 %= 3;
        System.out.println(n5);

        int a = 10;
        a = a + 1;
        System.out.println(a); // 11
        a += 1;
        System.out.println(a); // 12
        a++;
        System.out.println(a); // 13
        a++; // 후위 증감 연산자
        ++a; // 전위 증감 연산자
        System.out.println(a); // 15

        // 후위 증감 연산자
        int b = 5;
        int c = b++;
        int d = ++b;
        System.out.println(c); // 5
        System.out.println(d); // 7

        // 비교 연산자 : ==, !=, >, >= 등
        char ch1 = 'a';
        char ch2 = 'b';
        System.out.println(ch1 == ch2); //false
        System.out.println(ch1 != ch2); //true

        // 논리 연산자 : &&, ||, !
        int num1=10; int num2=20;
        boolean result1;
        result1 = num1 > 5 && num1 < 20;
        System.out.println(result1); // true

        boolean result2;
        result2 = num2 < 10 || num2 < 30;
        System.out.println(result2); //true
        boolean result3 = !(num2 < 10 || num2 < 30);
        System.out.println(result3); //false


        // 비트 연산자 : &, |, ^, ~ (not연산)
        int m1 = 5; // 101
        int m2 = 4; // 100
        int m3 = m1 & m2;
        System.out.println(m3);

        // 시프트연산 : << (왼쪽으로 이동), >> (오른쪽으로 이동)
        // 00000101 => 00001010 (왼쪽으로 한 칸 이동)
        System.out.println(m2 << 1); // 왼쪽으로 한 칸 이동 : 8
    }
}
