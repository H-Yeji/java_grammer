package solve_java;

import java.util.ArrayList;
import java.util.List;

public class 네트워크_dfs {

    static int n = 3;
    static int[][] computer = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
    static int res = 0;
    static boolean[] visit = new boolean[n];
    static List<List<Integer>> adjList;

    public static void dfs(int start){
        visit[start] = true; // 방문처리
        for(int i : adjList.get(start)){
            if(!visit[i]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) {

        adjList = new ArrayList<>();
        for(int i = 0 ; i < n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < n; j++){
                if(j != i && computer[i][j] == 1){ // 연결이 되어있는 경우
                    adjList.get(i).add(j);
                }
            }
        }

        System.out.println(adjList);
        for(int i = 0 ; i < n ; i++){
            if(!visit[i]){ // 방문하지 않았다면
                dfs(i);
                res++;
            }
        }
        System.out.println(res);
    }
}
