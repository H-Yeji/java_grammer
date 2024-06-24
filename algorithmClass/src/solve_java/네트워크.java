package solve_java;

import java.util.ArrayList;
import java.util.List;

public class 네트워크 {

    static List<List<Integer>> adjList;
    public static int solution(int n, int[][] computers) {
        int answer = 0;

        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int[][] arr = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int n = 3;
        solution(n, arr);

    }
}
