package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17413 {

    // 실버3 단어 뒤집기2
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();

        char[] arr = sentence.toCharArray();

        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < arr.length) {
            if (arr[i] == '<') { // 태그시작
                result.append(arr[i]);
                i++;
                while(arr[i] != '>') {
                    result.append(arr[i]);
                    i++;
                }
                result.append(arr[i]); // > 붙여넣기
            }
            else if (arr[i] != '<') { // 단어시작
                StringBuilder newWord = new StringBuilder();
                while(i < arr.length && arr[i] != ' ' && arr[i] != '<') {
                    newWord.append(arr[i]);
                    i++;
                } // 단어 생성
                newWord.reverse(); // 뒤집기
                result.append(newWord);

                if (i >= arr.length) {
                    continue;
                } else if (arr[i] == ' ') {
                    result.append(' ');
                } else if (arr[i] == '<') {
                    continue;
                }
            }
            i++;
        }
        System.out.println(result);
    }
}
