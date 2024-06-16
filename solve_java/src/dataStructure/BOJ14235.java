package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14235 {

    // 크리스마스 선물
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 우선순위 큐
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            if (a == 0) {
                if (pq.isEmpty()) // 큐가 비어있으면 -1출력
                    System.out.println(-1);
                else
                    System.out.println(pq.poll());
            } else {
                for (int j = 0; j < a; j++) { // j개만큼 선물입력
                    pq.add(Integer.parseInt(st.nextToken()));
                }
            }
        }
    }
}
