package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ23351 {
    // 실버3 물주기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 화분 개수
        int k = Integer.parseInt(st.nextToken()); // 처음 수분량
        int a = Integer.parseInt(st.nextToken()); // 매일 연속a개 물주기
        int b = Integer.parseInt(st.nextToken()); // 한 번 물 줄 때 수분량 b만큼 증가

        Map<Integer, Integer> plants = new HashMap<>();
        // 초기화
        for (int i = 0; i < n; i++) {
            plants.put(i + 1, k); // {1=3, 2=3, 3=3, 4=3, 5=3, 6=3}
        }

        // 탐색
        int day = 0, cnt = 0;
        while (true) {
            day++;
            // (1) 모든 화분 수분량 -1
            for (int i = 0; i < n; i++) {
                plants.put(i + 1, plants.get(i + 1) - 1);
            }
            // (2) 연속 a개의 화분 b만큼 수분량 증가
            for (int i = cnt; i < cnt + a; i++) {
                plants.put(i + 1, plants.get(i + 1) + b);
            }
            cnt += a;
            if (cnt >= n) cnt = 0; // 다시 첫번째 화분부터 순환하기 위해 0으로 초기화

            // 반복문 종료 체크
            int flag = 0;
            for (int i = 0; i < n; i++) {
                if (plants.get(i + 1) == 0) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) break;
        }
        System.out.println(day);
    }
}
