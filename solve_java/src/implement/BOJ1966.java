package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1966 {

    // 프린터 큐
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());

            Queue<int[]> q = new LinkedList<>();
            Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                q.add(new int[]{num, j});
                pq.add(num);
            }
            int cnt = 0;
            while (true) {
                int[] checkArr = q.peek();
                if (pq.peek() > checkArr[0]) {
                    q.poll(); // 꺼내고
                    q.add(checkArr); // 맨뒤에 넣기
                } else if (pq.peek() == checkArr[0]) { // 같으면 출력
                    if (checkArr[1] == index) {
                        cnt++;
                        break;
                    }
                    pq.poll();
                    q.poll();
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
