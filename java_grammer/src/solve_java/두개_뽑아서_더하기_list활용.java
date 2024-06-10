package solve_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 두개_뽑아서_더하기_list활용 {

    // 다시 풀어보기
    public static int[] solution(int[] numbers) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (!(list.contains(numbers[i] + numbers[j]))) { // contains 활용
                    list.add(numbers[i] + numbers[j]); // 리스트에 추가할 땐 add 활용
                }
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i); // 값 가지고올 땐 get 활용
        }
        Arrays.sort(answer);
        return answer;
    }

    public static void main(String[] args) {

        int[] numbers = {2, 1, 3, 4, 1};
        System.out.println(Arrays.toString(solution(numbers)));
    }
}
