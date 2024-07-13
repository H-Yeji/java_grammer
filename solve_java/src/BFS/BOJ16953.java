package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16953 {

    // A->B - 실버2 (bfs로 풀었음)
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Queue<long[]> q = new LinkedList<>(); // 숫지, cnt
        long cnt = 0; long result = -1;
        // 첫번째 연산 넣기
        q.add(new long[]{a * 2L, cnt + 1});
        q.add(new long[]{a * 10L + 1, cnt + 1});
        while (!q.isEmpty()) {
            long[] tmp = q.poll();
            //System.out.println(Arrays.toString(tmp));
            if (tmp[0] == b) {
                result = tmp[1]+1;
                break;
            }
            // 연산
            long calA = tmp[0] * 2;
            long calB = tmp[0] * 10 + 1;
            //System.out.printf("%d %d\n", calA, calB);

            // b와 비교해서 더 작으면 q에 add
            if (calA <= b) {
                q.add(new long[]{calA, tmp[1] + 1});
            }
            if (calB <= b) {
                q.add(new long[]{calB, tmp[1] + 1});
            }
        }
        System.out.println(result);
    }
}
