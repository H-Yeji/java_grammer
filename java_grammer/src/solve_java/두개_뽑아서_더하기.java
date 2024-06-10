package solve_java;

import java.util.Arrays;

public class 두개_뽑아서_더하기 {

    public static int[] solution(int[] numbers) {
        int[] tmp = new int[10000];
        int cnt = 0;
        // 더하기 조합
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                tmp[cnt] = numbers[i] + numbers[j];
                cnt++;
            }
        }
        // 개수만큼 copy
        int[] tmp2 = Arrays.copyOfRange(tmp, 0, cnt);
        // 정렬
        Arrays.sort(tmp2);
        // 중복 제거
        int[] tmp3 = new int[10000];
        int cnt2 = 0;
        for (int i = 0; i < tmp2.length; i++) {
            if (i != 0 && tmp2[i - 1] == tmp2[i]) continue;

            tmp3[cnt2] = tmp2[i];
            cnt2++;
        }
        tmp3 = Arrays.copyOfRange(tmp3, 0, cnt2);
        return tmp3;
    }

    public static void main(String[] args) {

        int[] numbers = {2, 1, 3, 4, 1};
        System.out.println(Arrays.toString(solution(numbers)));
    }
}
