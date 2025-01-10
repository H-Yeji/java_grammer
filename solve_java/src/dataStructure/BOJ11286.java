package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ11286 {
    // 실버1 절댓값 힙
    static Queue<Integer> pq = new PriorityQueue<>((a, b) -> {
        if (Math.abs(a) != Math.abs(b)) { // 절댓값 다르면
            return Integer.compare(Math.abs(a), Math.abs(b)); // 절댓값으로 크기비교
        } else { // 절댓값 같으면
            return Integer.compare(a, b); // 원래 숫자로 비교
        }
    });
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                pq.add(num);
            }
        }
        br.close();
    }
}
