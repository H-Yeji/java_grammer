package solve_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class 같은_숫자는_싫어 {

    public static int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();

        int stackLength = 0;
        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (stack.peek() != arr[i]) {
                stack.push(arr[i]);
                stackLength++;
            }
        }

        int cnt = 0;
        int[] tmp = new int[stackLength + 1];
        while (!stack.isEmpty()) {
            tmp[cnt] = stack.pop();
            cnt++;
        }
        // 뒤집기
        int[] answer = new int[stackLength + 1];
        for (int i = cnt - 1, j = 0; i >= 0; i--, j++) {
            answer[j] = tmp[i];
        }
        return answer;


        /**
         * for (int a : arr) {
         *  if (stack.isEmpty()) {
         *          stack.push(a);
         *      }
         * } else {
         *      if (stack.peek() != a ) {
         *          stack.push(a);
         *      }
         * }
         *  // 뒤집는 코드 필요
         */

    }

    public static void main(String[] args) {

        int[] arr = {4,4,4,3,3};
        System.out.println(Arrays.toString(solution(arr)));
    }
}
