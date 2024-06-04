package C01Basic;

import java.util.Scanner;

public class C01InputOutput {
    public static void main(String[] args) {

        // 출력 : System.out(콘솔 출력)
        int a = 20;
        // println : 출력 후 줄바꿈
        // print : 출력 후 줄바꿈 없음
        System.out.print(a);
        String b = "hello world";
        System.out.println(b);
        // 문자열과 숫자를 합하면 문자가 됨
        System.out.println(a + b);

        System.out.println(20 + 10);

        // 입력 : System.in(키보드 입력); + Scanner(입력을 위한 클래스);
        Scanner sc = new Scanner(System.in);
        System.out.println("문자열 입력해랏");

        // nextline은 입력 받은 데이터를 한 줄 읽어서 String으로 리턴
        //String inputs = sc.nextLine();
        //System.out.println(inputs);

        System.out.println("더하기할 두 숫자 입력");
        //int a1 = sc.nextInt();
        //int a2 = sc.nextInt();
        //System.out.println("두 수를 더한 값은 " + a1 + a2 +"입니다.");
        //System.out.printf("두 수를 더한 값은 %d 입니다.", a1 + a2);

        //System.out.println("실수를 입력해주세요");
        //double input_double = sc.nextDouble();
        //System.out.println(input_double);

        System.out.println("True/False를 입력해주세요");
        boolean input_boolean = sc.nextBoolean();
        System.out.println(input_boolean);
        if (input_boolean) {
            System.out.println("hello hello");
        }

        // 입출력 시스템 메모리 해제
        // -> java 밖의 시스템이므로 입출력 시스템 메모리를 해제해주는 것이 좋음
        sc.close();
    }
}
