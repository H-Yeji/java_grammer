package solve_java;

import java.util.Arrays;
import java.util.Comparator;

public class 구명보트 {

    // 그리디
    public static int solution(int[] people, int limit) {
        int boat = 0;
        int[] take_boat = new int[people.length]; // 보트에 탄사람 체크

        int[] sort_people = Arrays.stream(people) // 내림차순
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(a->a)
                .toArray();

        int i;
        int j = sort_people.length - 1;;
        for (i = 0; i < sort_people.length; i++) {
            if (take_boat[i] == 0 && take_boat[j] == 0) {
                if (sort_people[i] + sort_people[j] <= limit) { // 제한에 걸리지 않으면 -> 둘다 탐
                    take_boat[i] = 1;
                    take_boat[j] = 1;
                    boat++; j--;
                } else { // 제한에 걸리면 몸무게가 많이 나가는 사람부터 태움
                    take_boat[i] = 1;
                    boat++;
                }
            }
        }
        return boat;
    }

    public static void main(String[] args) {

        //int[] people = {70, 50, 80, 50};
        int[] people = {70, 80, 50};
        int limit = 100;
        solution(people, limit);
    }
}
