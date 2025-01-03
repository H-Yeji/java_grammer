package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ1026 {
    // 실버4 보물
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        // 배열A
        int[] arrA = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        // 배열B
        int[] arrB = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }
        // A 오름차순 정렬
        Arrays.sort(arrA);
        // B를 내림차순 정렬
        // reverseOrder 사용을 위해 boxed()를 이용해 int[]를 Integer[]로 변환
        Integer[] sortedArrB = Arrays.stream(arrB).boxed().toArray(Integer[]::new);
        Arrays.sort(sortedArrB, Collections.reverseOrder());

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (arrA[i] * Integer.parseInt(String.valueOf(sortedArrB[i])));
        }
        System.out.println(sum);
    }
}
