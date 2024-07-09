package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14247 {

    // 나무자르기 - 실버2
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        // 초기 나무 길이
        int[] input_tree = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input_tree[i] = Integer.parseInt(st.nextToken());
        }
        // 하루에 자라는 길이
        int[] len = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            len[i] = Integer.parseInt(st.nextToken());
        }

        // 나무길이 초기화
        int[][] tree = new int[n][2]; // 초기 길이, 자라는 길이
        for (int i = 0; i < n; i++) {
            tree[i] = new int[]{input_tree[i], len[i]};
        }
        // 나무 베어가기
        long result = 0;
        Arrays.sort(tree, (a, b) -> a[1] - b[1]); // 길이로 오름차순
        for (int i = 0; i < n; i++) {
            result += (tree[i][0] + (long) tree[i][1] * i);
        }
        System.out.println(result);
    }
}

