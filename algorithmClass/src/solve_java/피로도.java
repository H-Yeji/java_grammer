package solve_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 피로도 {

    static List<int[]> adjList;
    static List<Integer> tmp;
    static List<List<int[]>> result;
    static int[] visited;

    public static void check(List<int[]> tmp, int[][] dun, int k) {

        if (tmp.size() == dun.length) {
            result.add(new ArrayList<>(tmp));
        }
        for (int i = 0; i < dun.length; i++) {
            tmp.add(dun[i]);
            check(tmp, dun, k);
            tmp.remove(tmp.size() - 1);
        }
    }
    public static int solution(int k, int[][] dun) {
        int answer = -1;

        adjList = new ArrayList<int[]>();
        for (int i = 0; i < dun.length; i++) {
            adjList.add(dun[i]);
        }



        return answer;
    }

    public static void main(String[] args) {

        int k = 80; // 현재 피로도
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        solution(k, dungeons);

    }
}
