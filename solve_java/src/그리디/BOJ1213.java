package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1213 {

    // 실버3 팰린드롬 만들기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();

        // 정렬
        char[] arr = sentence.toCharArray();
        Arrays.sort(arr); // 문자열 사전순으로 정렬

        char[] result = new char[arr.length];
        int len = arr.length; // 길이 저장

        // i는 앞부터, j는 뒤부터
        int i = 0; int j = arr.length - 1;
        int c = 0; // 글자
        int flag = 0; int cnt = 0;

        while(i <= j && c <= len - 2) {
            if (arr[c] == arr[c + 1]) { // 다음 글자와 같으면
                result[i] = arr[c];
                result[j] = arr[c + 1];
                i++; j--; c += 2;
            } else { // 다음 글자와 다르면
                cnt++;
                if (cnt >= 2) {
                    flag = 1;
                    break; // 짝 없는 수가 두개이상이면 팰린드롬x
                }

                if (len % 2 == 0) { // 다음과 다른데 홀수개이면 팰린드롬x
                    flag = 1;
                    break;
                } else { // 홀수면 가운데에 넣기 (len을 2로 나눈 몫)
                    result[len / 2] = arr[c];
                    c++;
                }
            }
        }
        // 마지막 글자가 남은 경우
        if (c == len - 1) {
            result[len / 2] = arr[c];
        }
        if (flag == 0) {
            String resultString = new String(result);
            System.out.println(resultString);
        } else {
            System.out.println("I'm Sorry Hansoo");
        }
    }
}