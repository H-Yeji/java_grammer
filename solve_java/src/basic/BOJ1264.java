package basic;

import java.util.Scanner;

public class BOJ1264 {

    // 모음의 개수
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String st = sc.nextLine();
            int cnt = 0;

            // 종료조건
            if (st.charAt(0) == '#') break;

            for (int i = 0; i < st.length(); i++) {
                if ((st.charAt(i) == 'a') || (st.charAt(i) == 'e') || (st.charAt(i) == 'i') || (st.charAt(i) == 'o') || (st.charAt(i) == 'u')
                || (st.charAt(i) == 'A') || (st.charAt(i) == 'E') || (st.charAt(i) == 'I') || (st.charAt(i) == 'O') || (st.charAt(i) == 'U')) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
