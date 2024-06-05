package basic;

import java.util.Scanner;

public class BOJ10808 {

    // 알파벳 개수 -> 아스키코드 사용해보기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int[] arr = new int[26]; // 크기 24
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            int index = c - 97;

            arr[index] += 1;
        }
        for (int i = 0; i < 26; i++) {
            System.out.printf("%d ", arr[i]);
        }
    }
}
