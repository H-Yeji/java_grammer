package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10211 {
    // 실버4 Maximum Subarray
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            int[] inputArr = new int[n];
            int[] sumArr = new int[n];
            int minusCnt = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                inputArr[j] = Integer.parseInt(st.nextToken());
                if (inputArr[j] < 0) minusCnt++;
                if (j == 0) {
                    sumArr[j] = Math.max(inputArr[j], 0);
                } else {
                    sumArr[j] = Math.max(inputArr[j] + sumArr[j - 1], 0);
                }
            }
//            System.out.println(Arrays.toString(sumArr));
            if (minusCnt == n) { // 다 음수일 때
                System.out.println(Arrays.stream(inputArr).max().getAsInt());
            } else {
                System.out.println(Arrays.stream(sumArr).max().getAsInt());
            }
        }
    }
}
