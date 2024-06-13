package C01Basic;

public class C13StackFunction2 {

    public static void main(String[] args) {

        System.out.println("main함수 시작");
        function1(1);
        System.out.println("main함수 끝");
    }

    static int function1(int a) {

        // 재귀함수 종료조건 필수
        if (a == 5) return 0;
        System.out.println("function1 시작" + a);
        System.out.println("function1 끝");
        return function1(a + 1);
    }
}
