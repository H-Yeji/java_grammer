package solve_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 여행경로 {

    public static void main(String[] args) {
        //String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        //String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        String[][] tickets = {{"AAA", "BBB"}, {"AAA", "CCC"}, {"CCC", "AAA"}};
        System.out.println(solution(tickets));
    }

    static boolean[] visit;
    static List<String> res = new ArrayList<>();

    public static List<String> solution(String[][] tickets) {

        visit = new boolean[tickets.length]; // 방문 배열 생성
        Arrays.sort(tickets, (a,b) -> {
            return a[1].compareTo(b[1]); // 배열 1번째 값으로 오름차순 정렬
        });
        dfs("AAA", tickets, new ArrayList<>());

        return res;
    }

    public static boolean dfs(String start, String[][] tickets, List<String> path){
        path.add(start);
        System.out.println("add했을 때의 path : " + path);
        if (path.size() == tickets.length + 1) {
            res.addAll(path);
            System.out.println("result : " + res);
            return true;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (!visit[i] && tickets[i][0].equals(start)) {
                visit[i] = true;
                if (dfs(tickets[i][1], tickets, path)) {
                    return true;
                }
                visit[i] = false;
            }
        }
        path.remove(path.size() - 1); // 해당 공항에서 출발하는 공항이 없는 경우 -> 경로를 이어갈 수 없으므로 remove
        System.out.println("remove 했을 때의 path : " + path);
        return false;
    }
}
