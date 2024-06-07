package solve_java;

public class 특정_문자_제거하기 {

    public static String solution(String my_string, String letter) {

        String answer = "";
        char letter_ch = letter.charAt(0);
        char[] strArr = my_string.toCharArray();
        for (char i:strArr) {
            if (i!=letter_ch) {
                answer += i;
            }
        }

        //System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {

        String my_string = "BCBdbe";
        String letter = "B";

        solution(my_string,letter);

    }
}
