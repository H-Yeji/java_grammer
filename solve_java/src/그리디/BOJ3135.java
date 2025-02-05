package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3135 {
    // 실버5 라디오
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()); // 현재 주파수
        int b = Integer.parseInt(st.nextToken()); // 목표 주파수

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int min = Math.abs(b - a);
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(arr[i] - b);
            arr[i] = diff + 1;

            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println(min);
    }
}
