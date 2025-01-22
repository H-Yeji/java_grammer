package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1474 {
    // 실버1 밑 줄
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 문자열
        String[] words = new String[n];
        int totalLen = 0;
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
            totalLen += words[i].length();
        }

        int leftString = m - totalLen; // 남은 문자 수
        int share = leftString / (n - 1); // 몫
        int left = leftString % (n - 1); // 나머지
//        System.out.printf("남은 문자: %d, 몫: %d, 나머지: %d\n", leftString, share, left);

        int[] underBar = new int[n - 1];
        Arrays.fill(underBar, share); // 몫으로 개수 초기화 ⭐

        // 남은 글자 개수만큼 반복
        for (int i = 1; i < words.length; i++) {
            if (left == 0) break;
            if (words[i].charAt(0) >= 'a' && words[i].charAt(0) <= 'z') { // 소문자 앞에 _추가
//                System.out.printf("yes, %d번째\n", i);
                underBar[i - 1] += 1;
                left--;
            }
        }

        // 한바퀴 돌았는데 left가 0이 안됐으면 뒤에있는 것부터 대문자 앞에 _추가
        for (int i = words.length - 1; i > 0; i--) {
            if (left == 0) break;
            if (words[i].charAt(0) >= 'A' && words[i].charAt(0) <= 'Z') {
                underBar[i - 1] += 1;
                left--;
            }
        }
//        System.out.println(Arrays.toString(words));
//        System.out.println(Arrays.toString(underBar));

        // 출력하기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < underBar.length; i++) {
            sb.append(words[i]);
            sb.append("_".repeat(underBar[i]));
        }
        sb.append(words[words.length - 1]);
        System.out.println(sb);
    }
}
