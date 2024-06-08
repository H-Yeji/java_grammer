package basic;

import java.util.Scanner;

public class BOJ11365 {

    // !밀비 급일
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            String st = sc.nextLine();

            // 종료조건
            if (st.equals("END")) break;

            char[] ch = st.toCharArray();
            String answer = "";
            for (int i = ch.length - 1; i >= 0; i--) {
                answer += ch[i];
            }
            System.out.println(answer);
        }
    }
}
