package basic;

import java.util.Scanner;

public class BOJ9316 {

    // Hello Judge
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.printf("Hello World, Judge %d!\n", (i+1));
        }
        sc.close();
    }
}
