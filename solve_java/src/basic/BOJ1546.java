package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1546 {

    public static void main(String[] args) throws IOException {

        // 평균
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] score = new int[n];
        int maxScore = 0;
        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(st.nextToken());

            maxScore = Math.max(score[i], maxScore);
        }

        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            sum += ((double) score[i] / maxScore * 100);
        }
        System.out.println(sum / n);

        br.close();
    }
}
