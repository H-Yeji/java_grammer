package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2847 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 개수
        int[] list = new int[n]; // n개만큼 리스트 생성

        int total = 0;
        // 입력
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            list[i] = input;
        }
        // 계산 후 출력
        for (int i = n - 2; i >= 0; i--) {
            if (list[i] >= list[i + 1]) {
                int de = 0;
                if (list[i] == list[i + 1]) {
                    de = 1;
                } else {
                    de = list[i] - list[i + 1] + 1;
                }
                total += de;

                list[i] = list[i] - de;
            }
        }
        System.out.println(total);
    }
}
