package C02ClassBasic;

import java.util.Scanner;

public class C02MethodPractice {

    public static boolean newMethod(int n) {

        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false; // 소수아님
        }
        return true;

        // void 타입 메서드여도 return;으로 강제종료 가능
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(newMethod(n));
    }
}
