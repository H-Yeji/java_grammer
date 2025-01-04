package 정렬;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ11656 {
    // 실버4 접미사 배열
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(sc.next());

        String[] arr = new String[sb.length()];
        int i = 0;
        arr[i] = String.valueOf(sb);
        while (sb.length() > 1) {
            i++;
            arr[i] = String.valueOf(sb.deleteCharAt(0));
//            System.out.printf("i:%d, 문자:%s\n", i, sb);
        }

        Arrays.sort(arr);
        for (int j = 0; j < arr.length; j++) {
            System.out.println(arr[j]);
        }
    }
}
