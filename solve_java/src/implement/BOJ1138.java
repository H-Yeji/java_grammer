package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1138 {
    // 실버2 한 줄로 서기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[n];
        for (int i = 1; i <= n; i++) { // 1~n까지 사람
            int now = arr[i - 1]; // 첫번째부터 시작

            // now만큼 탐색하며 1씩 빼다가, 0이 되면 그 위치에서 기준으로 왼쪽에 now명 만큼 있다는 뜻이므로 해당 위치에 저장
            for (int j = 0; j < n; j++) {
                if (result[j] == 0) {
                    if (now == 0) {
                        result[j] = i;
                        break;
                    }
                    now--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb.toString().trim()); // 마지막 " " 제외하고 출력
    }
}
