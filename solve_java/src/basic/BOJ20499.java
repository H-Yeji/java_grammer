package basic;

import java.util.Scanner;

public class BOJ20499 {

    // Darius님 한타 안 함?
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();
        String[] stArr = st.split("/");

        int k = Integer.parseInt(stArr[0]);
        int d = Integer.parseInt(stArr[1]);
        int a = Integer.parseInt(stArr[2]);

        if (k + a < d || d == 0) {
            System.out.println("hasu");
        } else {
            System.out.println("gosu");
        }
        sc.close();
    }
}
