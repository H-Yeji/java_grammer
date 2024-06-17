package basic;

import java.util.Scanner;

public class BOJ11720 {

    // 숫자의 합
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String st = sc.next();

        int sum = 0;
        for (int i = 0; i < n; i++) {
            char ch = st.charAt(i);
            sum += Integer.parseInt(String.valueOf(ch));
        }
        System.out.println(sum);
        sc.close();
    }
}
