package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1374 {
    // 골드5 강의실
    static Queue<int[]> pq = new PriorityQueue<>((a, b) -> {
        if (a[0] != b[0]) {
            return Integer.compare(a[0], b[0]);
        } else {
            return Integer.compare(a[1], b[1]);
        }
    });
    static Queue<Integer> endPq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int classNum = Integer.parseInt(st.nextToken());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            pq.add(new int[]{startTime, endTime});
        }

        int[] now = pq.poll();
        endPq.add(now[1]);
        int room = 1;
        while (!pq.isEmpty()) {
            now = pq.poll();

            if (now[0] >= endPq.peek()) {
                endPq.poll(); // 가장 위에 시간 삭제
                endPq.add(now[1]); // 종료시간 넣기
            } else {
                endPq.add(now[1]);
                room++;
            }
        }
        System.out.println(room);
        br.close();
    }
}
