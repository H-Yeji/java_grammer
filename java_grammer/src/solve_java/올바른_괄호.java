package solve_java;

import java.util.Stack;

public class 올바른_괄호 {

    // stack 사용 -> 100점 안나옴
    static boolean solution(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <s.length(); i++) {
            char c = s.charAt(i);
            // 시작 종료조건
            if (i == 0 && c == ')') return false;

            if (c == '(') { // 여는 괄호 -> push stack
                stack.push(c);
            } else { // 닫는 괄호
                if (stack.isEmpty()) // )가 나왔는데 스택이 비어있으면 종료
                    return false;
                char tmp = stack.pop();
                if (tmp != '(')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        String s = "())";
        System.out.println(solution(s));
    }
}
