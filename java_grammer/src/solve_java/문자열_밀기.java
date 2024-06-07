package solve_java;
import java.util.Arrays;

public class 문자열_밀기 {

    public static int solution(String a, String b) {

        char[] ch1 = a.toCharArray();
        char[] ch2 = b.toCharArray();
        char[] tmp = new char[ch1.length];

        int cnt = 0;
        while (true) {
            // 처음부터 같은 경우 종료
            if (Arrays.equals(ch1, ch2)) break;

            // 문자 이동
            for (int i = 0; i < a.length(); i++) {
                tmp[(i + 1) % ch1.length] = ch1[i];
            }
            cnt++;
            // 변환한 문자열이 ch2와 같으면 종료
            if (Arrays.equals(ch2, tmp)) break;

            // 다 돌아도 문자열이 같지 않으면 -1로 종료
            if (cnt == ch2.length) {
                cnt = -1;
                break;
            }
            // 문자 이동을 반복하기 위해 tmp를 ch1에 없데이트
            System.arraycopy(tmp, 0, ch1, 0, tmp.length);
        }
        return cnt;
    }

    public static void main(String[] args) {

        String a = "abc";
        String b = "bca";

        System.out.println(solution(a, b));
    }
}


/**
 * return (B+B).indexOf(A); // ㅎ 개쩐다
 */