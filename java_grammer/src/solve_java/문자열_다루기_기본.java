package solve_java;

import java.util.regex.Pattern;

public class 문자열_다루기_기본 {


    public static boolean solution(String s) {
        boolean answer = false;

        if (s.length() == 4 || s.length() == 6) {
            if (s.matches("[0-9]+")) {
                answer = true;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        //String s = "a234";
        String s = "1234";

        System.out.println(solution(s));

    }
}
