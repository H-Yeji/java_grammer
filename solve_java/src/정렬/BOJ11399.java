package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11399 {
    // 실버4 ATM
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(st. nextToken());
        }
        Arrays.sort(times);

        int[] totalTime = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            totalTime[i] = totalTime[i - 1] + times[i - 1];
        }
        System.out.println(Arrays.stream(totalTime).sum());
    }
}
