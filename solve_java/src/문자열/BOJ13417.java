package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13417 {
    // 실버3 카드 문자열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                String word = st.nextToken();
                if (j == 0) {
                    sb.append(word);
                } else {
                    if (sb.charAt(0) >= word.charAt(0)) {
                        sb.insert(0, word.charAt(0));
                    } else {
                        sb.append(word);
                    }
                }
            }
            System.out.println(sb);
        }
        br.close();
    }
}
