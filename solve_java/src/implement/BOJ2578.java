package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2578 {
    // 실버4 빙고
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] arr = new int[5][5];
        List<List<Map<Integer, Integer>>> check = new ArrayList<>();
        // 입력 및 가로 빙고 저장
        for (int i = 0; i < 5; i++) {
            List<Map<Integer, Integer>> row = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                Map<Integer, Integer> map = new HashMap<>();
                map.put(arr[i][j], 0);
                row.add(map);
            }
            check.add(row);
        }
        // 세로 빙고 저장
        for (int i = 0; i < 5; i++) {
            List<Map<Integer, Integer>> row = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(arr[j][i], 0);
                row.add(map);
            }
            check.add(row);
        }
        // 대각선 빙고 저장
        List<Map<Integer, Integer>> row1 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(arr[i][i], 0);
            row1.add(map);
        }
        check.add(row1);
        List<Map<Integer, Integer>> row2 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(arr[i][5 - 1 - i], 0);
            row2.add(map);
        }
        check.add(row2);

        // 탐색
        int bingo = 0, cnt = 0;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int n = Integer.parseInt(st.nextToken());
                cnt++;

                for (int k = 0; k < 12; k++) {
                    List<Map<Integer, Integer>> row = check.get(k);
                    for (Map<Integer, Integer> map : row) {
                        if (map.containsKey(n)) {
                            map.put(n, 1);
                            break;
                        }
                    }
                }
                bingo = 0;
                for (int k = 0; k < 12; k++) {
                    List<Map<Integer, Integer>> row = check.get(k);
                    int zero = 0;
                    for (Map<Integer, Integer> map : row) {
                        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                            if (entry.getValue() == 1) zero++;
                            if (zero == 5) bingo++;
                        }
                        if (bingo == 3) break;
                    }
                    if (bingo == 3) break;
                }
                if (bingo == 3) break;
            }
            if (bingo == 3) break;
        }
        System.out.println(cnt);
    }
}
