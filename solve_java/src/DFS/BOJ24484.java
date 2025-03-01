package DFS;

import java.io.*;
import java.util.*;

public class BOJ24484 {
    // 실버2 알고리즘 수업-깊이 우선 탐색6
    static int[] depth;
    static int[] order;
    static int orderNum = 1;
    static List<List<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        depth = new int[n + 1];
        order = new int[n + 1];
        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) { // 초기화
            list.add(new ArrayList<>());
            depth[i] = -1;
            order[i] = 0;
        }

        int start, end;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            list.get(start).add(end);
            list.get(end).add(start);
        }

        // 인접 정점 내림차순 정렬
        list.forEach(x -> x.sort(Collections.reverseOrder()));

        dfs(r, 0);

        // 출력
        long result = 0;
        for (int i = 1; i <= n; i++) {
            result += ((long) depth[i] * order[i]);
        }
        System.out.println(result);
        br.close();
    }

    private static void dfs(int index, int cnt) {
        depth[index] = cnt;
        order[index] = orderNum++;

        for (int i : list.get(index)) {
            if (depth[i] == -1) {
                dfs(i, cnt + 1);
            }
        }
    }
}
