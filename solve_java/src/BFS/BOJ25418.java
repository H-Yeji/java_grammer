package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ25418 {

    // 실버3 - 정수 a를 k로 만들기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[k + 1];

        // 첫번째 add
        q.add(new int[]{0, a});
        visited[a] = true;
        while (!q.isEmpty()) {
            int[] first = q.poll(); // 첫번재거 꺼내

            // k와 같은지 확인
            if (first[1] == k) {
                System.out.println(first[0]);
                break;
            } else {
                // 첫번째 연산 +1
                if (first[1] + 1 <= k && !visited[first[1] + 1]) {
                    visited[first[1] + 1] = true;
                    q.add(new int[]{first[0] + 1, first[1] + 1});
                }
                // 두번째 연산 *2
                if (first[1] * 2 <= k && !visited[first[1] * 2]) {
                    visited[first[1] * 2] = true;
                    q.add(new int[]{first[0] + 1, first[1] * 2});
                }
            }
        }
    }
}
