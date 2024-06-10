package basic;

import java.util.Scanner;

public class BOJ13752 {

    // 히스토그램
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();

            for (int j = 0; j < m; j++) {
                System.out.print("=");
            }
            System.out.println();
        }
    }
}
