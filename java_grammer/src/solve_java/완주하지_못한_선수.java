package solve_java;

import java.util.HashMap;
import java.util.Map;

public class 완주하지_못한_선수 {

    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();

        // for문 돌면서 참가자를 map에 넣기
        for (String s : participant) {
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        System.out.println(map);
        // for문 돌면서 completion에 있는지 확인 -> 있으면 -1
        for (String s : completion) {
            if (map.containsKey(s)) { // completion에 있는 선수면 -1
                map.put(s, map.get(s) - 1);
            }
        }
        System.out.println(map);
        // value=1인 참가자 찾기
        for (String s : map.keySet()) {
            if (map.get(s) == 1) {
                answer += s;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        //String[] participant = {"mislav", "stanko", "mislav", "ana"};
        //String[] completion = {"stanko", "ana", "mislav"};
        System.out.println(solution(participant, completion));
    }
}
