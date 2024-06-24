package solve_java;

// ⭐⭐⭐ 백트래킹/dfs
public class 피로도 {

    static boolean[] visited;
    static int cnt = 0;
    public static void dfs(int depth, int k, int[][] dun) {

        for (int i = 0; i < dun.length; i++) {
            if (visited[i] || dun[i][0] > k) {
                continue;
            }
            visited[i] = true;
            dfs(depth + 1, k - dun[i][1], dun);
            visited[i] = false;
        }
        cnt = Math.max(cnt, depth);
    }

    public static int solution(int k, int[][] dun) {

        visited = new boolean[dun.length];
        dfs(0, k, dun);
        return cnt;
    }

    public static void main(String[] args) {

        int k = 80; // 현재 피로도
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        System.out.println(solution(k, dungeons));

    }
}
