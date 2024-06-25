package solve_java;

import java.util.LinkedList;
import java.util.Queue;

public class 네트워크_bfs {

    public static int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int answer = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                bfs(i, computers, visited);
                answer++; // 네트워크 증가
            }
        }
        return answer;
    }
    public static void bfs(int start, int [][] com, boolean[] visted){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visted[start] = true; // 방문처리

        while(!q.isEmpty()){ // q에 값이 있으면
            int node = q.poll();

            for(int i = 0; i < com.length; i++){
                if(com[node][i] == 1 && !visted[i]){
                    q.add(i);
                    visted[i] = true;
                }
            }
        }
    }
    public static void main(String[] args) {

        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 1, 1}};
        //int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        /*int n = 4;
        int[][] computers = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};*/
        System.out.println(solution(n, computers));
    }
}
