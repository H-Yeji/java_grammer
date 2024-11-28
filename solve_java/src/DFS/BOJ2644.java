package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2644 {
    // 실버2 촌수계산 (dfs)
    static List<Integer>[] relation;
    static Stack<int[]> stack;
    static int[] visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        // relation 그래프 생성 & visited 그래프 생성
        relation = new ArrayList[n+1];
        for (int i = 1; i < n+1; i++) {
            relation[i] = new ArrayList<>();
        }
        visited = new int[n+1];

        st = new StringTokenizer(br.readLine());
        int parent = Integer.parseInt(st.nextToken());
        int child = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            relation[a].add(b);
            relation[b].add(a);
        }

        stack = new Stack<>();
        stack.add(new int[]{0, parent});
        while(!stack.isEmpty()) {
            int[] check = stack.peek();
            if (check[1] == child) {
                result = check[0];
                break;
            }
            stack.pop();
            visited[check[1]] = 1; // 지운거 방문처리

            for (int i = 0; i < relation[check[1]].size(); i++) {
                if (visited[relation[check[1]].get(i)] != 1) { // 방문 안했으면
                    stack.add(new int[]{check[0]+1, relation[check[1]].get(i)});
                }
            }
        }
        if (result != 0) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }
}
