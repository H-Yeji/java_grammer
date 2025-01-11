package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ15903 {
    // 실버1 카드 합체 놀이
    static Queue<Long> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.add(Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            // 두 번 poll하기
            long num1 = pq.poll();
            long num2 = pq.poll();
            long sum = num1 + num2;
            // 계산 결과 두 번 넣기 (x+y의 결과로 x와 y를 모두 업데이트)
            pq.add(sum);
            pq.add(sum);
        }
        long result = 0;
        while (!pq.isEmpty()) {
            result += pq.poll();
        }
        System.out.println(result);
    }
}
