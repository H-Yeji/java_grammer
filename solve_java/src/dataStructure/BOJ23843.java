package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ23843 {
    // 골드5 콘센트
    static Queue<Integer> devices = new PriorityQueue<>((a, b) -> b - a); // 내림차순
    static Queue<Integer> charging = new PriorityQueue<>((a, b) -> a - b); // 오름차순
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            devices.add(Integer.parseInt(st.nextToken())); // 8 4 4 1 1
        }

        // 콘센트 개수만큼 charging에 넣기
        charging(m);

        int result = 0;
        while (!charging.isEmpty()) {
            int timeTaken = charging.peek(); // 지금 충전 소요 시간

            for (int i = 0; i < m; i++) {
                if (charging.peek() - timeTaken == 0) { // 소요 시간이랑 딱 맞으면 해당 전자기기 충전 완료(poll)처리
                    charging.poll();
                } else { // 아직 전자기기의 충전 시간이 더 남은 경우
                    q.add(charging.poll() - timeTaken); // 남은 시간 계산해서 q에 넣어놓기
                }

                if (charging.isEmpty()) break; // 충전소에 암것도 없으면 break (다음 전자기기 가져와)
            }

            while (!q.isEmpty()) { // 충전시간 남은애들 charging 큐에 다시 보내버려 => 마저 충전해야지
                charging.add(q.poll());
            }

            result += timeTaken; // 지금까지 충전 작업한 시간 저장
            charging(m); // 또 charging 큐에 전자기기 넣으러 고고
        }
        System.out.println(result);
    }

    private static void charging(int m) {
        while (charging.size() < m) {
            if (devices.isEmpty()) break;

            charging.add(devices.poll()); // 충전공간 남았어 전자기기 더 가져와 !
        }
    }
}
