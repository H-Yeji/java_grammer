package solve_java;

import java.util.ArrayList;
import java.util.List;

public class 네트워크 {

    static List<List<Integer>> adjList;

    public static int solution(int n, int[][] computers) {
        int answer = 0;

        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1 && i != j) { // 연결되어 있다면
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        System.out.println(adjList);
        int notNetwork = 0;
        for (int i = 0; i < n; i++) {
            if (adjList.get(i).isEmpty()) {
                notNetwork++;
            }
        }
        if (notNetwork == n) {
            answer = notNetwork;
        } else {
            answer = notNetwork + 1;
        }
        return answer;
    }
    public static void main(String[] args) {

        //int n = 3;
        //int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        //int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int n = 4;
        int[][] computers = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        System.out.println(solution(n, computers));
    }
}
