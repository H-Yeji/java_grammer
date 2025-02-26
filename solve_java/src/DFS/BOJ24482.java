package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ24482 {
    // 실버2 알고리즘 수업 - 깊이 우선 탐색4
    static int[] depth;
    static List<List<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken()); // 시작정점

        depth = new int[n + 1];
        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
            depth[i] = -1;
        }

        int start, end;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            list.get(start).add(end);
            list.get(end).add(start);
        }

        // 각 리스트마다 내림차순 정렬
        list.forEach(x -> x.sort(Collections.reverseOrder()));
//        System.out.println(list.toString());

        dfs(r, 0); // 시작과 0
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(depth[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int index, int cnt) {
        depth[index] = cnt;

        for (int i: list.get(index)) {
            if (depth[i] == -1) {
                dfs(i, cnt + 1); // depth하나 올려서 dfs 재탐색
            }
        }
    }
}
