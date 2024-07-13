package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1931 {

    // 회의실 배정 - 실버1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<long[]> meeting_time = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meeting_time.add(new long[]{start, end});
        }
        // 종료 시간으로 오름차순 정렬
        meeting_time.sort((a, b) -> {
            if (a[1] == b[1]) {
                //return a[0] - b[0];
                return Long.compare(a[0], b[0]);
            } else {
                return Long.compare(a[1], b[1]);
            }
        });

        // 가장 빨리 끝나는 첫번째 회의 선택
        int cnt = 1;
        long tmpEnd = meeting_time.get(0)[1];
        for (int i = 1; i < meeting_time.size(); i++) {
            if (meeting_time.get(i)[0] >= tmpEnd) {
                tmpEnd = meeting_time.get(i)[1]; // 그때의 종료 시각 tmpEnd에 담기
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
