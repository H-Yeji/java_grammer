package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ19941 {

    // 햄버거 분배 - 실버3
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String str = br.readLine();
        char[] ch = new char[n];
        ch = str.toCharArray(); // string to array

        int[] check = new int[n];
        for (int i = 0; i < n; i++) {
            if (ch[i] == 'H') {  // 햄버거 체크
                check[i]++;
            }
        }

        // 양쪽 k만큼 dx 만들기
        int[] dx = new int[k*2+1];
        for (int i = 0; i <= k * 2; i++) {
            dx[i] = -k + i;
        }

        // 햄버거 분배
        for (int i = 0; i < n; i++) {
            if (ch[i] == 'P' && check[i] == 0) { // 해당 인덱스가 사람이면서 햄버거를 받지 못한 경우 진행
                for (int j = 0; j < dx.length; j++) { // 미리 생성해둔 dx 좌표를 이동하면서 확인
                    if (i + dx[j] >= 0 && i + dx[j] < n) { // 이동한 좌표가 전체 범위 내면서,
                        if (ch[i + dx[j]] == 'H' && check[i + dx[j]] == 1) { // 이동한 좌표의 문자가 '햄버거'를 가리키고, 아직 분배하지 않은 햄버거라면
                            check[i + dx[j]] = 0; // 햄버거 나눠줘서 0만들고
                            check[i]++; // 사람 +1 (햄버거 받은 사람)
                            break;
                        }
                    }
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (ch[i] == 'P' && check[i] != 0) cnt++;
        }
        System.out.println(cnt);
    }
}
