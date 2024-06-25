package solve_java;

import java.util.*;

public class 여행경로_2 {
    static boolean[] check;
    static List<List<String>> result;
    static List<String> tmp;
    static boolean lastOrNot;

    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        result = new ArrayList<>();
        check = new boolean[tickets.length]; //visit
        tmp = new ArrayList<>();
        tmp.add("ICN");
        Arrays.sort(tickets, (a,b) -> {
            return a[1].compareTo(b[1]);
        });
        dfs("ICN",tickets);
        System.out.println(result);
    }

    public static void dfs(String start, String[][] tickets){
        if(lastOrNot)return;
        if(tmp.size() == tickets.length+1){
            result.add(new ArrayList<>(tmp));
            lastOrNot=true;
            return;
        }
        for(int i = 0; i < tickets.length; i++){
            if(!check[i] && tickets[i][0].equals(start)){
                tmp.add(tickets[i][1]);
                check[i] = true;
                dfs(tickets[i][1], tickets);
                tmp.remove(tmp.size()-1);
                check[i] = false;
            }
        }
    }
}
