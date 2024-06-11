package solve_java;

import java.util.*;

public class 문자열_내_마음대로_정렬하기 {

    public static String[] solution(String[] cars, int n) {

        Map<String, String> treeMap = new TreeMap<>();
        for (String a : cars) {
            treeMap.put(a.charAt(n)+a, a); // ebed, acar, usun으로
        }

        String[] answer = new String[cars.length];
        int count = 0;
        for (String a : treeMap.values()) {
            answer[count] = a;
            count++;
        }

        System.out.println(Arrays.toString(answer));

        return answer;
    }

    public static void main(String[] args) {
        String[] cars = {"sun", "bed", "car"};
        //String[] cars = {"abce", "abcd", "cdx"};
        int n = 1;
        solution(cars, n);
    }
}
