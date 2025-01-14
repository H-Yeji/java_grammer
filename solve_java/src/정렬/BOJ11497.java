package 정렬;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11497 {
    // 실버1 통나무 건너뛰기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int treeCnt = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            // 입력받은 배열 저장 및 정렬
            int[] arr = new int[treeCnt];
            for (int j = 0; j < treeCnt; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            // 길이차의 합이 최소인걸로 정렬
            Queue<Integer> pq = new PriorityQueue<>((a, b) -> {return b - a;});
            // (1) 증가 for문
            int r = 0;
            int[] resort = new int[treeCnt];
            for (int j = 0; j < treeCnt; j += 2) {
                resort[r] = arr[j];
                if (r >= 1) {
                    pq.add(resort[r] - resort[r - 1]); // 통나무 차이를 pq에 넣기
                }
                r++;
            }
            // (2) 감소 for문
            if (treeCnt % 2 == 0) { // 짝수개면 => treeCnt - 1부터 거꾸로
                for (int j = treeCnt - 1; j > 0; j -= 2) {
                    resort[r] = arr[j];
                    pq.add(Math.abs(resort[r] - resort[r - 1]));
                    r++;
                }
            } else { // 홀수개면 => treeCnt - 2부터 거꾸로
                for (int j = treeCnt - 2; j > 0; j -= 2) {
                    resort[r] = arr[j];
                    pq.add(Math.abs(resort[r] - resort[r - 1]));
                    r++;
                }
            }
            bw.write(pq.poll() + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
