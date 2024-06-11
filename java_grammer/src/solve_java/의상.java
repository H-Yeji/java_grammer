package solve_java;

import java.util.HashMap;
import java.util.Map;

public class 의상 {

    public static int solution(String[][] clothes) {
        int sum = 1;

        Map<String, Integer> type= new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            type.put(clothes[i][1], type.getOrDefault(clothes[i][1], 0) + 1);
        }

        for (String s : type.keySet()) {
            sum *= type.get(s) + 1; // 각 의상의 종류마다 착용한 경우 + 안착용한 경우(1)
        }
        sum -= 1; // 근데 다 안입을 순 없으므로 -1

        return sum;
    }

    public static void main(String[] args) {

        //String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        System.out.println(solution(clothes));
    }
}
